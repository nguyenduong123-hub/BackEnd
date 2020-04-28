package com.techprimers.db.resource;


import com.techprimers.db.entityManagerFactory.AccumulatedTransactionsRepository;
import com.techprimers.db.entityManagerFactory.CardRankRepository;
import com.techprimers.db.entityManagerFactory.ConfigRepository;
import com.techprimers.db.entityManagerFactory.LocyaltyCardsRepository;
import com.techprimers.db.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping(value = "/rest/transaction")
public class AccumulatedTransactionsResource {

    @Autowired
    AccumulatedTransactionsRepository transactionsRepository; //Giao dich tich diem

    @Autowired
    CardRankRepository rankRepository; // Hang the

    @Autowired
    LocyaltyCardsRepository locyaltyCardsRepository; //The tich diem

    @Autowired
    ConfigRepository configRepository;

    List<Config> lstConfig = new ArrayList<>();

    @RequestMapping(value = "/insertTransaction", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResultDTO insertTransaction(@RequestBody List<LocyaltyCards> locyaltyCardsDTO) {
        //input truyền vào bao gồm Code (mã thẻ ) và Revenue ( doanh thu ) từ CLIENT truyền xuống
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setKey("SUCCESS");
        //Lay Config
        lstConfig = configRepository.findAll();
        // Xử lý nhiều reqest
        if (locyaltyCardsDTO != null) {
            for (LocyaltyCards itemLocy : locyaltyCardsDTO) {
                if (itemLocy.getCode() != null && itemLocy.getRevenue() != null) {
                    //Lay thong tin tich diem
                    List<LocyaltyCards> lstLoyal = new ArrayList<>();
                    lstLoyal = locyaltyCardsRepository.getCode(itemLocy.getCode());
                    if (lstLoyal != null && lstLoyal.size() > 0) {
                        //Lay thong tin the
                        LocyaltyCards locyaltyCards1 = lstLoyal.get(0);
                        List<CardRank> lstCard = new ArrayList<>();
                        lstCard = rankRepository.getCardRank(locyaltyCards1.getCode());
                        if (lstCard != null && lstCard.size() > 0) {
                            CardRank cardRank1 = lstCard.get(0);
                            if (locyaltyCards1 != null && cardRank1 != null) {
                                AccumulatedTransactions dto = new AccumulatedTransactions();
                                dto.setIdLoyaltyCard(locyaltyCards1.getCode());
                                dto.setCreatedDate(new Date());
                                Integer revenue = itemLocy.getRevenue();
                                // Check doanh thu
                                if (revenue != null) {
                                    if (lstConfig != null && !lstConfig.isEmpty()) {
                                        //Neu doanh thu == config ==> set value của config la diem cua the tich diem
                                        //Insert giao dich
                                        //Tinh so diem va cap nhat so diem cho the tich diem
                                        for (Config item : lstConfig) {
                                            if (revenue.equals(item.getConfig())) {
                                                dto.setAdjustmentPoint(item.getConfig());
                                                dto.setAdjustmentRevenue(revenue);
                                                locyaltyCards1.setPoint(locyaltyCards1.getPoint() + item.getConfig());
                                                locyaltyCards1.setRevenue(locyaltyCards1.getRevenue() + revenue);
                                                locyaltyCards1.setUpdateDate(new Date());
                                                break;
                                            }

                                        }
                                        transactionsRepository.save(dto);
//                            locyaltyCardsRepository.update(locyaltyCards1);
                                    }
                                }
                                //Lay the tich diem sau khi cap nhat diem ==> Check hang the và cap nhat hang the cho The Tich Diem và Hang The
//                    LocyaltyCards locyalty = locyaltyCardsRepository.getCode(locyaltyCards1.getCode());
                                String cardCopper = "Thẻ Đồng";
                                String cardSilver = "Thẻ Bạc";
                                String cardGold = "Thẻ Vàng";
                                Integer pointSilver = 100;
                                Integer pointGold = 200;
                                Integer pointRuby = 300;
                                Date updateDate = new Date();
                                long diff = updateDate.getTime() - cardRank1.getCreatedate().getTime();
                                long diffDays = diff / (24 * 60 * 60 * 1000);
                                if (locyaltyCards1.getCardrank().equals(cardCopper)) {
                                    //Nếu đang là thẻ đồng ==> thẻ bạc
                                    if (locyaltyCards1.getPoint() == 100) {
                                        locyaltyCards1.setCardrank(cardSilver);
                                        cardRank1.setNamecardrank(locyaltyCards1.getCardrank());
                                        //Update cho bang hang the
                                        cardRank1.setPromotionsales(pointGold - pointSilver);
                                        cardRank1.setUpdateddate(updateDate);
                                        cardRank1.setDiscount("10%");
                                        cardRank1.setDuration(String.valueOf(diffDays));
                                        System.out.print(diffDays + " days, ");

                                    } else {
                                        //Nếu update chưa lên
                                        cardRank1.setPromotionsales(pointSilver - locyaltyCards1.getPoint());
                                        cardRank1.setUpdateddate(updateDate);
                                        cardRank1.setDuration(String.valueOf(diffDays));
                                    }
                                    // Nâng lên thẻ vàng
                                } else if (locyaltyCards1.getPoint() == 200) {
                                    locyaltyCards1.setCardrank(cardGold);
                                    cardRank1.setNamecardrank(locyaltyCards1.getCardrank());
                                    cardRank1.setPromotionsales(pointRuby - pointGold);
                                    cardRank1.setUpdateddate(updateDate);
                                    cardRank1.setDuration(String.valueOf(diffDays));
                                    cardRank1.setDiscount("20%");
                                } else {
                                    cardRank1.setPromotionsales(pointGold - locyaltyCards1.getPoint());
                                    cardRank1.setUpdateddate(updateDate);
                                    cardRank1.setDuration(String.valueOf(diffDays));

                                }
                                locyaltyCardsRepository.updateLoyaltyCards(locyaltyCards1);
                                rankRepository.updateCardRank(cardRank1);
                            }
                        }
                    } else {
                        System.out.println("Mã giao dịch không hợp lệ" + " " + itemLocy.getCode());
                    }
                }
            }
        }
        return resultDTO;
    }
}
