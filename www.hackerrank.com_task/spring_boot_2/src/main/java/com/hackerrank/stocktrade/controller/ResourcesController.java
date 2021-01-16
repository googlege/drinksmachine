package com.hackerrank.stocktrade.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.stocktrade.service.TradeService;

@RestController
@RequestMapping(value = "/erase")
public class ResourcesController {
	
	private final TradeService service;

    @Autowired
    public ResourcesController(TradeService service) {
        super();
        this.service = service;
    }
	
	@RequestMapping(method = RequestMethod.DELETE)
    public void deleteAll() {
         service.deleteAll();
    }
}
