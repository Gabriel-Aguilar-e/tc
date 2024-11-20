package com.parquesoftti.tc.service;

import com.parquesoftti.tc.model.CreditCard;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface CreditCardService {
    public List<CreditCard> getCreditCards();

    public Optional<CreditCard> getCardById(Long id);

    CreditCard saveCreditCard(CreditCard creditCard);

    CreditCard uptdateCreditCard(CreditCard creditCard, Long id);

    void deleteCard(Long id);

    @Transactional(readOnly = true)
    CreditCard getCreditCardsByCardNumber(String cardNumber);
}
