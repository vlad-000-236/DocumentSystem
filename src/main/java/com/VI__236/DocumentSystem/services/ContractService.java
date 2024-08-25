package com.VI__236.DocumentSystem.services;

import com.VI__236.DocumentSystem.models.Contract;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public interface ContractService {

    Contract findContractById(int id);

    void createContract(Contract contract);

    String overdueChecking(int id);
}
