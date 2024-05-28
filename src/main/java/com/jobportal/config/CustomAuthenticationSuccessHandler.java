package com.jobportal.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication)
            throws IOException {
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        String userName = userDetails.getUsername();
        System.out.println("The user " + userName + " is logged in");

        boolean hasJobSeeker = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("Job Seeker"));
        boolean hasRecruiter = authentication.getAuthorities().stream().anyMatch(r -> r.getAuthority().equals("Recruiter"));

        if (hasJobSeeker || hasRecruiter) {
            httpServletResponse.sendRedirect("/dashboard/");
        } else {
            httpServletResponse.sendRedirect("/login?error");
        }
    }
}
