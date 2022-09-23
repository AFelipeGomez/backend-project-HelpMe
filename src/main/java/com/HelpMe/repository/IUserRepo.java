package com.HelpMe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HelpMe.entity.User;

@Repository
public interface IUserRepo extends JpaRepository<User, Integer> {

	public Boolean existsByEmail(String email);

	public Boolean existsByDocument(String document);

	public Boolean existsByUsername(String username);

}
