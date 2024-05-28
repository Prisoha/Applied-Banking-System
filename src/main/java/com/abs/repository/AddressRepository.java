package com.abs.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.abs.model.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{

}
