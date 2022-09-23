package com.HelpMe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HelpMe.entity.Priority;

@Repository
public interface IPriorityRepo extends JpaRepository<Priority, Integer> {

}
