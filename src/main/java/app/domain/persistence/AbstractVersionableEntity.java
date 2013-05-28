package app.domain.persistence;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;
import javax.persistence.Version;

@MappedSuperclass
public abstract class AbstractVersionableEntity<ID extends Serializable>
		extends AbstractEntity<ID> implements PersistentlyVersionable<ID, Long> {

	@Version
	private Long version;

	public final Long getVersion() {
		return version;
	}
}
