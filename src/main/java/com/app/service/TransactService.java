package com.app.service;

import java.util.List;


import com.app.dto.TransactionDto;

public interface TransactService {

	TransactionDto addTransaction (TransactionDto dto);
	
	List<TransactionDto> getAllTransactionFromInvestor(Long investorId);
	
	
}
