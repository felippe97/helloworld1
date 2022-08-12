package org.helloworld.mymodule.serviceimpl;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.helloworld.mymodule.domain.Planet;
import org.helloworld.mymodule.domain.PlanetRepository;
import org.helloworld.mymodule.exception.PlanetNotFoundException;
import org.helloworld.mymodule.serviceapi.PlanetDTO;
import org.sculptor.framework.context.ServiceContext;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.JdbcTemplate;

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
		
	

		Planet planet = getInternalPlanetService().findById(ctx, id);
		PlanetDTO planetDTO = new PlanetDTO();
		planetDTO.setId(planet.getId());
		return planetDTO;
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
		Planet p = new Planet();
		
		p.setName(planet.getName());
		p.setDiameter(planet.getDiameter());
		
			
			planetRepository.save(p);
		
		planet.setId(planet.getId());
		
		return planet;
	}
	
	public void delete(ServiceContext ctx, PlanetDTO planet) {
		Planet p = new Planet();
		p.setName(planet.getName());
		p.setDiameter(planet.getDiameter());
		planetRepository.delete(p);
		
	}

	

	

} 
