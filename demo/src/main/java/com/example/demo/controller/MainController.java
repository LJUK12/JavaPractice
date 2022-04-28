package com.example.demo.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.demo.model.CommentVO;
import com.example.demo.model.PostVO;
import com.example.demo.service.ICommentService;
import com.example.demo.service.IPostService;

@Controller
public class MainController {
	
	@Autowired
	IPostService service;
	
	@Autowired
	ICommentService commentService;
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	@GetMapping("/list")
	public String homeList(Model model) {
		ArrayList<PostVO> vo = service.selectList(); //db에 저장된 모든 select 결과를 가져
		model.addAttribute("list",vo);
		
		return "list";
	}
	@GetMapping("/detailpage/{id}")
	public String detailPage(@PathVariable("id")int id,Model model) {
		PostVO vo = service.selectPost(id);
		model.addAttribute("selectVO",vo);
		
		ArrayList<CommentVO> commentvo = commentService.selectComment(id);
		model.addAttribute("commentVO",commentvo);
		
		ArrayList<CommentVO> replyvo = commentService.selectReply();
		model.addAttribute("replyVO",replyvo);
		
		ArrayList<CommentVO> replyvo2 = commentService.selectReply2();
		model.addAttribute("relplyVO2",replyvo2);
		
		return "detailPage"; 
	}
	
	
	
}
