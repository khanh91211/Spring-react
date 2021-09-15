package com.it15301.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.it15301.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer>{

}
