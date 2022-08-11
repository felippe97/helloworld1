package org.helloworld.mymodule.serviceapi;

import java.util.List;
import org.helloworld.mymodule.domain.Planet;
import org.helloworld.mymodule.exception.PlanetNotFoundException;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;

/**
 * Generated interface for the Service InternalPlanetService.
 */
public interface InternalPlanetService {

	public final static String BEAN_ID = "internalPlanetService";

	public Planet findById(ServiceContext ctx, Long id) throws PlanetNotFoundException;

	public List<Planet> findAll(ServiceContext ctx);


	public List<Planet> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition);

	public Planet save(ServiceContext ctx, Planet entity);

	public void delete(ServiceContext ctx, Planet entity);

}
