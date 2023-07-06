package com.example;

import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "*")
public class ReviewsRestController {

    private static final Map<Integer, List<Review>> reviews = new HashMap<>();

    static {
        List<Review> p1Reviews = new ArrayList<>();
        p1Reviews.add(new Review(1, "Who1", 4, "This is the first review."));
        p1Reviews.add(new Review(2, "Who2", 3, "This is the second review."));
        p1Reviews.add(new Review(3, "Who3", 2, "This is the third review."));

        List<Review> p2Reviews = new ArrayList<>();
        p2Reviews.add(new Review(1, "Who1", 4, "This is the first review."));
        p2Reviews.add(new Review(2, "Who2", 3, "This is the second review."));

        reviews.put(1, p1Reviews);
        reviews.put(2, p2Reviews);
    }

    @RequestMapping(value = "/api/reviews", method = RequestMethod.GET)
    public List<Review> getReviews(@RequestParam int productId) {
        List<Review> out = reviews.getOrDefault(productId, new ArrayList<>());
        return out;
    }

}
