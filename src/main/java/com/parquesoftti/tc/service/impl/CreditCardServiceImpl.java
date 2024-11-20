package com.parquesoftti.tc.service.impl;

import com.parquesoftti.tc.model.CreditCard;
import com.parquesoftti.tc.repository.CreditCardRespository;
import com.parquesoftti.tc.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
@Service
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRespository creditCardRespository;
    private CreditCardRespository creditCardRepository;

    @Override
    @Transactional(readOnly = true)
    public List<CreditCard> getCreditCards() {
        return creditCardRespository.findAll();
    }

    @Override
    public Optional<CreditCard> getCardById(Long id) {
        return creditCardRespository.findById(id);
    }

    @Override
    public CreditCard saveCreditCard(CreditCard creditCard) {
        return creditCardRespository.save(creditCard);
    }

    @Override
    public CreditCard uptdateCreditCard(CreditCard creditCard, Long id) {
        if (id == null || id <= 0) {
            throw new RuntimeException("No me enviaron el ID");
        }
        Optional<CreditCard> tmp = getCardById(id);
        if (tmp.get()==null){
            throw new RuntimeException("No se encontro en la base de datos");
        }
        creditCard.setId(id);
        return creditCardRespository.save(creditCard);
    }

    @Override
    public void deleteCard(Long id) {
        creditCardRespository.deleteById(id);
    }

    @Transactional(readOnly = true)
    @Override
    public CreditCard getCreditCardsByCardNumber(String cardNumber) {
        var tmp=creditCardRepository.findCreditCardByCardNumber(cardNumber);

        if (tmp.isPresent()) {
            return tmp.get();
        }else {
            throw new IllegalArgumentException("El numero de credito no existe");
        }
    }
}
