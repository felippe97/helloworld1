package org.helloworld.mymodule.serviceimpl;

import java.util.List;
import org.helloworld.mymodule.domain.Planet;
import org.helloworld.mymodule.domain.PlanetRepository;
import org.helloworld.mymodule.exception.PlanetNotFoundException;
import org.helloworld.mymodule.serviceapi.InternalPlanetService;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation of InternalPlanetService.
 */
@Service("internalPlanetService")
public class InternalPlanetServiceImpl implements InternalPlanetService {

	public InternalPlanetServiceImpl() {
	}

	@Autowired
	private PlanetRepository planetRepository;

	protected PlanetRepository getPlanetRepository() {
		return planetRepository;
	}

	/**
	 * Delegates to {@link org.helloworld.mymodule.domain.PlanetRepository#findById}
	 */
	public Planet findById(ServiceContext ctx, Long id) throws PlanetNotFoundException {
		return planetRepository.findById(id);
	}

	/**
	 * Delegates to {@link org.helloworld.mymodule.domain.PlanetRepository#findAll}
	 */
	public List<Planet> findAll(ServiceContext ctx) {
		return planetRepository.findAll();
	}

	/**
	 * Delegates to {@link org.helloworld.mymodule.domain.PlanetRepository#findByCondition}
	 */
	public List<Planet> findByCondition(ServiceContext ctx, List<ConditionalCriteria> condition) {
		return planetRepository.findByCondition(condition);
	}

	/**
	 * Delegates to {@link org.helloworld.mymodule.domain.PlanetRepository#save}
	 */
	public Planet save(ServiceContext ctx, Planet entity) {
		return planetRepository.save(entity);
	}

	/**
	 * Delegates to {@link org.helloworld.mymodule.domain.PlanetRepository#delete}
	 */
	public void delete(ServiceContext ctx, Planet entity) {
		planetRepository.delete(entity);
	}

}
