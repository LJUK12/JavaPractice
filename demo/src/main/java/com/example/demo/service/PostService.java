package com.example.demo.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.demo.dao.IPostDAO;
import com.example.demo.model.PostVO;

@Service
public class PostService implements IPostService {

	@Autowired
	IPostDAO dao;
	
	@Override // 
	public void insertPost(PostVO vo) {
		if(dao.countId() == 0) { //count시켜서 db에 저장된 데이터가 없을경우  id를 0으로 저장
			vo.setId(0);
		}else {
			int id = dao.selectId();  // DB에 저장된 가장 최신의 ID값을 검색해오고j
			id++; 
			vo.setId(id); //+1 시켜서 vo.id에 저장
		}
		vo.setTitle(vo.getTitle().replace("\n", "<br>"));
		vo.setContent(vo.getContent().replace("\n", "<br>")); //띄어쓰기까지 내용에 포함
		dao.insertPost(vo);
		//DB에 저장하기 위한 기능 - mapper에 접근하기 위해 dao의 메소드를 호출
	}

	@Override
	public PostVO selectPost(int id) {
		return dao.selectPost(id);
		//DB에 저장된 id의 row값을 select 하기 위함 - mapper에 접근하기 위해 dao의 메소드를 호출
	}

	@Override
	public int selectId() {
		return dao.selectId();
		//DB에 저장한 id값을 가져옴 - mapper에 접근하기 위해 dao의 메소드를 호출
	}

	@Override
	public int countId() {
		return dao.countId();
		//DB에 저장된 id를 count - mapper에 접근하기 위해 dao의 메소드를 호출
		
	}

	@Override
	public ArrayList<PostVO> selectList() {
		return dao.selectList();
	}


	@Override
	public void updatePost(PostVO vo) {
		dao.updatePost(vo);
	}

	@Override
	public void deletePost(int id) {
		dao.deletePost(id);
		
	}

	@Override
	public ArrayList<PostVO> selectJson(String select) {
		// <> - 지네릭스 = 타입을 명시
 		return dao.selectJson(select);
	}



}
