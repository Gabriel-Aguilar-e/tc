package com.parquesoftti.tc.repository;

import com.parquesoftti.tc.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository  extends JpaRepository<CreditCard, Long> {
}
