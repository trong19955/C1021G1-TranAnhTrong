package com.trongtran.codegym.repository;

import com.trongtran.codegym.model.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IContractRepository extends JpaRepository<Contract,Integer> {

    Page<Contract> findByCustomer_CustomerName(String customerName, Pageable pageable);

    Page<Contract> findByCustomer_CustomerNameAndServiceType_ServiceTypeId(String customerName, Integer serviceTypeId, Pageable pageable);

}
