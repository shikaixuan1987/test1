package com.beafoodie.usshike.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyPageController {
	
	@RequestMapping(value = "/mypage", method = RequestMethod.GET)
	public String myPage(Map<String, Object> map) {
		return "mypage";
	}

}
