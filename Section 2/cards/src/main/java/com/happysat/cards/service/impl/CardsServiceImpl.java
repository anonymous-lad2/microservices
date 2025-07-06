package com.happysat.cards.service.impl;

import com.happysat.cards.dto.CardsDto;
import com.happysat.cards.entity.Cards;
import com.happysat.cards.repository.CardRepository;
import com.happysat.cards.service.CardsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CardsServiceImpl implements CardsService {

    private CardRepository cardRepository;

    @Override
    public void createCard(String mobileNumber) {
        Optional<Cards> opt = cardRepository.findByMobileNumber(mobileNumber);

    }

    @Override
    public CardsDto fetchCard(String mobileNumber) {
        return null;
    }

    @Override
    public boolean updateCard(CardsDto cardsDto) {
        return false;
    }

    @Override
    public boolean deleteCard(String mobileNumber) {
        return false;
    }
}
