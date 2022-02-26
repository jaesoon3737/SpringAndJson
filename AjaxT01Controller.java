package soo.md.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import soo.md.domain.Address;
import soo.md.service.AddressAjaxService;

@Controller
@RequestMapping("ajax01")
@AllArgsConstructor
public class AjaxT01Controller {
	
	private final AddressAjaxService service;
	
	@GetMapping("search01.do")
	public void search01(@RequestParam(name="seqs")long seq , HttpServletResponse response){
			Address address = service.selectBySeqS(seq);
			String addressJson = null;
			if(address != null) {
				addressJson = "{\"seqs\":"+address.getSeq()
				+ ", \"name\":\""+address.getName()
				+ "\" , \"addr\":\""+address.getAddr()
				+ "\" , \"rate\":\""+address.getRdate()
				+ "\"}";
			}
			
			try {
				response.setContentType("application/json;charset=utf-8");
				PrintWriter pw = response.getWriter();
				pw.println(addressJson);
				
			} catch (IOException ie) {
				
			}
	}
	
	@PostMapping("search02.do")
	public void search02(@RequestParam(name="name")String name ,HttpServletResponse response) {
		
		List<Address> list = service.selectByNameS(name);
		
		String addressJson = null;
		if(list.size() != 0) {
			addressJson = "[";
					for(Address address : list) {
						addressJson += "{\"seq\":"+address.getSeq()
						+ ", \"name\":\""+address.getName()
						+ "\" , \"addr\":\""+address.getAddr()
						+ "\" , \"rate\":\""+address.getRdate()
						+ "\"} ";
						addressJson += ",";
					}
			addressJson = addressJson.substring(0, addressJson.length()-1);	
			addressJson += "]";
		} else {
			addressJson += "[]";
		}
		
		try {
			response.setContentType("application/json;charset=utf-8");
			PrintWriter pw = response.getWriter();
			pw.println(addressJson);
			
		} catch (IOException ie) {
			
		}
	}
}
