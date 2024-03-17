package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entities.Book;
import com.example.demo.entities.Student;
import com.example.demo.entities.Transaction;
import com.example.demo.entities.enums.TransactionStatus;
import com.example.demo.entities.enums.TransactionType;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer>{

	Transaction findTopByStudentAndBookAndTransactionTypeAndTransactionStatusOrderByTransactionTimeDesc(
            Student student, Book book, TransactionType transactionType, TransactionStatus transactionStatus
    );
}

// create all of the CURD operations
