package org.helloworld.mymodule.serviceapi;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;
import java.lang.Cloneable;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Data transfer object for PlanetDTO.
 */

@XmlRootElement(name = "Planet")
@XStreamAlias("Planet")
public class PlanetDTO implements Serializable, Cloneable {
	private static final long serialVersionUID = 1L;

	private String name;
	private int diameter;
	private Long id;
	private Long version;

	public PlanetDTO() {
	}

	@XmlElement()
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;

	}

	@XmlElement()
	public int getDiameter() {
		return diameter;
	}

	public void setDiameter(int diameter) {
		this.diameter = diameter;

	}

	@XmlElement()
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;

	}

	@XmlElement()
	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;

	}

	@Override
	public Object clone() {
		try {
			return super.clone();
		} catch (CloneNotSupportedException e) {
			// this shouldn't happen, since we are Cloneable
			throw new InternalError();
		}
	}

}
