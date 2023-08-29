package com.mtattab.emailservice.model;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmailJsonModel {
    @NotNull
    String fromEmail;
    @NotNull
    String toEmail;
    @NotNull
    String subject;
    @NotNull
    String messageText;
    @NotNull
    boolean isHtmlEnabled;

    @Override
    public String toString() {
        return "EmailJsonModel{" +
                "fromEmail='" + fromEmail + '\'' +
                ", toEmail='" + toEmail + '\'' +
                ", subject='" + subject + '\'' +
                ", messageText='" + messageText + '\'' +
                ", isHtmlEnabled=" + isHtmlEnabled +
                '}';
    }
}
