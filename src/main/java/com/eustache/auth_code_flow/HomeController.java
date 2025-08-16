package com.eustache.auth_code_flow;

import org.springframework.security.oauth2.client.authentication.OAuth2AuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping
    public String home(OAuth2AuthenticationToken token) {
        if (token == null) {
            return "You are not authenticated. Please log in using OAuth2.";
        }
        String name = token.getName();
        String email = token.getPrincipal().getAttribute("email");
        String role = token.getPrincipal().getAuthorities().iterator().next().getAuthority();
        String authorities = token.getAuthorities().toString();
        System.out.println(name + ", " + email + ", " + role + ", " + authorities);
        return "Welcome to the OAuth2 Authorization Code Flow Example!" +
               " User: " + name +
                " Email: " + email +
                " Role: " + role+
               " with authorities: " + authorities;
    }
}
