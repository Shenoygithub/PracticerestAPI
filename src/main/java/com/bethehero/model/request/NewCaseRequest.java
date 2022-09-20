package com.bethehero.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class NewCaseRequest {
        private String title;
        private String description;
        private String value;
    }


