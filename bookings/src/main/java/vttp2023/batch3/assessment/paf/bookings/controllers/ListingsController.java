package vttp2023.batch3.assessment.paf.bookings.controllers;

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

import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;
import vttp2023.batch3.assessment.paf.bookings.services.ListingsService;

@Controller
@RequestMapping
public class ListingsController {

	@Autowired
	ListingsService listingSvc; 


	//TODO: Task 2
	// @GetMapping(@ModelAttribute ){

	// 	return "landingPage"; 
	// }

	@GetMapping(path="/landingPage", consumes=MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public ResponseEntity<String> search(@RequestBody MultiValueMap<String, String> values, @ModelAttribute) {
        if (listingSvc.search(values)) {
            return new ResponseEntity<String>(HttpStatusCode.valueOf(200));
        }
        else {
            return new ResponseEntity<String>(HttpStatusCode.valueOf(400));
        }
    }

	
	//Task 3


	//Task 4
	

	//Task 5


}
