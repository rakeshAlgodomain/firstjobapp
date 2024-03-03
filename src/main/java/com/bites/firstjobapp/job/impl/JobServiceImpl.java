package com.bites.firstjobapp.job.impl;

import com.bites.firstjobapp.job.Job;
import com.bites.firstjobapp.job.JobService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
@Service
public class JobServiceImpl implements JobService {
    private List<Job> jobs = new ArrayList<>();
    @Override
    public List<Job> findAll() {
        return jobs;
    }

    @Override
    public void createJob(Job job) {
        jobs.add(job);

    }
    @Override
    public Job getJob(Long id){
        for (Job job : jobs){
            if (job.getId().equals(id)){
                return job;
            }
        }

        return null;

    }

    @Override
    public Boolean deleteJob(Long id){
        Iterator<Job> iterator = jobs.iterator();
        while (iterator.hasNext()){
            Job job = iterator.next();
            if (job.getId().equals(id)){
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    @Override
    public Boolean updateJob(Long id, Job jobToUpdate){
        for (Job job: jobs){
            if (job.getId().equals(id)){
                job.setTitle(jobToUpdate.getTitle());
                job.setDescription(jobToUpdate.getDescription());
                job.setLocation(jobToUpdate.getLocation());
                job.setMinSalary(jobToUpdate.getMinSalary());
                job.setMaxSalary(jobToUpdate.getMaxSalary());


                return true;


            }
        }
        return false;
    }


}
