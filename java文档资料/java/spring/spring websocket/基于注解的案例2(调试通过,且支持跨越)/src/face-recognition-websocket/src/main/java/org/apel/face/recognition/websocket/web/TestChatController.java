package org.apel.face.recognition.websocket.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("testChat")
public class TestChatController {
	
	@RequestMapping(value="index",method=RequestMethod.GET)
	public String index(){
		System.out.println();
		return "index";
	}

}