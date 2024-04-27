package com.example.demo.repo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.models.Transaction;
import com.example.demo.models.TransactionStatus;


@Transactional
public interface TxnRepository extends JpaRepository<Transaction, Integer>{

	Transaction findByExternalTxnId(String externalTxnId);
	
	@Modifying
	@Query("update Transaction t set t.transactionStatus = :transactionStatus where t.externalTxnId = :externalTxnId")
	void updateTxnStatus(String externalTxnId, TransactionStatus transactionStatus);
}

