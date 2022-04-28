package com.example.demo.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.CommentVO;

@Mapper
public interface ICommentDAO {
	void insertComment(CommentVO vo);
	int countCommentId();
	int selectCommentId(); //가장 최근의 댓글 id값 가져오기
	ArrayList<CommentVO>selectComment(int id);
	ArrayList<CommentVO>selectReply();
	ArrayList<CommentVO>selectReply2();
	
	
}
