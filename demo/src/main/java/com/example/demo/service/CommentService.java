package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dao.ICommentDAO;
import com.example.demo.model.CommentVO;

@Service
public class CommentService implements ICommentService {
	
	@Autowired
	ICommentDAO dao;
	
	@Override
	public void insertComment(CommentVO vo) {
		
		if(dao.countCommentId() == 0) {
			vo.setCommentId(1);
		}
		
		
	}

	@Override
	public int countCommentId() {
		// TODO Auto-generated method stub
		return dao.countCommentId();
	}

	@Override
	public int selectCommentId() {
		// TODO Auto-generated method stub
		return dao.selectCommentId();
	}

	@Override
	public ArrayList<CommentVO> selectComment(int id) {
		// TODO Auto-generated method stub
		
		return dao.selectComment(id);
	}

	@Override
	public ArrayList<CommentVO> selectReply() {
		return dao.selectReply();
		
	}

	@Override
	public ArrayList<CommentVO> selectReply2() {
		return dao.selectReply2();
	}

	

}
