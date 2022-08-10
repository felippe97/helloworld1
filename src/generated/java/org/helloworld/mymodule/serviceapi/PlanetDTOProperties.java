package org.helloworld.mymodule.serviceapi;

import org.helloworld.mymodule.serviceapi.PlanetDTO;
import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link org.helloworld.mymodule.serviceapi.PlanetDTO}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class PlanetDTOProperties {

	private PlanetDTOProperties() {
	}

	private static final PlanetDTOPropertiesImpl<PlanetDTO> sharedInstance = new PlanetDTOPropertiesImpl<PlanetDTO>(PlanetDTO.class);

	public static Property<PlanetDTO> name() {
		return sharedInstance.name();
	}

	public static Property<PlanetDTO> diameter() {
		return sharedInstance.diameter();
	}

	public static Property<PlanetDTO> id() {
		return sharedInstance.id();
	}

	public static Property<PlanetDTO> version() {
		return sharedInstance.version();
	}

	/**
	 * This class is used for references to {@link org.helloworld.mymodule.serviceapi.PlanetDTO}, i.e. nested property.
	 */
	public static class PlanetDTOProperty<T> extends PlanetDTOPropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public PlanetDTOProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class PlanetDTOPropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		PlanetDTOPropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		PlanetDTOPropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath);
			this.owningClass = owningClass;
		}

		public Property<T> name() {
			return new LeafProperty<T>(getParentPath(), "name", false, owningClass);
		}

		public Property<T> diameter() {
			return new LeafProperty<T>(getParentPath(), "diameter", false, owningClass);
		}

		public Property<T> id() {
			return new LeafProperty<T>(getParentPath(), "id", false, owningClass);
		}

		public Property<T> version() {
			return new LeafProperty<T>(getParentPath(), "version", false, owningClass);
		}
	}
}
