package com.techprimers.db.entityManagerFactory;

import com.techprimers.db.model.AccumulatedTransactions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccumulatedTransactionsRepository extends JpaRepository<AccumulatedTransactions, Integer> {
}
