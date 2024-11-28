package com.example.todoApp.Repositories;

import com.example.todoApp.Model.ForexRate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ForexRateRepository extends JpaRepository<ForexRate, Long> {
    Optional<ForexRate> findByTargetCurrency(String targetCurrency);
}

