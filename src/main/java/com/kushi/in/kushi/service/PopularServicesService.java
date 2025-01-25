package com.kushi.in.kushi.service;

import com.kushi.in.kushi.entity.PopularServices;
import com.kushi.in.kushi.repo.PopularServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PopularServicesService {

    @Autowired
    private PopularServicesRepository popularServicesRepository;

    public List<PopularServices> getTopFivePopularServices() {
        // Fetch the top 5 most booked services (with rating as null temporarily)
        List<Object[]> results = popularServicesRepository.findTop5MostBookedServices();
        List<PopularServices> popularServicesList = new ArrayList<>();

        // Map the results to PopularServices entity
        for (Object[] result : results) {
            if (result != null && result.length == 3) {  // Adjust length check for 3 columns
                PopularServices service = new PopularServices();

                // Safely set serviceName
                if (result[0] != null) {
                    service.setServiceName((String) result[0]);
                }

                // Temporarily set rating as null
                service.setRating(null);

                // Safely set amount
                if (result[2] != null) {
                    service.setAmount(((Number) result[2]).doubleValue());
                }

                // Set booking count to 0 (we don’t have this from the query)
                service.setBookingCount(0L);

                popularServicesList.add(service);
            }
        }

        return popularServicesList;
    }
}
