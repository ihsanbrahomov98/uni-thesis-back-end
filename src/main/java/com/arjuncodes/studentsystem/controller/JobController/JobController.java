package com.arjuncodes.studentsystem.controller.JobController;

import com.arjuncodes.studentsystem.model.SitterModel.Sitter;
import com.arjuncodes.studentsystem.model.JobModel.Job;
import com.arjuncodes.studentsystem.service.JobService.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Set;

@RestController
@RequestMapping("/job")
@CrossOrigin
public class JobController {
    @Autowired
    private JobService jobService;

    @PostMapping("/all")
    public Set<Sitter> getAllAvailableSitters(@RequestBody Job job){
        try {
            return jobService.searchSitters(job.getCity(), job.getStartingDate(),
                    job.getEndingDate(), job.getOfferedServices());
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/book/{id}")
    public void bookSitter(@RequestBody Job job, @PathVariable("id") Long sitterId){
    jobService.bookSitterById(job, sitterId);
    }
    @PostMapping("accept/{id}")
    public void acceptJob(@RequestBody Job job, @PathVariable("id") Long sitterId){
        jobService.acceptJobById(job, sitterId);
    }
    @PostMapping("decline/{id}")
    public void declineJob(@RequestBody Job job, @PathVariable("id") Long sitterId){
        jobService.declineJobById(job, sitterId);
    }
    @PostMapping("history/{id}")
    public void history(@RequestBody Job job, @PathVariable("id") Long sitterId){
        jobService.historyJobById(job, sitterId);
    }
    @PostMapping("decline/after/accepting/{id}")
    public void declineJobAfterAccepting(@RequestBody Job job, @PathVariable("id") Long sitterId){
        jobService.declineJobById(job, sitterId);
    }
}