package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.CommentVO;

public interface ICommentService {
	void insertComment(CommentVO vo);
	int countCommentId();
	int selectCommentId(); //가장 최근의 댓글 id값 가져오기
	ArrayList<CommentVO>selectComment(int id);
	ArrayList<CommentVO>selectReply();
	ArrayList<CommentVO>selectReply2();
}
