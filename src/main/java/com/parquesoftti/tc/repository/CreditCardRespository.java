package com.parquesoftti.tc.repository;

import com.parquesoftti.tc.model.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditCardRespository extends JpaRepository<CreditCard, Long> {
}
