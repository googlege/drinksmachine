package com.hackerrank.stocktrade.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hackerrank.stocktrade.model.Trade;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface TradeDao extends JpaRepository<Trade, Long> {
	
	@Query("SELECT t FROM Trade t WHERE t.user.id = :userID and t.symbol = :symbol ORDER BY t.id ASC")
	public List<Trade> findAllByUserAndSymbol(@Param("userID") long userID,@Param("symbol") String symbol);

	@Query("SELECT t FROM Trade t WHERE t.symbol = :symbol ORDER BY t.id ASC")
	public List<Trade> findAllBySymbol(@Param("symbol") String symbol);
}
