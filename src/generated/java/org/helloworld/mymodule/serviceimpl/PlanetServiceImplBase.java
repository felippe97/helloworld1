package org.helloworld.mymodule.serviceimpl;

import org.helloworld.mymodule.serviceapi.InternalPlanetService;
import org.helloworld.mymodule.serviceapi.PlanetService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Generated base class for implementation of PlanetService.
 * <p>
 * Make sure that subclass defines the following annotations:
 * 
 * <pre>
 * @org.springframework.stereotype.Service("planetService")
 * </pre>
 *
 */
public abstract class PlanetServiceImplBase implements PlanetService {

	public PlanetServiceImplBase() {
	}

	@Autowired
	private InternalPlanetService internalPlanetService;

	protected InternalPlanetService getInternalPlanetService() {
		return internalPlanetService;
	}

}
