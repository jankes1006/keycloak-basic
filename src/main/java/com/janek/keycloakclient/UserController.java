package com.janek.keycloakclient;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

@RestController
public class UserController {
    @GetMapping("/for-admin")
    @PreAuthorize("hasAuthority('admin')")
    public String getAdmin() {
        return "Hello Admin!";
    }

    @GetMapping("/for-user")
    @PreAuthorize("hasAuthority('user')")
    public String getUser() {
        return "Hello user!";
    }

    @GetMapping
    public String logout(HttpServletRequest httpServletRequest) throws ServletException {
        httpServletRequest.logout();
        return "http:/localhost8081/";
    }
}
