package com.app.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.custom_exceptions.ResourceNotFoundException;
import com.app.dao.TransactionDao;
import com.app.dao.UserEntityDao;
import com.app.dto.ProductDto;
import com.app.dto.TransactionDto;
import com.app.entities.Product;
import com.app.entities.Transaction;
import com.app.entities.Users;

@Transactional
@Service
public class TransactionServiceImple implements TransactService {

@Autowired
private	TransactionDao transactionRepo;

@Autowired
private UserEntityDao investorRepo;	

@Autowired
private ModelMapper mapper;

	
	
	@Override
	public TransactionDto addTransaction(TransactionDto dto) {

		Users investor =investorRepo.findById(dto.getInvestorId())
		.orElseThrow(() -> new ResourceNotFoundException("Invalid  investorId!!!"));
		Transaction  transaction = mapper.map(dto,Transaction.class);
		 
		 investor.addTransaction(transaction);
		 
		 Transaction saveTransaction =transactionRepo.save(transaction);
		 
		
		 
		 return mapper.map(saveTransaction ,TransactionDto.class );
	}
	
	public Transaction findTransactionById(Long transactionId){
	return transactionRepo.findById(transactionId).get();
}
	
	@Override
	public List<TransactionDto> getAllTransactionFromInvestor(Long investorId) {
		List<Transaction> transactionList = transactionRepo.findByInvestorId(investorId);
		return transactionList.stream().map(transaction -> mapper.map(transaction, TransactionDto.class)).collect(Collectors.toList());
	}
	
	public List<Transaction> findAllTransaction(){
	return transactionRepo.findAll();
}
	
}
	
//	public Transaction findTransactionById(Long transactionId){
//		return transactionRepo.findById(transactionId).get();
//	}
//	

//	
//	@Override
//	public List<TransactionDto> getAllTransactionFromInvestor(Long investorId) {
//		List<Transaction> transactionList = transactionRepo.findByInvestorId(investorId);
//		return transactionList.stream().map(transaction -> mapper.map(transaction, TransactionDto.class)).collect(Collectors.toList());
//	}
//	
//	public void deleteTransactionbyId(Long transactionId) {
//		transactionRepo.deleteById(transactionId);
//		
//	}
//
//}
