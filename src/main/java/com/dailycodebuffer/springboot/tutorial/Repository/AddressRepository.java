package com.dailycodebuffer.springboot.tutorial.Repository;

import com.dailycodebuffer.springboot.tutorial.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address,Long> {

}
