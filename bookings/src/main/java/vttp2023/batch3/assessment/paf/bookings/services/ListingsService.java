package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
import vttp2023.batch3.assessment.paf.bookings.models.Listings;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;

@Service
public class ListingsService {

	@Autowired
	ListingsRepository listingRepo; 
	
	//Task 2
	public List<Listings> getListingsByCountry(String type, int limit, int skip) {
		return listingRepo.getListingsByCountry(type, limit, skip).stream()
			.map(d -> {
				return new Listings(
						d.getString("address"),
						d.getString("price"), 
						d.get("image", Document.class).getString("original"), 
						d.getString("details")
				);
			})
			.toList();
	}

	
	//Task 3


	//Task 4
	public List<ListingDetails> getDetailsForListing(String type, int limit, int skip) {
		return listingRepo.getDetailsForListing(type, limit, skip).stream()
			.map(d -> {
				return new Listing(
						d.getInteger("id"),
						d.getString("country"), 
						d.getString("summary"), 
						d.get("image", Document.class).getString("original")
				);
			})
			.toList();
	}

	//Task 5


}
