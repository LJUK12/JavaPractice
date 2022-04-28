package com.example.demo.controller;


import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.ICommentDAO;
import com.example.demo.model.CommentVO;
import com.example.demo.model.PostVO;
import com.example.demo.service.IPostService;

@RestController //@Controller + @ResponseBody
public class HelloController {
	
	@Autowired
	IPostService service;
	
	@Autowired
	ICommentDAO commentService;
	//의존성 주입 Service 클래스 보다는 추상클래스인 IPostService를 사용하는게 개발적인 측면에서 더 좋음 / 결합도 문제
	
	
	@PostMapping("/board")
	// http의 post메소드 방식으로 데이터를 받아와서 저장하기 위해 사용
	public PostVO postJson(@RequestBody PostVO vo /*Map<String,String>param*/) {
		/*
		 * vo형식으로 받을려고 했으나 JSON.parser타입이 안맞는다고 오류가 나서 Map형식으로 받아서 value 값을 set시켜줄려고
		 * Map을 사용 json의 key값과 value값을 각각 map에 저장
		 */
//		String title = param.get("Title"); // Map의 title 의 value 값을 String 형식으로 추출
//		String content = param.get("Content"); // Map의 content의 value String 형식으로 추출
//		PostVO vo = new PostVO(); // vo 생성해주고
//		vo.setTitle(title); // vo.title에 넣음
//		vo.setContent(content); // vo.content에 넣음
		/*
		 * if(service.countId() == 0) { //count시켜서 db에 저장된 데이터가 없을경우 id를 0으로 저장
		 * vo.setId(0); }else { int id = service.selectId(); // DB에 저장된 가장 최신의 ID값을
		 * 검색해오고j id++; vo.setId(id); //+1 시켜서 vo.id에 저장 }
		 * vo.setTitle(vo.getTitle().replace("\n", "<br>"));
		 * vo.setContent(vo.getContent().replace("\n", "<br>")); //띄어쓰기까지 내용에 포함
		 */		
		service.insertPost(vo);	//JSON으로 받아온 값들과 같이 넣어준다.
		return vo;
	}
		

	
	
	
		/* trycatch 문으로 해결할려 했으나 오류가 나는 코드는 좋은 코드가 아님.
		 * try { int id = service.selectId(); // DB에 저장된 가장 최신의 ID값을 검색해오고 id++;
		 * vo.setId(id); //+1 시켜서 vo.id에 저장
		 * 
		 * } catch (Exception e) { //만약 db에 저장된 id값이 없을경우 vo.setId(0); // id값에 0을 set해주고
		 * 
		 * } service.insertPost(vo); //JSON으로 받아온 값들과 같이 넣어준다. return vo;
		 */
	
	@GetMapping("/board/{id}")
	// url에 적힌 {id}값을 이용해 select 시키기 위해 GetMapping을 사용 select시에는 get을 사용하고 json을 이용한 기능시에는 내용을 숨기기 위해 post사용
	public PostVO getJson(@PathVariable("id") int id, Model model) {
		/*
		 * 
		 * 
		 * @RequestBody = JSON데이터를 원하는 타입의 객체로 변환해야 하는 경우에 사용하며 HTTP요청의 body를 자바 객체로 받을 수 있게 해준다.
		 * 				  주로 비동기 처리 구현시 @ResponseBody와 함께 처리된다 . (현재는 @RestController)
		 * 				  @RequestBody 어노테이션이 달린 메소드의 매개변수는 HTTP의 본문(request body)와 연결된다.
		 * 				  HTTP요청 본문은 HttpMessageConverter에 의해 처리되는데 요청 시 전달받은 HTTP의 Content-Type헤더에 선언된
		 * 				  콘텐츠 타입 기준으로 메소드의 인자값을 처리한다.
		 * 				  Content-Type헤더 = 데이터의 타입을 명시하여 데이터 타입의 처리를 도움
		 * 
		 * @RequestParam = 쿼리 스트링에서 값을 가져온다. 어노테이션에 명시된 매개변수 값은 반드시 파라미터 값이 넘어와야 한다.
		 * 				   넘어오지 않을 시 400에러 발생 필수 파라미터가 아닐경우 required=false 설정을 추가한다.
		 * 				   (기본 설정은 required=true) 이렇게 하면 파라미터가 넘어오지 않아도 에러가 발생하지 않는다.
		 * 				   추가로 필수가 아닌 파라미터 값이 없을 때 null 값을 할당하는데, null 할당이 불가능한 기본 데이터 타입의 경우 타입 변환 에러가 발생한다.
		 *                 따라서 defaultValue 속성을 통해 기본 값을 설정한다.
		 *                 
		 *                 쿼리스트링 = 사용자가 입력 데이터를 전달하는 방법중의 하나로, url 주소에 미리 협의된 데이터를 파라미터를 통해 넘기는 것을 말한다.
		 *                 
		 *                 파라미터 = 쿼리스트링에서 ? 이후에 나오는 문자열
		 *                 
		 * @PathVariable = url 경로의 일부를 파라미터로 사용할 때 이용 (url경로에서 값을 가져온다.) 
		 * 				   탬플릿 변수의 값을 추출하고 그 값을 메소드 변수에 할당하는데 사용 된다.
		 * 				   파라미터란 url상 ?이후의 문자열을 뜻함.
		 * 
		 * @ResponseBody = 해당 어노테이션을 가진 메소드의 리턴값은 반드시 HTTP요청 본문(response body)에 바인딩 된다,
		 * 				   HttpMessgeConverter를 통해 요청 HTTP Content-Type 헤더에 선언된 데이터 형식에 맞게 메소드 리턴값을 반환한다.
		 * 				   바인딩??
		 */
		PostVO vo = new PostVO();
		vo = service.selectPost(id);
		//vo 형식으로 서비스를 통해 id값을 조건으로 mapper select시켜 db값을 가져온다.
		model.addAttribute("vo",vo);
		//view에서 보여주기 위해 모델로 보냄
		return vo;
		
	}
	
	
	
	@PutMapping("/board/update/{id}")
	public void updateJson(@PathVariable("id") int id, @RequestBody PostVO vo){
		//로직을 서비스안에서 처리해야 하는데 이부분은 고민이 필요함 = id를 넘겨받은 vo값에 set시키고 vo자체만 넘김 // 해결
		/*
		 * PostVO postvo = service.selectPost(id); postvo.setTitle(vo.getTitle());
		 * postvo.setContent(vo.getContent());
		 */
		vo.setId(id);
		
		service.updatePost(vo);
		
	}
	
	@DeleteMapping("/board/delete/{id}")
	public void deleteJson(@PathVariable("id") int id) {
		//DB에 저장된 데이터 삭제
		service.deletePost(id);
	}
	
	@GetMapping("/board/select/{select}")
	public ArrayList<PostVO> selectJson(@PathVariable("select") String select, Model model){
		ArrayList<PostVO> vo = service.selectJson(select);
		return vo;
	}
	
	// 댓글 작성
	@PostMapping("/detailpage/comment/{id}")
	public void commentInsert(@RequestBody CommentVO commentvo, @PathVariable int id) {
		commentvo.setId(id);
		commentService.insertComment(commentvo);
	}
	
	@PostMapping("/detailpage/comment/{id}/{parents}")
	public void replyInsert(@RequestBody CommentVO commentvo, @PathVariable int id, @PathVariable int parents) {
		commentvo.setId(id);
		commentvo.setCommentParents(parents);
		commentService.insertComment(commentvo);
	}
	

}
