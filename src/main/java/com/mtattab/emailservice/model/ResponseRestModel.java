package com.mtattab.emailservice.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseRestModel {
    int statusCode;
    String statusMessage;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    List<String> emails;

    public ResponseRestModel(int statusCode, String statusMessage){
        this.statusCode=statusCode;
        this.statusMessage= statusMessage;
    }


}
