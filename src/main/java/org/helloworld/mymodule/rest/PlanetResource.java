package org.helloworld.mymodule.rest;

import java.lang.Exception;

import org.helloworld.mymodule.domain.Planet;
import org.helloworld.mymodule.exception.PlanetNotFoundException;
import org.helloworld.mymodule.serviceapi.PlanetDTO;
import org.helloworld.mymodule.serviceapi.PlanetForm;
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
		 PlanetForm planetForm = new PlanetForm();
		    PlanetDTO planet = getPlanetService().findById(serviceContext(), id);
		    planetForm.setDiameter(planet.getDiameter());
		    planetForm.setId(planet.getId());
		    planetForm.setName(planet.getName());
		    planetForm.setVersion(planet.getVersion());
		    modelMap.addAttribute("planetForm", planetForm);
		    return "planet/update";
	}

	@Override
	public String update(PlanetForm planetForm) throws PlanetNotFoundException {
		PlanetDTO planet = getPlanetService().findById(serviceContext(), planetForm.getId());
	    planet.setVersion(planetForm.getVersion());
	    planet.setName(planetForm.getName());
	    planet.setDiameter(planetForm.getDiameter());
	    getPlanetService().save(serviceContext(), planet);
	    return "redirect:/rest/planet/" + planetForm.getId();
	}

}
