package com.techprimers.db.entityManagerFactory;

import com.techprimers.db.model.CardRank;
import com.techprimers.db.model.LocyaltyCards;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocyaltyCardsRepository  {
    List<LocyaltyCards> getCode(String code);

    String updateLoyaltyCards(LocyaltyCards locyaltyCards);

}
