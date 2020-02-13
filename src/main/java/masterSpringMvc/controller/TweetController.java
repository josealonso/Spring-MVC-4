package masterSpringMvc.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;

@Controller   // @RestController = @Controller + @ResponseBody
public class TweetController {
	
//	@Autowired               // Code for using the now deprecated spring social Twitter API
//	private Twitter twitter;
	
	@RequestMapping("/")
	public String searchTweets(@RequestParam(defaultValue = "spring") String search, Model model) {
        Twitter twitter = TwitterFactory.getSingleton(); // getTwitterInstance();
        Query query = new Query("source:twitter4j AlcalaJoser");
        query.setQuery("a");
        query.setCount(100);
        QueryResult result = null;
		try {
			result = twitter.search(query);
		} catch (TwitterException e) {
			System.out.println("========== Error al leer los mensajes ==========");
			e.printStackTrace();
		}
        List<Status> tweets = result.getTweets();
//        		.stream()
//        		.map(Status::getText)
//        		.collect(Collectors.toList());
		model.addAttribute("tweets", tweets);
		return "resultPage";
	}

}
