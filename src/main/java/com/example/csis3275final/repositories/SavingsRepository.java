package com.example.csis3275final.repositories;

import com.example.csis3275final.entities.Savings;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SavingsRepository extends JpaRepository<Savings,Long> {

    List<Savings> findCustomerbyID (long kw);
}
