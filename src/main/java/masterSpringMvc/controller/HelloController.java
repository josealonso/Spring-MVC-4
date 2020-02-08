package masterSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller   // @RestController = @Controller + @ResponseBody
public class HelloController {
	
	@RequestMapping("/")
	public String hello(Model model) {
		System.out.println("===============Inside the controller==============");
		model.addAttribute("message", "Hello from the controller");
		return "resultPage";
	}

}
