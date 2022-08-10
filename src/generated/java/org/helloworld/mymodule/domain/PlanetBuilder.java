package org.helloworld.mymodule.domain;

import java.util.Date;
import javax.xml.bind.annotation.XmlElement;
import org.helloworld.mymodule.domain.Planet;

/**
 * Builder for Planet class.
 */
public class PlanetBuilder {

	private String name;
	private int diameter;
	private Date createdDate;
	private String createdBy;
	private Date lastUpdated;
	private String lastUpdatedBy;

	/**
	 * Static factory method for PlanetBuilder
	 */
	public static PlanetBuilder planet() {
		return new PlanetBuilder();
	}

	public PlanetBuilder() {
	}

	public PlanetBuilder name(String val) {
		this.name = val;
		return this;
	}

	public PlanetBuilder diameter(int val) {
		this.diameter = val;
		return this;
	}

	public PlanetBuilder createdDate(Date val) {
		this.createdDate = val;
		return this;
	}

	public PlanetBuilder createdBy(String val) {
		this.createdBy = val;
		return this;
	}

	public PlanetBuilder lastUpdated(Date val) {
		this.lastUpdated = val;
		return this;
	}

	public PlanetBuilder lastUpdatedBy(String val) {
		this.lastUpdatedBy = val;
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

	@XmlElement(nillable = true)
	public Date getCreatedDate() {
		return createdDate;
	}

	@XmlElement(nillable = true)
	public String getCreatedBy() {
		return createdBy;
	}

	@XmlElement(nillable = true)
	public Date getLastUpdated() {
		return lastUpdated;
	}

	@XmlElement(nillable = true)
	public String getLastUpdatedBy() {
		return lastUpdatedBy;
	}

	/**
	 * @return new Planet instance constructed based on the values that have been set into this builder
	 */
	public Planet build() {
		Planet obj = new Planet();
		obj.setName(name);
		obj.setDiameter(diameter);
		obj.setCreatedDate(createdDate);
		obj.setCreatedBy(createdBy);
		obj.setLastUpdated(lastUpdated);
		obj.setLastUpdatedBy(lastUpdatedBy);

		return obj;
	}
}
