package com.hackerrank.stocktrade.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.exception.StocktradeNotFoundException;
import com.hackerrank.stocktrade.model.Trade;
import com.hackerrank.stocktrade.model.User;
import com.hackerrank.stocktrade.service.TradeService;




@RestController
//@RequestMapping("/trades")
public class TradesController {
    private static final Logger log = LoggerFactory.getLogger(TradesController.class);
    private final TradeService service;

    @Autowired
    public TradesController(TradeService service) {
        super();
        this.service = service;
    }
    
    @RequestMapping(value = "/trades", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Trade> getAll() {
        return service.findAll();
    }
    
    @RequestMapping(value = "/trades/users/{userid}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Trade> getByUser(@PathVariable("userid") Long userid) {
    	Optional<User> user = service.findUser(userid);
    	if (user.isPresent()) {
    		return user.get().getTradeList();
    	}
    	throw new StocktradeNotFoundException();
    }
    
    ///trades/users/1/stocks/A
    @RequestMapping(value = "/trades/users/{userid}/stocks/{symbol}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Trade> getByUserAndSymbol(@PathVariable("userid") Long userid, @PathVariable("symbol") String symbol) {
    	List<Trade> result = service.findAllByUserAndSymbol(userid,symbol);
    	if (result.isEmpty()) {
    		throw new StocktradeNotFoundException();
    	}
    	return result;
    }
    
  ///trades/stocks/A
    @RequestMapping(value = "/trades/stocks/{symbol}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Trade> getBySymbol(@PathVariable("symbol") String symbol) {
    	List<Trade> result = service.findAllBySymbol(symbol);
    	if (result.isEmpty()) {
    		throw new StocktradeNotFoundException();
    	}
    	return result;
    }
    
  ///trades/1
    @RequestMapping(value = "/trades/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public Trade getSelected(@PathVariable Long id) {
    	Optional<Trade> result = service.findOne(id);
    	if (result.isPresent()) {
    		return result.get();
    	}
    	throw new StocktradeNotFoundException();
    }
    
    
    @RequestMapping(value = "/trades", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void insert(@Valid @RequestBody Trade entity,HttpServletResponse response) {
        try {
    	  service.save(entity);
          response.setStatus(HttpServletResponse.SC_CREATED);
        }catch(Exception e) {
        	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
    }
    
    
    
    

    
    

    
    
    

    

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE, produces = MediaType.TEXT_PLAIN_VALUE)
    public String deleteSelected(@PathVariable Long id) {
        try {
            service.deleteById(id);
            return "OK";
        } catch (Exception e) {
            log.error(e.getMessage());
            return e.getMessage();
        }
    }

}  