package soo.md.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.log4j.Log4j;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

@Log4j
@Controller
@RequestMapping("auto")
public class AutoController {
	
	private AddressAjaxService service;
	
	@Autowired
	public AutoController(AddressAjaxService service){
		this.service = service;
	}
	
	@GetMapping(value = "auto.do")
	public String showView() {
		return "auto/autocomplete";
	}

	/*
	@PostMapping(value = "autoData" , 	
			produces = {MediaType.APPLICATION_JSON_UTF8_VALUE ,
			MediaType.APPLICATION_XML_VALUE})
	public List<Address> getAddressList(String writer , HttpServletResponse response){
		List<Address> list = service.selectByNameS(writer);
		return list;
	}
	*/
	@PostMapping(value = "autoData" )
	public @ResponseBody List<Address> getAddressList(String writer){
	List<Address> list = service.selectByNameS(writer);
	return list;
}
}
