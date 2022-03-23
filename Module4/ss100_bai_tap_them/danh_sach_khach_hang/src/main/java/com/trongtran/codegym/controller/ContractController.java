package com.trongtran.codegym.controller;

import com.trongtran.codegym.dto.ContractDto;
import com.trongtran.codegym.model.Contract;
import com.trongtran.codegym.model.Customer;
import com.trongtran.codegym.model.ServiceType;
import com.trongtran.codegym.repository.ICustomerRepository;
import com.trongtran.codegym.repository.IServiceTypeRepository;
import com.trongtran.codegym.service.IContractService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping(value = "/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @ModelAttribute("customers")
    public Iterable<Customer> customers() {
        return this.iCustomerRepository.findAll();
    }

    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;

    @ModelAttribute("serviceTypes")
    public Iterable<ServiceType> serviceTypes() {
        return this.iServiceTypeRepository.findAll();
    }

    @GetMapping(value = "")
    public String getAllContracts(Model model, @PageableDefault(size = 2) Pageable pageable,
                                  @RequestParam(name = "customerName") Optional<String> customerName,
                                  @RequestParam(name = "serviceType") Optional<Integer> serviceType) {
//        Page<Contract> contracts = this.iContractService.findAll(pageable);
//        model.addAttribute("contracts",contracts);
//        return "list";

        boolean nameNotNull = customerName.isPresent() && !customerName.get().equals("");
        boolean idNotNull = serviceType.isPresent();

        if (nameNotNull)
            model.addAttribute("customerName",customerName.get());

        if (idNotNull)
            model.addAttribute("serviceType",serviceType.get());

        Page<Contract> contracts = null;

        if (!nameNotNull && !idNotNull)
            contracts = this.iContractService.findAll(pageable);

        if (nameNotNull & !idNotNull)
            contracts = this.iContractService.findByCustomer_CustomerName(customerName.get(),pageable);

        if (!nameNotNull & idNotNull)
            contracts = this.iContractService.findByServiceType_ServiceTypeId(serviceType.get(),pageable);

        if (nameNotNull & idNotNull)
            contracts = this.iContractService.findByCustomer_CustomerNameAndServiceType_ServiceTypeId(customerName.get(),serviceType.get(),pageable);

        model.addAttribute("contracts",contracts);
        return "list";

    }

    @GetMapping(value = "/create")
    public String addForm(Model model) {
        model.addAttribute("contract", new ContractDto());
        return "create";
    }

    @PostMapping(value = "/save")
    public String saveContract(@Validated @ModelAttribute(name = "contract") ContractDto contractDto, BindingResult bindingResult) {
//        this.iContractService.save(contract);
//        return "redirect:/contract/";

        new ContractDto().validate(contractDto,bindingResult);

        if (bindingResult.hasFieldErrors())
            return "create";
        else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto,contract);
            this.iContractService.save(contract);
            return "redirect:/contract";
        }

    }

    @GetMapping(value = "/{id}/edit")
    public String editForm(@PathVariable Integer id, Model model) {
        Optional<Contract> contractOptional = this.iContractService.findById(id);

        if (contractOptional.isPresent()) {
            model.addAttribute("contract",contractOptional.get());
            return "edit";
        } else {
            return "error.404";
        }
    }

    @PostMapping(value = "/update")
    public String editContract(@ModelAttribute(name = "contract") Contract contract) {
        this.iContractService.save(contract);
        return "redirect:/contract/";
    }

    @GetMapping(value = "/{id}/delete")
    public String deleteForm(@PathVariable Integer id, Model model) {
        Optional<Contract> contractOptional = this.iContractService.findById(id);

        if (contractOptional.isPresent()) {
            model.addAttribute("contract",contractOptional.get());
            return "delete";
        } else {
            return "error.404";
        }
    }

    @PostMapping(value = "/delete")
    public String deleteContract(@ModelAttribute(name = "contract") Contract contract) {
        this.iContractService.remove(contract.getContractId());
        return "redirect:/contract/";
    }

}