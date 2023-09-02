package com.mtattab.emailservice.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.util.Map;


@Slf4j
@ControllerAdvice(annotations = Controller.class)
public class GlobalExceptionController {

    /*

    redirect useres to error page on exceptions
    * */
    @ExceptionHandler({Exception.class})
    public ModelAndView exceptionHandler(Exception exception){
        String errorMsg = null;
        ModelAndView errorPage = new ModelAndView();
        errorPage.setViewName("error");
        if(exception.getMessage()!=null){
            errorMsg = exception.getMessage();
        }else if (exception.getCause()!=null){
            errorMsg = exception.getCause().toString();
        }else if (exception!=null){
            errorMsg = exception.toString();
        }
        errorPage.addObject("errormsg", errorMsg);
        return errorPage;
    }


    @ModelAttribute("currentLoggedInUser")
    public String currentLoggedInUser() {


        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication instanceof AnonymousAuthenticationToken){
            return "";

        }
        OAuth2User principal = (OAuth2User) authentication.getPrincipal();
        Map<String, Object> attributes = principal.getAttributes();

        return (String) attributes.get("name");
    }
}
