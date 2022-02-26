package soo.md.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

@RestController  // 레스트는 스트링 리턴해줌 맨아래 예제   jsp로 리턴할거면 그냥 Controller 스트링타입 리턴할떄 차이
@RequestMapping("ajax04")  

public class AjaxT04Controller {
	
	private final AddressAjaxService service;
	
	@Autowired
	public AjaxT04Controller(AddressAjaxService service) {
		this.service = service;
	}
	
	
	@GetMapping(value = "search01" ,
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE ,
					MediaType.APPLICATION_XML_VALUE}) // 특정타입에만 요청하게 할수 있는 produces , 이거는 response , request 경우에는 consumes
	public Address search01(long seq , HttpServletResponse response){
		Address address = service.selectBySeqS(seq);
		return address;
	}
	
	@PostMapping(value = "search02" , produces = {MediaType.APPLICATION_JSON_UTF8_VALUE , MediaType.APPLICATION_XML_VALUE})
	public List<Address> search02(String name ,HttpServletResponse response) {
		List<Address> list = service.selectByNameS(name);
		return list;
	}
	
	@GetMapping(value = "txt")
	public String getText(){
		return "good";
	}
}
