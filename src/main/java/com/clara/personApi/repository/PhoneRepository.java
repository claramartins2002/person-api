package com.clara.personApi.repository;

import com.clara.personApi.entity.Phone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PhoneRepository  extends JpaRepository<Phone, Long> {
}
