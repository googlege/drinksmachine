package com.hackerrank.stocktrade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hackerrank.stocktrade.dao.TradeDao;
import com.hackerrank.stocktrade.dao.UserDao;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;

/**
 *
 * @author MBition GmbH Viatcheslav Mikhalev
 * @version 1.0
 * 
 */

@Service(TradeService.SERVICE_NAME)
@Transactional(propagation = Propagation.REQUIRED, rollbackFor = Throwable.class)
public class TradeService {
    public static final String SERVICE_NAME = "tradeService";
    private final TradeDao tradeDao;
    private final UserDao userDao;

    @Autowired
    public TradeService(TradeDao tradeDao, UserDao userDao) {
        super();
        this.tradeDao = tradeDao;
        this.userDao = userDao;
    }

    public Trade save(Trade entity) {
    	User user=entity.getUser();
    	if (user.getId()!=null) {
    		Optional<User> storedUser=userDao.findById(user.getId());
    		if (!storedUser.isPresent()) {
    			user=userDao.save(user);
    		}
    	}
    	else {
    		user=userDao.save(user);
    	}
    	if (entity.getId()!=null) {
    		Optional<Trade> wrongObj=tradeDao.findById(entity.getId());
    		//na ja...je nach dem..
    		if (wrongObj.isPresent()) {
    			throw new RuntimeException("Entity with same id found");
    		}
    	}
    	entity.setUser(user);
    	return tradeDao.save(entity);
    }

    public List<Trade> findAll() {
        return tradeDao.findAll(Sort.by("id"));
    }

    public Optional<Trade> findOne(Long id) {
        return tradeDao.findById(id);
    }
    
    public Optional<User> findUser(Long userId) {
        return userDao.findById(userId);
    }

    public void deleteById(Long id) {
    	tradeDao.deleteById(id);
    }
    
    
    
    public List<Trade> findAllByUser(Long userId) {
        return userDao.findById(userId).get().getTradeList();
    }
    
    public List<Trade> findAllByUserAndSymbol(Long userID,String symbol){
    	return tradeDao.findAllByUserAndSymbol(userID,symbol);
    }
    
    public List<Trade> findAllBySymbol(String symbol){
    	return tradeDao.findAllBySymbol(symbol);
    }
   
    
    public void deleteAll() {
        tradeDao.deleteAll();
    }

}
