package com.aidr.app.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ScreenController extends BaseController{


	@RequestMapping("protected/home")
	public String home(Map<String, String> model) throws Exception {
		return "home";
	}
	
	@RequestMapping("protected/task")
	public String task() throws Exception {
		return "task";
	}
	
	@RequestMapping("protected/master")
	public String master(Map<String, String> model) throws Exception {
		return "master";
	}
	
	@RequestMapping("protected/collection")
	public String collection(Map<String, String> model) throws Exception {
		return "collection";
	}
}
