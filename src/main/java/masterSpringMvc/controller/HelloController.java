package masterSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   // @RestController = @Controller + @ResponseBody
public class HelloController {
	
	@RequestMapping("/")
	public String hello() {
		System.out.println("===============Inside the controller==============");
		return "resultPage";
	}

}
