package app.domain.persistence;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DefaultEntity extends AbstractVersionableEntity<String> {

	@Id
	@Column(name = "id")
	private String id = uuid();

	public final String getId() {
		return id;
	}
}
