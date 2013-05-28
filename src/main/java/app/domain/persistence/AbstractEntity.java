package app.domain.persistence;

import java.io.Serializable;
import java.util.UUID;

public abstract class AbstractEntity<ID extends Serializable> implements
		PersistentlyIdentifiable<ID> {

	public final static String uuid() {
		return UUID.randomUUID().toString();
	}

	public final Object getOid() {
		return getId();
	}

	public final String getIdString() {
		return getId() == null ? "" : getId().toString();
	}

	@Override
	public final boolean equals(Object that) {
		return this.identifies(that);
	}

	public final boolean identifies(Object that) {
		if (that == null) {
			return false;
		}
		if (this == that) {
			return true;
		}
		if (!(that instanceof PersistentlyIdentifiable)) {
			return false;
		}
		PersistentlyIdentifiable<?> other = (PersistentlyIdentifiable<?>) that;

		return this.getId().equals(other.getId());
	}

	@Override
	public final int hashCode() {
		return identityHashCode();
	}

	public final int identityHashCode() {
		return getId() == null ? 0 : getId().hashCode();
	}
}
