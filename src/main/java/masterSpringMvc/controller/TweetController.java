package masterSpringMvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller   // @RestController = @Controller + @ResponseBody
public class HelloController {
	
	@RequestMapping("/")
	public String hello(@RequestParam(defaultValue = "world") String name, Model model) {
		System.out.println("===============Inside the controller==============");
		model.addAttribute("message", "Hello, " + name);
		return "resultPage";
	}

}
