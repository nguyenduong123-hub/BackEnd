package com.techprimers.db.entityManagerFactory;

import com.techprimers.db.model.LocyaltyCards;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class LocyaltyCardsRepositoryImpl extends BaseRepository implements LocyaltyCardsRepository{
    @Override
    public List<LocyaltyCards> getCode(String code) {
        Map<String, Object> params = new HashMap<>();
        String sql = SQLBuilder
                .getSqlQueryById(SQLBuilder.SQL_MR_MAINTENANCE_MNGT, "get-List-Loyal-by-Code");
        if (!StringUtils.isStringNullOrEmpty(code)) {
            params.put("code", code);
        }
        List<LocyaltyCards> list = getNamedParameterJdbcTemplate().query(sql, params,
                BeanPropertyRowMapper.newInstance(LocyaltyCards.class));
        return list;
    }

    @Override
    public String updateLoyaltyCards(LocyaltyCards locyaltyCards) {
        String result = "SUCCESS";
        getEntityManager().merge(locyaltyCards);
        return result;
    }
}
