package com.VI__236.DocumentSystem.controlers;

import com.VI__236.DocumentSystem.models.Contract;
import com.VI__236.DocumentSystem.services.ContractService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/contracts")
public class AppController {
    private ContractService contractService;
    private Contract contract;
    public AppController(ContractService contractService, Contract contract){
        this.contractService = contractService;
        this.contract = contract;
    }

    @GetMapping()
    public String home(){
        return "home";
    }

    @GetMapping("/find")
    public String finder(Model model){
        model.addAttribute("contract", new Contract());
        return "find";
    }

    @PostMapping("/show")
    public String showContract(int id, Model model){
        model.addAttribute("contract", contractService.findContractById(id));
        model.addAttribute("contractStatus", contractService.overdueChecking(id));
        return "show";
    }

    @GetMapping("/new_contr")
    public String newContract(Model model){
        model.addAttribute("contract", new Contract());
        return "new_contr";
    }

   @PostMapping()
    public String create(@ModelAttribute("contract") Contract contract){
        contractService.createContract(contract);
        return "redirect:/contracts";
    }
}
