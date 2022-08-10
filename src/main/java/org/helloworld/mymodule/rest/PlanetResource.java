package org.helloworld.mymodule.rest;

import java.lang.Exception;


import org.helloworld.mymodule.serviceapi.PlanetDTO;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Implementation of PlanetResource.
 */
@Controller
public class PlanetResource extends PlanetResourceBase {

	public PlanetResource() {
	}

	@RequestMapping(value = "/planet/form", method = RequestMethod.GET)
	public String createForm(ModelMap modelMap) {
		PlanetDTO planet = new PlanetDTO();
		modelMap.addAttribute("planet", planet);
		return "planet/create";
	}

	@RequestMapping(value = "/planet/{id}/form", method = RequestMethod.GET)
	public String updateForm(@PathVariable("id") Long id, ModelMap modelMap) throws Exception {
		PlanetDTO planet = getPlanetService().findById(serviceContext(), id);
		modelMap.addAttribute("planet", planet);
		return "planet/update";
	}

}
