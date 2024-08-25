package com.VI__236.DocumentSystem.repositories;

import com.VI__236.DocumentSystem.models.Contract;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface ContractRepository extends JpaRepository<Contract, Integer> {
}
