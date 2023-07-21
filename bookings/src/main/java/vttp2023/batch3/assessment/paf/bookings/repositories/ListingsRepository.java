package vttp2023.batch3.assessment.paf.bookings.repositories;

import java.util.Collection;
import java.util.List;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
//import org.springframework.data.mongodb.core.aggregation.GroupOperation;
import org.springframework.data.mongodb.core.aggregation.MatchOperation;
import org.springframework.data.mongodb.core.aggregation.ProjectionOperation;
import org.springframework.data.mongodb.core.aggregation.SortOperation;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import vttp2023.batch3.assessment.paf.bookings.models.ListingDetails;
import vttp2023.batch3.assessment.paf.bookings.models.Listings;
import vttp2023.batch3.assessment.paf.bookings.models.User;
import vttp2023.batch3.assessment.paf.bookings.services.ListingsService;

public class ListingsRepository {

	@Autowired
	ListingsService listingSvc; 

	@Autowired 
	MongoTemplate template; 

	public static final String F_ADDRESS = "address";
	public static final String F_PAX ="numberOfPerson";
	public static final String F_PRICERANGE ="priceRange";
	public static final String C_LISTINGS= "listings"; 

	//Task 2: 

	/*
	db.listings.find({
     address:{$regex: "Australia", $options: "i"}
	})
	*/

	public List<Document> findListingsByCountry(User country){
		Criteria criteria = Criteria.where("address").regex("Australia"); 
		Query query = Query.query(criteria); 
		return template.find(query, Document.class, "listings"); 
	}

	
	//Task 3
	/* 
		db.listings.aggregate([
    		{$match:{ $and:[
     			{"price": {$gte:100}}, {"price":{ $lte: 250}}, { "accommodates": 2}, 
    			]}},
    		{$project: {address:1, accommodates: 1, price: 1}}, 
   		 	{$sort: {'price':-1}}  
		])
	*/
	//Filter by price Range and Number of Persons (Yet to add country)
	MatchOperation matchByPriceRangeAndPax = Aggregation.match(Criteria.where(F_PRICERANGE).gte(100).lte(250)
																.and("accommodates").is(2)); 
	
	ProjectionOperation projectListingResult = Aggregation.project(F_ADDRESS, F_PAX, F_PRICERANGE); 

	SortOperation sortByPrice = Aggregation.sort(
		Sort.by(Direction.DESC, "price"));

	Aggregation pipeline = Aggregation.newAggregation(projectListingResult, sortByPrice);

	AggregationResults<Document> results = template.aggregate(pipeline, C_LISTINGS, Document.class);
	

	//Task 4


	public Collection<ListingDetails> getReservationDetails(String _id, String description, String address, String image,
			String price, String amenities) {
		return null;
	}


	public Collection<User> displayListingsByCountry() {
		return null;
	} 
	

	//Task 5


}
