package org.helloworld.mymodule.rest;

import java.io.IOException;
import java.lang.Exception;
import java.lang.IllegalArgumentException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.helloworld.mymodule.exception.PlanetNotFoundException;
import org.helloworld.mymodule.serviceapi.PlanetDTO;
import org.helloworld.mymodule.serviceapi.PlanetService;
import org.sculptor.framework.context.ServiceContext;
import org.sculptor.framework.context.ServiceContextStore;
import org.sculptor.framework.errorhandling.OptimisticLockingException;
import org.sculptor.framework.errorhandling.SystemException;
import org.sculptor.framework.errorhandling.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Generated base class for implementation of PlanetResource.
 * <p>
 * Make sure that subclass defines the following annotations:
 * 
 * <pre>
 * @org.springframework.stereotype.Controller
 * </pre>
 */
public abstract class PlanetResourceBase {

	public PlanetResourceBase() {
	}

	protected ServiceContext serviceContext() {
		return ServiceContextStore.get();
	}

	@InitBinder
	protected void initBinder(WebDataBinder binder) throws Exception {
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(false));
	}

	@Autowired
	private PlanetService planetService;

	protected PlanetService getPlanetService() {
		return planetService;
	}

	@RequestMapping(value = "/planet/{id}", method = RequestMethod.GET)
	public String show(@PathVariable("id") Long id, ModelMap modelMap) throws PlanetNotFoundException {
		PlanetDTO result = planetService.findById(serviceContext(), id);
		modelMap.addAttribute("result", result);
		return "planet/show";
	}

	@RequestMapping(value = "/planet", method = RequestMethod.POST)
	public String create(@RequestBody PlanetDTO planet) {
		PlanetDTO result = planetService.save(serviceContext(), planet);
		return String.format("redirect:/rest/planet/%s", result.getId());
	}

	@RequestMapping(value = "/planet", method = RequestMethod.PUT)
	public String update(@RequestBody PlanetDTO planet) {
		PlanetDTO result = planetService.save(serviceContext(), planet);
		return String.format("redirect:/rest/planet/%s", result.getId());
	}

	@RequestMapping(value = "/planet/{id}", method = RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) throws Exception {
		// TODO: can't delete due to no matching findById method in service
		return "redirect:/rest/planet";
	}

	@RequestMapping(value = "/planet", method = RequestMethod.GET)
	public String showAll(ModelMap modelMap) {
		List<PlanetDTO> result = planetService.findAll(serviceContext());
		modelMap.addAttribute("result", result);
		return "planet/showlist";
	}

	@RequestMapping(value = "/planet/filter/{value}", method = RequestMethod.GET)
	public String filter(@PathVariable("value") String value, ModelMap modelMap) {
		List<PlanetDTO> result = planetService.findAllMatching(serviceContext(), value);
		modelMap.addAttribute("result", result);
		return "planet/showlist";
	}

	/*
	 * @org.springframework.web.bind.annotation.RequestMapping(value = "/planet/form",
	 * method=org.springframework.web.bind.annotation.RequestMethod.GET) public String createForm(org.springframework.ui.ModelMap
	 * modelMap )
	 */
	public abstract String createForm(ModelMap modelMap);

	/*
	 * @org.springframework.web.bind.annotation.RequestMapping(value = "/planet/{id}/form",
	 * method=org.springframework.web.bind.annotation.RequestMethod.GET) public String
	 * updateForm(@org.springframework.web.bind.annotation.PathVariable("id") Long id , org.springframework.ui.ModelMap modelMap )
	 * throws java.lang.Exception
	 */
	public abstract String updateForm(Long id, ModelMap modelMap) throws Exception;

	/**
	 * This method is needed for form data POST. Delegates to {@link #create}
	 */
	@RequestMapping(value = "/planet", method = RequestMethod.POST, headers = "content-type=application/x-www-form-urlencoded")
	public String createFromForm(@ModelAttribute("planet") PlanetDTO planet) {
		return create(planet);
	}

	/**
	 * This method is needed for form data PUT. Delegates to {@link #update}
	 */
	@RequestMapping(value = "/planet", method = RequestMethod.PUT, headers = "content-type=application/x-www-form-urlencoded")
	public String updateFromForm(@ModelAttribute("planet") PlanetDTO planet) {
		return update(planet);
	}

	@ExceptionHandler
	public void handleException(PlanetNotFoundException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.NOT_FOUND.value(), e.getMessage());
	}

	@ExceptionHandler
	public void handleException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler
	public void handleException(ValidationException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.BAD_REQUEST.value(), e.getMessage());
	}

	@ExceptionHandler
	public void handleException(SystemException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.SERVICE_UNAVAILABLE.value(), e.getMessage());
	}

	@ExceptionHandler
	public void handleException(OptimisticLockingException e, HttpServletResponse response) throws IOException {
		response.sendError(HttpStatus.CONFLICT.value(), e.getMessage());
	}

}
