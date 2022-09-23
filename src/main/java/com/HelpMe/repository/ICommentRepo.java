package com.HelpMe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.HelpMe.entity.Comment;

@Repository
public interface ICommentRepo extends JpaRepository<Comment, Integer>{

}
