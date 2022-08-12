package org.helloworld.mymodule.serviceapi;



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
public class PlanetServiceTest extends AbstractDbUnitJpaTests implements PlanetServiceTestBase {

	@Autowired
	protected PlanetService planetService;
	@Autowired
	DataSource source;

	@Before
    public void setDataSource() {
        super.setDataSource(source);
    }
	@Test
	public void testFindById() throws Exception {
		PlanetDTO planet = planetService.findById(getServiceContext(), 14L);
		assertNotNull(planet);
	}

	@Test
	public void testFindAll() throws Exception {
	List<PlanetDTO> planet = planetService.findAll(getServiceContext());
	assertNotNull(planet);
	}

	@Test
	public void testSave() throws Exception {
		PlanetDTO planetDTO = planetService.findById(getServiceContext(), 14L);
		assertNotNull(planetDTO);
	planetDTO.setName("Zem");
	planetService.save(getServiceContext(), planetDTO);
	PlanetDTO planetDTO2 = planetService.findById(getServiceContext(), 14L);
	assertEquals("Zem", planetDTO2.getName());
		
	}

	@Test
	public void testDelete() throws Exception {
		int before = countRowsInTable(PlanetDTO.class);
		PlanetDTO planet = planetService.findById(getServiceContext(), 14L);
		assertNotNull(planet);
		planetService.delete(getServiceContext(), planet);
		assertEquals(before - 1, countRowsInTable(PlanetDTO.class));
	}

	
}
