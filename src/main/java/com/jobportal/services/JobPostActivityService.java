package com.jobportal.services;

import com.jobportal.entity.JobPostActivity;
import com.jobportal.repository.JobPostActivityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobPostActivityService {

    private final JobPostActivityRepository jobPostActivityRepository;

    @Autowired
    public JobPostActivityService(JobPostActivityRepository jobPost) {
        this.jobPostActivityRepository = jobPost;
    }

    public JobPostActivity addNew(JobPostActivity jobPostActivity){
        return this.jobPostActivityRepository.save(jobPostActivity);
    }
}
