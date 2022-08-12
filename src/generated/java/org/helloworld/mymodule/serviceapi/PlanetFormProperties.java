package org.helloworld.mymodule.serviceapi;


import org.sculptor.framework.domain.LeafProperty;
import org.sculptor.framework.domain.PropertiesCollection;
import org.sculptor.framework.domain.Property;

/**
 * This generated interface defines property names for all attributes and associatations in
 * {@link org.helloworld.mymodule.serviceapi.PlanetForm}.
 * <p>
 * These properties are useful when building criteria with {@link org.sculptor.framework.accessapi.ConditionalCriteriaBuilder},
 * which can be used with findByCondition Repository operation.
 */
public class PlanetFormProperties {

	private PlanetFormProperties() {
	}

	private static final PlanetFormPropertiesImpl<PlanetForm> sharedInstance = new PlanetFormPropertiesImpl<PlanetForm>(
			PlanetForm.class);

	public static Property<PlanetForm> name() {
		return sharedInstance.name();
	}

	public static Property<PlanetForm> diameter() {
		return sharedInstance.diameter();
	}

	public static Property<PlanetForm> id() {
		return sharedInstance.id();
	}

	public static Property<PlanetForm> version() {
		return sharedInstance.version();
	}

	/**
	 * This class is used for references to {@link org.helloworld.mymodule.serviceapi.PlanetForm}, i.e. nested property.
	 */
	public static class PlanetFormProperty<T> extends PlanetFormPropertiesImpl<T> implements Property<T> {
		private static final long serialVersionUID = 1L;

		public PlanetFormProperty(String parentPath, String additionalPath, Class<T> owningClass) {
			super(parentPath, additionalPath, owningClass);
		}
	}

	protected static class PlanetFormPropertiesImpl<T> extends PropertiesCollection {
		private static final long serialVersionUID = 1L;
		Class<T> owningClass;

		PlanetFormPropertiesImpl(Class<T> owningClass) {
			super(null);
			this.owningClass = owningClass;
		}

		PlanetFormPropertiesImpl(String parentPath, String additionalPath, Class<T> owningClass) {
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
