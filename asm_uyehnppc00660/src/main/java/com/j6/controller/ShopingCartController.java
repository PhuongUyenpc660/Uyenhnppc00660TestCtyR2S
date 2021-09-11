package com.j6.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ShopingCartController {
	@RequestMapping("/cart/view")
	public String list() {
		return "cart/view";
	}

	
}
