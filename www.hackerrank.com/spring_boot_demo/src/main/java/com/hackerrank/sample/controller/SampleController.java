package com.hackerrank.sample.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hackerrank.sample.dto.StringResponse;

@RestController
public class SampleController {
	@RequestMapping(value = "/defaultHello", method = RequestMethod.GET)
    public StringResponse defaultGetHello(@RequestParam(name = "message",required=false) String message) {
        return new StringResponse("Default Hello World!");
    }

    @RequestMapping(value = "/customHello", method = RequestMethod.POST)
    public StringResponse customPostHello(@RequestParam(name = "message",required=true) String message) {
        StringBuilder response=new StringBuilder(60);
        response.append("Custom ").append(message);
        return new StringResponse(response.toString());
    }
}
