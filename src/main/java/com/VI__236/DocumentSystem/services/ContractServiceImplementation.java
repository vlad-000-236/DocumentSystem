package com.VI__236.DocumentSystem.services;

import com.VI__236.DocumentSystem.models.Contract;
import com.VI__236.DocumentSystem.repositories.ContractRepository;
import com.VI__236.DocumentSystem.util.ContractNotFoundException;
import com.VI__236.DocumentSystem.util.dateUtil.DayCalculator;
import com.VI__236.DocumentSystem.util.dateUtil.StringToDateConverter;
import com.VI__236.DocumentSystem.util.dateUtil.SystemDate;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ContractServiceImplementation implements ContractService{
    private final DayCalculator dayCalculator;
    private final StringToDateConverter stringToDateConverter;
    private final ContractRepository contractRepository;
    private final SystemDate systemdate;
    private Contract contract;
    private String overdueCheckingResult;

    @Autowired
    public ContractServiceImplementation(ContractRepository contractRepository, SystemDate systemdate, Contract contract,
                                         StringToDateConverter stringToDateConverter, DayCalculator dayCalculator){
        this.contractRepository = contractRepository;
        this.contract = contract;
        this.stringToDateConverter = stringToDateConverter;
        this.dayCalculator = dayCalculator;
        this.systemdate = systemdate;
    }


    @Override
    @Transactional(readOnly = true)
    public Contract findContractById(int id) {
        Optional<Contract> foundContract = contractRepository.findById(id);
        return foundContract.orElseThrow(ContractNotFoundException::new);
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public void createContract(Contract contract) {
        contractRepository.save(contract);
        contract.setCreationDate(systemdate.systemDate());
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public String overdueChecking(int id) {
        contract = findContractById(id);
        try {
            if (stringToDateConverter.stringToDate(
                    contract.getEnding()).before(stringToDateConverter.stringToDate(contract.getBeginning()))){

                overdueCheckingResult = "Договор просрочен на " +
                        dayCalculator.dayCalculator(contract.getEnding(), contract.getBeginning()) + " дней!";
            } else {
                overdueCheckingResult = "Договор не просрочен.";
            }
        }
        catch (ParseException e){
            System.out.println("Ошибка подсчёта дней: " + e);
        }
        return overdueCheckingResult;
    }
}
