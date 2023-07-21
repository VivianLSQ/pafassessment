package vttp2023.batch3.assessment.paf.bookings.services;

import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
import vttp2023.batch3.assessment.paf.bookings.models.Listings;
import vttp2023.batch3.assessment.paf.bookings.models.User;
import vttp2023.batch3.assessment.paf.bookings.repositories.ListingsRepository;

@Service
public class ListingsService {

	@Autowired
	ListingsRepository listingRepo; 
	
	//Task 2
	public List<User> findListingsByCountry(User country){
		return listingRepo.findListingsByCountry(country).stream()
				.map(d -> new User(
					d.getString("country"),
					d.getInteger("numberOfPerson"),
					d.getFloat("priceRange")
				))
			.toList(); 
	}

	
	//Task 3
	public List<Listings> displayListingsByCountry(Listings listings) {
		return listingRepo.displayListingsByCountry().stream()
			.map(d -> {
				return new Listings(
						d.getString("address"),
						d.getFloat("price"), 
						d.get("image", Document.class).getString("original"), 
						d.getString("details")
				);
			})
			.toList();
	}



	//Task 4
	public List<ListingDetails> getReservationDetails(String _id, String description, String address, String image, String price, String amenities) {
		return listingRepo.getReservationDetails(_id, description, address, image, price, amenities).stream()
			.map(d -> new ListingDetails(
					d.getString("_id"),
					d.getString("description"), 
					d.getString("address"), 
					d.get("image", Document.class).getString("original"),
					d.getFloat("price"),
					d.getString("amenities") 
			))
			.toList();
	}


    public boolean postSelectedListing(MultiValueMap<String, String> values) {
        return false;
    }


	//Task 5
	//To reference to reservation id later, we will need UUID
		//String cId = UUID.randomUUID().toString().substring(0, 8);

		//ObjectId objId = commentRepo.insertComment(comment.withId(cId));

		//System.out.printf(">>> objectid: %s\n", objId);


}
