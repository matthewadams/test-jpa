package app.domain.persistence;

import java.io.Serializable;

/**
 * An object that implements this interface has a persistent identity that can
 * be compared to another {@link PersistentlyIdentifiable}'s persistent identity
 * for equality, which implies identity. The intent is to codify the concept of
 * persistent uniqueness, regardless of the instances' non-identity values.
 * <p/>
 * A persistent entity class should override its {@link Object#equals(Object)}
 * with a call to {@link #identifies(Object)} and its {@link Object#hashCode()}
 * with a call to {@link #identityHashCode()}. Note that a call to
 * {@link Object#hashCode()} when this object has no identity will return zero.
 */
public interface PersistentlyIdentifiable<ID extends Serializable> {

	/**
	 * Returns this object's persistent identity, or <code>null</code> if it
	 * does not yet have one.
	 */
	ID getId();

	/**
	 * Returns whether or not this {@link PersistentlyIdentifiable} has an
	 * identity that is equal to the identity of the given object. If the given
	 * object is not an <code>instanceof</code><br/>
	 * {@link PersistentlyIdentifiable}, then this object returns
	 * <code>false</code>. If this or the given {@link PersistentlyIdentifiable}
	 * does not yet have a persistent identity, then this object returns
	 * <code>false</code>.
	 */
	boolean identifies(Object that);

	/**
	 * Returns the hash code of this instance based on its persistent identity,
	 * or zero if it has no identity yet.
	 */
	int identityHashCode();

	/**
	 * Although this is defined on {@link Object}, this method is included here
	 * primarily to emphasize the point that it should be overridden and
	 * implemented by delegation to {@link #identifies(Object)}.
	 * <p/>
	 * The semantics of this method are as described in
	 * {@link #identifies(Object)}.
	 * 
	 * @see #identifies(Object)
	 */
	@Override
	boolean equals(Object that);

	/**
	 * Although this is defined on {@link Object}, this method is included here
	 * primarily to emphasize the point that it should be overridden and
	 * implemented by delegation to {@link #identityHashCode()}.
	 * <p/>
	 * The semantics of this method are as described in
	 * {@link #identityHashCode()}.
	 * 
	 * @see #identityHashCode()
	 */
	@Override
	int hashCode();

	/**
	 * Return this object's untyped identity object.
	 */
	Object getOid();

	/**
	 * Return this object's identity as a {@link String}. Returns the empty
	 * string if the id is null.
	 */
	String getIdString();
}
