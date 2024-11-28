package com.example.todoApp.Services;

import com.example.todoApp.Model.ForexRate;
import com.example.todoApp.Repositories.ForexRateRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.time.LocalDateTime;
import java.util.Map;

@Service
public class ForexRateService {
    private final ForexRateRepository forexRateRepository;
    private final RestTemplate restTemplate;

    private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/USD";

    public ForexRateService(ForexRateRepository forexRateRepository, RestTemplate restTemplate) {
        this.forexRateRepository = forexRateRepository;
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedRate = 1000) // Executes every 5 minutes (300,000 ms)
    public void updateForexRates() {
        try {
            // Fetch rates from the API
            Map<String, Object> response = restTemplate.getForObject(API_URL, Map.class);
            Map<String, Object> rates = (Map<String, Object>) response.get("rates");

            // Iterate through rates and update the database
            rates.forEach((currency, rate) -> {
                double rateValue;
                if (rate instanceof Integer) {
                    rateValue = ((Integer) rate).doubleValue();
                } else if (rate instanceof Double) {
                    rateValue = (Double) rate;
                } else {
                    throw new IllegalArgumentException("Unsupported rate type: " + rate.getClass());
                }

                // Find existing rate or create a new one
                ForexRate forexRate = forexRateRepository.findByTargetCurrency(currency)
                        .orElse(new ForexRate());
                forexRate.setBaseCurrency("USD");
                forexRate.setTargetCurrency(currency);
                forexRate.setRate(rateValue);
                forexRate.setUpdatedAt(LocalDateTime.now());

                // Save updated rate to the database
                forexRateRepository.save(forexRate);
            });

            System.out.println("Forex rates updated successfully at " + LocalDateTime.now());
        } catch (Exception e) {
            System.err.println("Error updating forex rates: " + e.getMessage());
        }
    }
}

