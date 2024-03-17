package com.example.demo.service;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.example.demo.dtos.SearchBookRequest;
import com.example.demo.entities.Book;
import com.example.demo.entities.Student;
import com.example.demo.entities.Transaction;
import com.example.demo.entities.enums.TransactionStatus;
import com.example.demo.entities.enums.TransactionType;
import com.example.demo.repository.TransactionRepository;

@Service
public class TransactionService {

	@Autowired
	StudentService studentService;
	
	@Autowired
	BookService bookService;
	
	@Value("${student.issue.max_books}")
	private int maxBooksForIssuance;
	@Value("${student.issue.number_of_days}")
	private int numberOfDaysForIssuance;
	
	@Autowired
	TransactionRepository transactionRepository;
	
	
	public String issueBook(String bookName, int studentId) throws Exception {
		List<Book> bookList;
		
		try {
			bookList = bookService.search(
					SearchBookRequest.builder()
					.searchKey("name")
					.searchValue(bookName)
					.operator("=")
					.build()
					);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new Exception("Book not found");
		}
		
		// Validations 
		if(bookList.isEmpty()) {
			throw new Exception("Book not available or not found");
		}
		
		Student student = studentService.get(studentId);
		
		if(student.getBookList()!=null && student.getBookList().size()>=maxBooksForIssuance) {
			throw new Exception("Book limit Reached");
		}
		
		Book book = bookList.get(0);
		
		Transaction transaction = Transaction.builder()
				.externalTxnId(UUID.randomUUID().toString())
				.transactionType(TransactionType.ISSUE)
				.my_book(book)
				.my_student(student)
				.transactionStatus(TransactionStatus.PENDING)
				.build();
		
		try {
			book.setMy_student(student);
			// Function Pending for Assignment bookService.ass
			bookService.assignBookToStudent(book, student);
			transaction.setTransactionStatus(TransactionStatus.SUCCESS);
		}catch (Exception e) {
			// TODO: handle exception
			transaction.setTransactionStatus(TransactionStatus.FAILED);

		}finally {
            return transactionRepository.save(transaction).getExternalTxnId();
		}
		
	}
	
	public String returnTxn(int bookId,int studentId) throws Exception {
		Book book;
		
		try {
			book = bookService.search(SearchBookRequest.builder().searchKey("id").searchValue(String.valueOf(bookId)).build()).get(0);
		}catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Not able to fetch the book details.");
		}
		
		if(book.getMy_student()==null || book.getMy_student().getId() != studentId) {
			throw new Exception("Book is not assigned to the student");
		}
		
		Student student = studentService.get(studentId);
		
		Transaction transaction = Transaction.builder()
				.externalTxnId(UUID.randomUUID().toString())
				.transactionType(TransactionType.RETURN)
				.my_book(book)
				.my_student(student)
				.transactionStatus(TransactionStatus.PENDING)
				.build();
        transaction = transactionRepository.save(transaction);

        
		Transaction issueTransaction = transactionRepository.findTopByStudentAndBookAndTransactionTypeAndTransactionStatusOrderByTransactionTimeDesc(student, book, TransactionType.ISSUE, TransactionStatus.SUCCESS);
		
		
		// Logic for fine calc
		long issueTxnInMillis = issueTransaction.getTransactionTime().getTime();
		long currentTimeInMillis = System.currentTimeMillis();
		
		long timeDifferInMillis = currentTimeInMillis-issueTxnInMillis;
		
		long timeDifferInDays = TimeUnit.DAYS.convert(timeDifferInMillis,TimeUnit.MILLISECONDS);
		
		Double fine = 0.0;
		
		if(timeDifferInDays>numberOfDaysForIssuance) {
			fine = (timeDifferInDays-numberOfDaysForIssuance)*1.0;
			
		}
		
		try{
			book.setMy_student(null);
			bookService.unassignBookFromStudent(book);
			
			transaction.setTransactionStatus(TransactionStatus.SUCCESS);
			return transaction.getExternalTxnId();
		}catch (Exception e) {
			// TODO: handle exception
			transaction.setTransactionStatus(TransactionStatus.FAILED);

		}finally {
			transaction.setFine(fine);
            return transactionRepository.save(transaction).getExternalTxnId();
		}
		
			
		
	}
	
	
}
