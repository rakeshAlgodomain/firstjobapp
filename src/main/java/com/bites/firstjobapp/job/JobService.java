package com.bites.firstjobapp.job;

import java.util.List;

public interface JobService {
    List<Job> findAll();
    void createJob(Job job);

    Job getJob(Long id);

    Boolean deleteJob(Long id);

    Boolean updateJob(Long id, Job job);






}
