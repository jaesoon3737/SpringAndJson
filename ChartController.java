package soo.md.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.log4j.Log4j;
import soo.md.domain.ChartDTO;

@Log4j
@Controller
@RequestMapping("chart")
public class ChartController {
	
	private Random r = new Random();
	@GetMapping("chart.do")
	public String showView() {
		return "chart/chart";
	}
	
	@ResponseBody
	@PostMapping(value = "chartData")
	public List<ChartDTO> getChartData(){
		List<ChartDTO> list = new ArrayList<ChartDTO>();
		String items[] = {"봄" , "여름" , "가을" , "겨울"};
		
		for(String itemk : items) {
			int value = r.nextInt(100);
			ChartDTO dto = new ChartDTO(itemk , value);
			list.add(dto);
		}
		
		return list;
	}
}
