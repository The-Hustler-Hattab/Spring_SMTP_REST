package com.mtattab.emailservice.controller;

import com.mtattab.emailservice.service.SMTP;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@Slf4j
public class SMTPController {


    @Autowired
    SMTP smtp;

    @GetMapping("/getListOfEmails")
    public String showItems(Model model) {
        List<String> emails=smtp.getAllEmails().getEmails();

        model.addAttribute("ListOfEmails", emails);

        return "home";
    }
}
