package masterSpringMvc.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;

@Controller   // @RestController = @Controller + @ResponseBody
public class TweetController {
	
	@RequestMapping("/")
	public String home() {
		return "searchPage";
	}
	
	@RequestMapping(value="/result")
	public String searchTweets(@RequestParam(defaultValue = "a") String search, Model model) {
        Twitter twitter = TwitterFactory.getSingleton(); 
        Query query = new Query("source:twitter4j AlcalaJoser");
        query.setQuery(search);
        query.setCount(100);
        QueryResult result = null;
		try {
			result = twitter.search(query);
		} catch (TwitterException e) {
			System.out.println("========== Error al leer los mensajes ==========");
			e.printStackTrace();
		}
        List<Status> tweets = result.getTweets();
        List<String> list = new ArrayList<>();
        List<String> imagesUrlsList = new ArrayList<>();
//        		.stream()
//        		.map(Status::getText)
//        		.collect(Collectors.toList());  // The collect method allows to call a terminal operation.
        for (Status status: tweets) {
        	imagesUrlsList.add(status.getUser().getOriginalProfileImageURL());
        	list.add(status.getUser().getScreenName());
        	list.add(status.getUser().getDescription());
        	list.add(status.getUser().getLocation());
        	list.add(status.getText());
        	list.add("==========================================");
        }
        model.addAttribute("imagesurls", imagesUrlsList);
		model.addAttribute("tweets", tweets);
		model.addAttribute("search", search);
		return "resultPage";
	}

	@RequestMapping(value="/postSearch", method = RequestMethod.POST)
	public String postSearch(HttpServletRequest request, RedirectAttributes redirectAttributes) {
	    String search = request.getParameter("search");
	    if (search.toLowerCase().contains("struts")) {
	    	redirectAttributes.addFlashAttribute("error", "Try using spring instead");
	    	return "redirect:/";
	    }
	    redirectAttributes.addAttribute("search", search);
		return "redirect:result";
	}
	
}
