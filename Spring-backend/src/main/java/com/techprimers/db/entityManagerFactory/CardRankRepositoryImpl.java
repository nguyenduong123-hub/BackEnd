package com.techprimers.db.entityManagerFactory;

import com.techprimers.db.model.CardRank;
import com.techprimers.db.model.LocyaltyCards;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class CardRankRepositoryImpl extends BaseRepository implements CardRankRepository {

    @Override
    public List<CardRank> getCardRank(String code) {
        Map<String, Object> params = new HashMap<>();
        String sql = SQLBuilder
                .getSqlQueryById(SQLBuilder.SQL_MR_MAINTENANCE_MNGT, "get-List-Card-Rank-By-Code");
        if (!StringUtils.isStringNullOrEmpty(code)) {
            params.put("code", code);
        }
        List<CardRank> list = getNamedParameterJdbcTemplate().query(sql, params,
                BeanPropertyRowMapper.newInstance(CardRank.class));
        return list;
    }

    @Override
    public String updateCardRank(CardRank card) {
        String result = "SUCCESS";
        getEntityManager().merge(card);
        return result;
    }
}
