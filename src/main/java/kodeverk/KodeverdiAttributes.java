package kodeverk;

import java.util.HashMap;
import java.util.Map;

/**
 * Typesafe heterogeneous container pattern - Effective Java 2 - Item 29
 */
public class KodeverdiAttributes {
	private final Map<Class<?>, Object> attributes = new HashMap<Class<?>, Object>();

	public <T> void putAttribute(Class<T> type, T instance) {
		if (type == null)
			throw new NullPointerException("Type is null");
		attributes.put(type, instance);
	}

	public <T> T getAttribute(Class<T> type) {
		return type.cast(attributes.get(type));
	}

	public boolean isEmpty() {
		return attributes.isEmpty();
	}
}
