package com.example.demo.entities;

import java.util.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.example.demo.entities.enums.TransactionStatus;
import com.example.demo.entities.enums.TransactionType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String externalTxnId;
	
	@CreationTimestamp
	private Date transactionTime;
	@UpdateTimestamp
	private Date updatedOn;
	
	private TransactionStatus transactionStatus;
	
	private TransactionType transactionType;
	
	@ManyToOne
	@JoinColumn
	private Book my_book;
	@ManyToOne
	@JoinColumn
	private Student my_student;
	
	private Double fine;
	
}
