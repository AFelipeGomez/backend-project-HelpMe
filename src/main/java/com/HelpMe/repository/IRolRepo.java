package com.HelpMe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HelpMe.entity.Rol;

@Repository
public interface IRolRepo extends JpaRepository<Rol, Integer> {

}
