package com.example.demo.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.Wallet;

@Transactional
public interface WalletRepository extends JpaRepository<Wallet, Integer>{

	
	Wallet findByMobile(String mobile);
	
	@Modifying
	@Query("update Wallet w set w.balance = w.balance + :amount where w.mobile=mobile")
	void updateWallet(String mobile, Double amount);
}
