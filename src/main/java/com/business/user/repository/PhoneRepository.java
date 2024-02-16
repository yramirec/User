package com.business.user.repository;

import com.business.user.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PhoneRepository extends JpaRepository<Phone,String> {

}
