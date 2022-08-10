package org.helloworld.mymodule.domain;

import javax.xml.bind.annotation.XmlElement;
import org.helloworld.mymodule.serviceapi.PlanetDTO;

/**
 * Builder for PlanetDTO class.
 */
public class PlanetDTOBuilder {

	private String name;
	private int diameter;

	/**
	 * Static factory method for PlanetDTOBuilder
	 */
	public static PlanetDTOBuilder planetDTO() {
		return new PlanetDTOBuilder();
	}

	public PlanetDTOBuilder() {
	}

	public PlanetDTOBuilder name(String val) {
		this.name = val;
		return this;
	}

	public PlanetDTOBuilder diameter(int val) {
		this.diameter = val;
		return this;
	}

	@XmlElement()
	public String getName() {
		return name;
	}

	@XmlElement()
	public int getDiameter() {
		return diameter;
	}

	/**
	 * @return new PlanetDTO instance constructed based on the values that have been set into this builder
	 */
	public PlanetDTO build() {
		PlanetDTO obj = new PlanetDTO();
		obj.setName(name);
		obj.setDiameter(diameter);

		return obj;
	}
}
