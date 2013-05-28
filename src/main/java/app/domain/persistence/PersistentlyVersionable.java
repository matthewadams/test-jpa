package app.domain.persistence;

import java.io.Serializable;

/**
 * An object that has a persistent version, often used for optimistic locking.
 * 
 * @param <ID>
 *            The type of the persistent identity of instances of this class.
 * @param <V>
 *            The type of the version of instances of this class, usually a
 *            {@link Long}, which captures both simple monotonically increasing
 *            versions, including time-based versions. Time-based versioning
 *            should be used with caution, however, since the resolution of JVM
 *            times is often no less than 10 ms. To a much lesser degree, other
 *            types, like {@link String}, could also be used.
 */
public interface PersistentlyVersionable<ID extends Serializable, V extends Comparable<V>>
		extends PersistentlyIdentifiable<ID> {

	/**
	 * Returns the persistent version of this instance, if it has one, or
	 * <code>null</code> otherwise.
	 */
	V getVersion();
}
