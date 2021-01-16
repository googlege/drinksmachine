package com.hackerrank.stocktrade.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hackerrank.stocktrade.model.User;

@Repository
@Transactional(propagation = Propagation.MANDATORY)
public interface UserDao extends JpaRepository<User, Long> {
}
