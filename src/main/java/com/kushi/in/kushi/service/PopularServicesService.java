package com.kushi.in.kushi.service;

import com.kushi.in.kushi.entity.PopularServices;
import com.kushi.in.kushi.repo.PopularServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class PopularServicesService {

    @Autowired
    private PopularServicesRepository popularServicesRepository;

    public List<PopularServices> getTopFivePopularServices() {
        // Fetch the top 5 most booked services with ratings and image URL
        List<Object[]> results = popularServicesRepository.findTop5MostBookedServicesWithRatingAndImage();
        List<PopularServices> popularServicesList = new ArrayList<>();

        for (Object[] result : results) {
            if (result != null && result.length == 5) {  // Ensure the result has 5 columns
                PopularServices service = new PopularServices();

                // Map serviceName
                if (result[0] != null) {
                    service.setServiceName((String) result[0]);
                }

                // Map rating (could be null if no ratings available)
                if (result[1] != null) {
                    // Ensure the rating is correctly cast to Double
                    service.setRating(((BigDecimal) result[1]).doubleValue());
                } else {
                    service.setRating(0.0);  // Default to 0 if rating is null
                }

                // Map amount (total booking amount for the service)
                if (result[2] != null) {
                    // Ensure the amount is correctly cast to Double
                    service.setAmount(((BigDecimal) result[2]).doubleValue());
                } else {
                    service.setAmount(0.0);  // Default to 0 if amount is null
                }

                // Map booking count (number of bookings for the service)
                if (result[3] != null) {
                    service.setBookingCount(((Number) result[3]).longValue());
                }

                // Map image URL
                if (result[4] != null) {
                    service.setImageUrl((String) result[4]);  // Set image URL
                }

                popularServicesList.add(service);
            }
        }

        return popularServicesList;
    }
}
