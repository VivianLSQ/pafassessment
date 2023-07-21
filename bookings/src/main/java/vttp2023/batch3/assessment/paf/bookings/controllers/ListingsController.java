package vttp2023.batch3.assessment.paf.bookings.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;
import vttp2023.batch3.assessment.paf.bookings.models.Listings;
import vttp2023.batch3.assessment.paf.bookings.models.User;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;
import vttp2023.batch3.assessment.paf.bookings.services.ListingsService;

@Controller
@RequestMapping
public class ListingsController {

	@Autowired
	ListingsService listingSvc; 


	//Task 2

	@GetMapping(path="/landingPage", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
	public ModelAndView search(@ModelAttribute User country, HttpSession session) {

		List<User> user= listingSvc.findListingsByCountry(country);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("landingPage");
		mav.addObject("country", user);
		mav.addObject("numberOfPerson", user);
		mav.addObject("priceRange", user);
		mav.setStatus(HttpStatusCode.valueOf(200));

		return mav;
	}

	
	//Task 3
	@GetMapping(path="/listings")
	public ModelAndView displayListingsByCountry(@RequestParam listing) {

		List<Listings> listing= listingSvc.getListingsByCountry(addresss);

		ModelAndView mav = new ModelAndView();
		mav.setViewName("landingPage");
		mav.addObject("country", user);
		mav.addObject("numberOfPerson", user);
		mav.addObject("priceRange", user);
		mav.setStatus(HttpStatusCode.valueOf(200));

		return mav;
	}

	//Task 4
	@PostMapping(path="/reservation", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> search(@RequestBody MultiValueMap<String, String> values, @ModelAttribute User country ) {
        if (listingSvc.search(values)) {
            return new ResponseEntity<String>(HttpStatusCode.valueOf(200));
        }
        else {
            return new ResponseEntity<String>(HttpStatusCode.valueOf(400));
        }
    }
	//To save booking using PostMapping and Update(?)

	//Task 5


}
