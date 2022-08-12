package org.helloworld.mymodule.serviceapi;

import org.helloworld.mymodule.domain.Planet;
import org.junit.Before;
import org.junit.Test;

import org.sculptor.framework.test.AbstractDbUnitJpaTests;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import java.util.List;

import javax.sql.DataSource;

/**
 * Spring based transactional test with DbUnit support.
 */
public class InternalPlanetServiceTest extends AbstractDbUnitJpaTests implements InternalPlanetServiceTestBase {

	@Autowired
	protected InternalPlanetService internalPlanetService;
	@Autowired
	DataSource source;

	@Before
    public void setDataSource() {
        super.setDataSource(source);
    }
	@Test
	public void testFindById() throws Exception {
		Planet planet = internalPlanetService.findById(getServiceContext(), 14L);
		assertNotNull(planet);
	}

	@Test
	public void testFindAll() throws Exception {
		List<Planet> planet = internalPlanetService.findAll(getServiceContext());
		assertNotNull(planet);
	}

	

	@Test
	public void testSave() throws Exception {
	Planet planet = internalPlanetService.findById(getServiceContext(), 14L);
	assertNotNull(planet);
	planet.setName("Zem");
	internalPlanetService.save(getServiceContext(), planet);
	Planet planet2 = internalPlanetService.findById(getServiceContext(), 14L);
	assertEquals("Zem", planet2.getName());
	
	}

	@Test
	public void testDelete() throws Exception {
		int before = countRowsInTable(Planet.class);
		Planet planet = internalPlanetService.findById(getServiceContext(), 14L);
		assertNotNull(planet);
		internalPlanetService.delete(getServiceContext(), planet);
		assertEquals(before - 1, countRowsInTable(Planet.class));
	}
}
