package org.helloworld.mymodule.rest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Implementation of HelloWorldResource.
 */
@Controller
public class HelloWorldResource extends HelloWorldResourceBase {

	public HelloWorldResource() {
	}

	@RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
	public String hello(@RequestParam("msg") String msg, ModelMap modelMap) {
		
		 modelMap.addAttribute("result", msg);
		 return "helloworld/hello";
	}

}
