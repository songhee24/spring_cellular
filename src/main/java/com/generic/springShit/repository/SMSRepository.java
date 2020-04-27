package com.generic.springShit.repository;

import com.generic.springShit.entity.SMS;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SMSRepository extends JpaRepository<SMS,Long> {

}
