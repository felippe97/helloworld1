package org.helloworld.mymodule.domain;

import javax.xml.bind.annotation.XmlElement;
import org.helloworld.mymodule.serviceapi.PlanetForm;

/**
 * Builder for PlanetForm class.
 */
public class PlanetFormBuilder {

	private String name;
	private int diameter;

	/**
	 * Static factory method for PlanetFormBuilder
	 */
	public static PlanetFormBuilder planetForm() {
		return new PlanetFormBuilder();
	}

	public PlanetFormBuilder() {
	}

	public PlanetFormBuilder name(String val) {
		this.name = val;
		return this;
	}

	public PlanetFormBuilder diameter(int val) {
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
	 * @return new PlanetForm instance constructed based on the values that have been set into this builder
	 */
	public PlanetForm build() {
		PlanetForm obj = new PlanetForm();
		obj.setName(name);
		obj.setDiameter(diameter);

		return obj;
	}
}
