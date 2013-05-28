package app.domain.persistence;

/**
 * An object that can be equal to another object by comparing a subset of its
 * state to that of another object, often excluding its persistent identity.
 */
public interface NaturallyEquatable {

	/**
	 * Returns whether this object is equal to the given object by comparing a
	 * subset of its state to that of the given object, often excluding its
	 * persistent identity (see {@link PersistentlyIdentifiable}). This is the
	 * concept of the conventional <code>equals</code> method, as described in
	 * {@link Object#equals(Object)}.
	 * 
	 * @see Object#equals(Object)
	 */
	boolean equalsNaturally(Object that);

	/**
	 * Returns a natural hash code for this instance, often excluding its
	 * persistent identity (see {@link PersistentlyIdentifiable}). This is the
	 * concept of the conventional <code>hashCode</code> method, as described in
	 * {@link Object#hashCode()}.
	 * 
	 * @see Object#hashCode()
	 */
	int naturalHashCode();
}
