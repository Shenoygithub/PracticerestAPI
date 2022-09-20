package com.bethehero.test;

import com.bethehero.model.request.NewCaseRequest;
import com.bethehero.model.request.RegistrationRequest;
import com.bethehero.model.request.UpdateAccount;
import com.bethehero.model.response.NewCaseResponse;
import com.bethehero.model.response.RegistrationResponse;
import com.bethehero.model.response.UpdateAccountResponse;
import com.bethehero.utils.PropertyHelper;
import com.bethehero.utils.TestDataUtils;
import com.google.gson.Gson;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Properties;

import static io.restassured.RestAssured.given;

public class RegistrationTest extends BaseTest {
 public static String id = "";
    public static String id1 = "";
    @Test(description = "Register new user", priority = 1)
    //@BeforeMethod
    public void getUserTest(){
        RegistrationRequest reg = new RegistrationRequest(TestDataUtils.getRandomName(),
                TestDataUtils.getRandomEmail(),
                TestDataUtils.getRandomWhatsappNumber().toString(),
                TestDataUtils.City.MANGALORE.toString(),
                TestDataUtils.Code.KA.toString());
        Gson gson = new Gson();
        String registrationGson = gson.toJson(reg);
        RegistrationResponse response =given()
                .log()
                .all()
                .headers("Content-Type","application/json")
                .body(registrationGson).
                when()
                .post("ongs").
                then().log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                .as(RegistrationResponse.class);
        System.out.println(response.getId());
        id = response.getId();
    }
    @Test(description = "Register new Case",priority = 2)
    public void registerNewCase() {
        NewCaseRequest caseRequest = new NewCaseRequest(TestDataUtils.getRandomTitle(), TestDataUtils.getRandomDescription(),
                TestDataUtils.getInt().toString());
        Gson gson = new Gson();
        String caseRequestJson = gson.toJson(caseRequest);
        Response caseResponse = given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .header("Authorization", id)
                .body(caseRequestJson).
                when()
                .post("incidents");
//                then().log()
//                .all();
//                //.assertThat("Verify the statusCode",)
//                .statusCode(200)
//                .extract()
    //            .as(NewCaseResponse.class);
        UpdateAccountResponse regRes = caseResponse.as(UpdateAccountResponse.class);
        id1 = regRes.getId();
        System.out.println(id1);
        System.out.println(caseResponse.getStatusCode());
        Assert.assertEquals(caseResponse.getStatusCode(), 200, "registers new case");

    }@Test(description = "Update Account Details",priority = 3)
    public void updateAccountDetails() {
        UpdateAccount account = new UpdateAccount(TestDataUtils.getRandomName(),TestDataUtils.getRandomEmail(),
                TestDataUtils.getRandomWhatsappNumber().toString(),TestDataUtils.City.BANGALORE.toString(),
                TestDataUtils.Code.MH.toString());
        Gson gson = new Gson();
        String accountJson = gson.toJson(account);
        UpdateAccountResponse response  = given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .header("Authorization", id)
                .body(accountJson).
                when()
                .put("ongs/"+id).
               then().log()
                .all()
                .assertThat()
                .statusCode(200)
                .extract()
                    .as(UpdateAccountResponse.class);
        System.out.println(response.getId());
        id = response.getId();
//        System.out.println(Response.getStatusCode());
//        Assert.assertEquals(Response.getStatusCode(), 200, "updated Account Details");


    }
    @Test(description = "Delete Case",priority = 4)
    public void deleteCase() {
        given()
                .log()
                .all()
                .header("Content-Type", "application/json")
                .header("Authorization", id).
                when()
        // pathParams("id",id1)
                .delete("incidents/"+id1).
                then().log()
                .all()
                .assertThat()
                .statusCode(204);

        //config using String path
        //Properties deleteProperty = PropertyHelper.
        //       loadPropertiesFile(System.getProperty("user.dir") + "/delete.properties");
    }


    }

