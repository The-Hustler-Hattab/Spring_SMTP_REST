package com.mtattab.emailservice.restcontroller;
import com.mtattab.emailservice.consts.Constants;
import com.mtattab.emailservice.model.EmailJsonModel;
import com.mtattab.emailservice.model.ResponseRestModel;
import com.mtattab.emailservice.service.SMTP;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;

@RestController
@RequestMapping(path = "/v1/api", produces = Constants.JSON)
@Validated
public class EmailController {

    @Autowired
    SMTP smtp;


    @PostMapping("/sendEmail")
    public ResponseEntity<ResponseRestModel> sendEmail(@RequestBody @Valid EmailJsonModel emailJsonModel) {
        smtp.setFromEmail(emailJsonModel.getFromEmail());
        ResponseRestModel responseRestModel= smtp.sendEmail(
                emailJsonModel.getToEmail(), emailJsonModel.getSubject(), emailJsonModel.getMessageText(), emailJsonModel.isHtmlEnabled());

        return new ResponseEntity<>(responseRestModel, HttpStatusCode.valueOf(responseRestModel.getStatusCode()));
    }
    @GetMapping("/getAllEmails")
    public ResponseEntity<ResponseRestModel> getAllEmails() {
        ResponseRestModel responseRestModel= smtp.getAllEmails();

        return new ResponseEntity<>(responseRestModel, HttpStatusCode.valueOf(responseRestModel.getStatusCode()));
    }

}
