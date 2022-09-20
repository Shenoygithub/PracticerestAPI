package com.bethehero.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UpdateAccount {

        private String name;
        private String email;
        private String whatsapp;
        private String city;
        private String uf;

    }
