package com.jobportal.controllers;

import com.jobportal.entity.JobPostActivity;
import com.jobportal.entity.Users;
import com.jobportal.services.JobPostActivityService;
import com.jobportal.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class JobSeekerApplyController {
    private final JobPostActivityService jobPostActivityService;
    private  final UsersService userService;
    @Autowired
    public JobSeekerApplyController(JobPostActivityService jobPostActivityService, UsersService userService)
    {
        this.jobPostActivityService=jobPostActivityService;
        this.userService= userService;
    }

    @GetMapping("job-details-apply/{id}")
    public String display(@PathVariable("id") int id, Model model) {
        JobPostActivity jobDetails = jobPostActivityService.getOne(id);

        model.addAttribute("jobDetails", jobDetails);
        model.addAttribute("user", userService.getCurrentUserProfile());
        return "job-details";
    }

}
