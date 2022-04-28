package com.example.demo.service;

import java.util.ArrayList;

import com.example.demo.model.PostVO;

public interface IPostService { //
	int countId();
	int selectId(); //가장 최근의 id값을 1개만 가져옴
	void insertPost(PostVO vo); //JSON을 vo의 형태로 db에 넣기 위함
	PostVO selectPost(int id); //url의 id값을 가져와서 db에서 select
	ArrayList<PostVO> selectList();
	void updatePost(PostVO vo);
	void deletePost(int id);
	ArrayList<PostVO> selectJson(String select);
}
