package soo.md.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.AllArgsConstructor;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

@Controller
@RequestMapping("ajax03")
@ResponseBody
public class AjaxT03Controller {
	
	private final AddressAjaxService service;
	
	@Autowired
	public AjaxT03Controller(AddressAjaxService service) {
		this.service = service;
	}
	
	
	@GetMapping("search01")
	public Address search01(long seq , HttpServletResponse response){
		Address address = service.selectBySeqS(seq);
			//ObjectMapper om = new ObjectMapper();
		return address;
	}
	
	@PostMapping("search02")
	public List<Address> search02(String name ,HttpServletResponse response) {
		
		List<Address> list = service.selectByNameS(name);
		return list;
	}
}
