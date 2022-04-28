package com.example.demo.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.model.PostVO;

//데이터에 직접적으로 접근하는 역할
//DB를 사용해 데이터를 조작하거나 접근하는 기능을 전담하는 오브젝트
@Mapper
public interface IPostDAO {
	
	int countId();
	int selectId(); //가장 최근의 id값을 1개만 가져옴
	void insertPost(PostVO vo); //JSON을 vo의 형태로 db에 넣기 위함
	PostVO selectPost(int id); //url의 id값을 가져와서 db에서 select
	ArrayList<PostVO> selectList();	
	void updatePost(PostVO vo);
	void deletePost(int id);
	ArrayList<PostVO> selectJson(String select);
	
}
