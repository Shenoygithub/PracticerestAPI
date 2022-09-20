package com.bethehero.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

//POJO
@Data
@AllArgsConstructor
public class RegistrationRequest {

    private String name;
    private String email;
    private String whatsapp;
    private String city;
    private String uf;

}
