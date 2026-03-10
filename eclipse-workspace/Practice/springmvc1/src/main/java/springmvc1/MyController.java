package springmvc1;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import springmvc1.model.User;

@Controller
public class MyController {

	@GetMapping("/form")
	public ModelAndView openFormPage() {
		return new ModelAndView("form");
	}

//   @PostMapping("/submitForm")
//  public ModelAndView submitForm(@RequestParam("username") String username
//  		, @RequestParam("email") String email) {
// 	
//  	ModelAndView mv = new ModelAndView("home");
//  	mv.addObject("u",username);
//   	mv.addObject("e",email);
//   	return mv;
//    }

	// using getters and setters (professional way)

//    @PostMapping("/submitForm")
//    public String submitForm(User u,Model mv) {
//    	mv.addAttribute("user", u);
//    	return "home";
//    }

	@PostMapping("/submitForm")
	public String submitForm(@ModelAttribute User u) {
		return "home";
	}
}