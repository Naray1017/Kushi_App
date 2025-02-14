package com.example.web_login.service;

import com.example.web_login.entity.PopularServices;
import com.example.web_login.repo.PopularServicesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PopularServicesService {

    @Autowired
    private PopularServicesRepository popularServicesRepository;

    public List<PopularServices> getTop5PopularServicesByRating() {
        List<Object[]> results = popularServicesRepository.findTop5PopularServicesByRating();
        List<PopularServices> popularServicesList = new ArrayList<>();

        for (Object[] result : results) {
            if (result != null) {
                PopularServices service = new PopularServices();

                service.setServiceName((String) result[0]);
                service.setAmount(result[1] != null ? Double.parseDouble(result[1].toString()) : 0.0);
                service.setBookingCount(result[2] != null ? ((Number) result[2]).longValue() : 0L);
                service.setImageUrl(result[3] != null ? (String) result[3] : null);
                service.setRatingCount(result[4] != null ? ((Number) result[4]).longValue() : 0L);

                popularServicesList.add(service);
            }
        }
        return popularServicesList;
    }
}
