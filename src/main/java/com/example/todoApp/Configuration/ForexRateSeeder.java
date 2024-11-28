package com.example.todoApp.Configuration;

import com.example.todoApp.Model.ForexRate;
import com.example.todoApp.Repositories.ForexRateRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@Configuration
public class ForexRateSeeder {

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";

    @Bean

    RestTemplate restTemplate() {
        return new RestTemplate();
    }

//    @Bean
//    CommandLineRunner seedForexRates(ForexRateRepository repository, RestTemplate restTemplate) {
//        return args -> {
//            // Fetch rates from the API
//            Map<String, Object> response = restTemplate.getForObject(API_URL, Map.class);
//            Map<String, Object> rates = (Map<String, Object>) response.get("rates");
//
//            // Map rates to ForexRate entities
//            rates.forEach((currency, rate) -> {
//                double rateValue;
//                if (rate instanceof Integer) {
//                    // Convert Integer to Double
//                    rateValue = ((Integer) rate).doubleValue();
//                } else if (rate instanceof Double) {
//                    rateValue = (Double) rate;
//                } else {
//                    throw new IllegalArgumentException("Unsupported rate type: " + rate.getClass());
//                }
//
//                // Save ForexRate entity
//                ForexRate forexRate = new ForexRate();
//                forexRate.setBaseCurrency("USD");
//                forexRate.setTargetCurrency(currency);
//                forexRate.setRate(rateValue);
//                forexRate.setCreatedAt(LocalDateTime.now());
//                forexRate.setUpdatedAt(LocalDateTime.now());
//                repository.save(forexRate);
//            });
//        };
//    }

}

