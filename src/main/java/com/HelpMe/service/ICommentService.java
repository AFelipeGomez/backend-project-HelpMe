package com.HelpMe.service;

import java.util.List;

import com.HelpMe.entity.Comment;

public interface ICommentService extends ICrud<Comment, Integer>{

	public List<Comment> getListById(Integer idT);
}
