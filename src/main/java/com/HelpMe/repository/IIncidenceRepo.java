package com.HelpMe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HelpMe.entity.FrecuentIncidence;

@Repository
public interface IIncidenceRepo extends JpaRepository<FrecuentIncidence, Integer> {

}
