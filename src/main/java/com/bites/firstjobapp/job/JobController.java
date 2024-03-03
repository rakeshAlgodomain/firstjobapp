package com.bites.firstjobapp.job;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping("/jobs")
public class JobController {
    private JobService jobService;
    private Long nextId = 1L;

    public JobController(JobService jobService) {
        this.jobService = jobService;
    }

    @GetMapping
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity(jobService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        job.setId(nextId++);
        jobService.createJob(job);

        return new ResponseEntity<>("Jobs Added Successfully", HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobId(@PathVariable Long id){

        Job job = jobService.getJob(id);
        if (job != null){
            return new ResponseEntity<>(job, HttpStatus.OK);
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND);



    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteJobId(@PathVariable Long id){
        boolean deleted = jobService.deleteJob(id);
        if (deleted){
            return new ResponseEntity<>("Delete Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);


    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateJobId(@PathVariable Long id, @RequestBody Job jobToUpdate){
        boolean updated = jobService.updateJob(id, jobToUpdate);
        if (updated){
            return new ResponseEntity<>("Update Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Found", HttpStatus.NOT_FOUND);
    }
}
