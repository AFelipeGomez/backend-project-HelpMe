package com.HelpMe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HelpMe.entity.Status;

@Repository
public interface IStatusRepo extends JpaRepository<Status, Integer>{

	public boolean existsByName(String name);
}
