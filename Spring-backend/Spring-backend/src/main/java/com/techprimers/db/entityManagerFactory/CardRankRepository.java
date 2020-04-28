package com.techprimers.db.entityManagerFactory;

import com.techprimers.db.model.CardRank;
import com.techprimers.db.model.LocyaltyCards;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CardRankRepository {

    List<CardRank> getCardRank(String code);

    String updateCardRank(CardRank card);


}
