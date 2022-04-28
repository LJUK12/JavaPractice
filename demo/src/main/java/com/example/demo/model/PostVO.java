package com.example.demo.model;


import com.fasterxml.jackson.annotation.JsonProperty;


import lombok.Data;


//데이터 교환을 위한 객체?

@Data
//@JsonAutoDetect 


// getter , setter , 생성자를 만들기 위해 사용 (Lombok)
public class PostVO {
		
	private int id;
	@JsonProperty("Title") //@JsonProperty 어노테이션은 객체를 JSON 형식으로 변환할 때 Key의 이름을 설정할 수 있음
	private String title;
	@JsonProperty("Content")
	private String content;
	

}
