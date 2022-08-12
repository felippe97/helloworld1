package org.helloworld.mymodule.serviceapi;

import java.util.List;
import org.helloworld.mymodule.exception.PlanetNotFoundException;

import org.sculptor.framework.context.ServiceContext;

/**
 * Generated interface for the Service PlanetService.
 */
public interface PlanetService {

	public final static String BEAN_ID = "planetService";

	public PlanetDTO findById(ServiceContext ctx, Long id) throws PlanetNotFoundException;

	public List<PlanetDTO> findAll(ServiceContext ctx);

	public PlanetDTO save(ServiceContext ctx, PlanetDTO planet);

	public void delete(ServiceContext ctx, PlanetDTO planet);

}
