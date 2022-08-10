package org.helloworld.mymodule.serviceimpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.helloworld.mymodule.domain.Planet;
import org.helloworld.mymodule.domain.PlanetProperties;
import org.helloworld.mymodule.domain.PlanetRepository;
import org.helloworld.mymodule.exception.PlanetNotFoundException;
import org.helloworld.mymodule.serviceapi.PlanetDTO;
import org.helloworld.mymodule.serviceapi.PlanetDTOProperties;
import org.sculptor.framework.accessapi.ConditionalCriteria;
import org.sculptor.framework.accessapi.ConditionalCriteriaBuilder;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * Implementation of PlanetService.
 */
@Service("planetService")
public class PlanetServiceImpl extends PlanetServiceImplBase {

    
	 @Autowired
	    PlanetRepository planetRepository;
	public PlanetServiceImpl() {
	}

	public PlanetDTO findById(ServiceContext ctx, Long id) throws PlanetNotFoundException {
		
		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(PlanetDTO.class)
				.withProperty(PlanetDTOProperties.id()).eq(id)
				.build();

		return findByCondition(criteria);
	}

	public List<PlanetDTO> findAll(ServiceContext ctx) {
		List<PlanetDTO> planets = new ArrayList<PlanetDTO>();
		for (Iterator<Planet> iterator = planetRepository.findAll().iterator(); iterator.hasNext();) {
			iterator.next();
			planets.add(new PlanetDTO());
		}
		return planets;
	}

	public PlanetDTO save(ServiceContext ctx, PlanetDTO planet) {
		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(PlanetDTO.class)
				.withProperty(PlanetDTOProperties.name()).eq(planet)
				.build();

		return null;
	}

	public void delete(ServiceContext ctx, PlanetDTO planet) {
		
	}

	public List<PlanetDTO> findAllMatching(ServiceContext ctx, String value) {
		List<ConditionalCriteria> criteria = ConditionalCriteriaBuilder.criteriaFor(PlanetDTO.class)
				.withProperty(PlanetDTOProperties.version()).eq(value)
				.build();

		return findByCondition(criteria);
	}

}
