package com.arjuncodes.studentsystem.service.JobService;

import com.arjuncodes.studentsystem.model.SitterModel.Sitter;
import com.arjuncodes.studentsystem.model.JobModel.Job;

import java.text.ParseException;
import java.util.Set;

public interface JobService {
    public Set<Sitter> searchSitters(String fitler1, String filter2, String filter3, String filter4) throws ParseException;
    public void bookSitterById (Job job, Long id);
    public Job saveSearch(Job job);
    public void acceptJobById(Job job, Long id);
    public void declineJobById(Job job, Long id);
    public void historyJobById(Job job, Long id);
}
