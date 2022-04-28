package com.example.demo.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class CommentVO {
	private int commentId;
	private String commentTitle;
	private String commentContent;
	private int commentParents;
	private int commentDeep;
	private int id;
	
	
}
