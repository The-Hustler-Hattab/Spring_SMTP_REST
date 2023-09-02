package com.mtattab.emailservice.controller;

import com.mtattab.emailservice.model.EmailJsonModel;
import com.mtattab.emailservice.model.ResponseRestModel;
import com.mtattab.emailservice.restcontroller.EmailController;
import com.mtattab.emailservice.service.SMTP;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;

@Controller
public class HomeController {

    @Autowired
    SMTP smtp;


    @Autowired
    EmailController emailController;

    @GetMapping("/")
    public String index() {
        return "index";
    }
    @GetMapping("/home")
    public String home() {
        return "form";
    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }



    @PostMapping("/form")
    public String submitForm(@ModelAttribute("emailModel") EmailJsonModel formData,  RedirectAttributes redirectAttributes) {

        ResponseRestModel responseRestModel= emailController.sendEmail(formData).getBody();

        boolean submissionSuccess = responseRestModel.getStatusCode() == 200;
        if (submissionSuccess){
            redirectAttributes.addFlashAttribute("submissionSuccess", true);

        }else {
            redirectAttributes.addFlashAttribute("submissionFailed", true);

        }
        redirectAttributes.addFlashAttribute("messageResponse", responseRestModel.getStatusMessage());
        return "redirect:/form";
    }
    @GetMapping("/form")
    public String showForm(Model model) {
        EmailJsonModel emailJsonModel = new EmailJsonModel();
        model.addAttribute("emailModel", emailJsonModel );

        List<String> emails=smtp.getAllEmails().getEmails();

        model.addAttribute("ListOfEmails", emails);
        return "home";
    }

}


