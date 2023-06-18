package com.arjuncodes.studentsystem.repository.JobRepository;

import com.arjuncodes.studentsystem.model.JobModel.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobRepository extends JpaRepository<Job,Long> {

}
