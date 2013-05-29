package app.domain.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;

import app.domain.persistence.DefaultEntity;

@Entity
public final class Person extends DefaultEntity {

	private String givenName;

	@ElementCollection
	@CollectionTable(name = "PERSON_SURNAMES")
	@Column(name = "surname")
	private List<String> surnames = new ArrayList<String>();

	@ElementCollection
	@CollectionTable(name = "PERSON_MIDDLES")
	@Column(name = "middle")
	private List<String> middles = new ArrayList<String>();

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PERSON_ADDRESSES", joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(referencedColumnName = "id", name = "address_id"))
	@MapKeyColumn(name = "address_name")
	private Map<String, Address> addresses = new HashMap<String, Address>();

	private String primaryAddressName;

	public String getGivenName() {
		return givenName;
	}

	public void setGivenName(String givenName) {
		this.givenName = givenName;
	}

	public String getPrimarySurname() {
		return surnames.size() == 0 ? null : surnames.get(0);
	}

	public void setPrimarySurname(String name) {
		this.surnames.add(0, name);
	}

	public List<String> getSurnames() {
		return Collections.unmodifiableList(surnames);
	}

	public int addSurname(String surname) {
		testAddSurname(surname);
		return doAddSurname(surname);
	}

	protected void testAddSurname(String surname) {
	}

	protected int doAddSurname(String surname) {
		surnames.add(surname);
		return surnames.size() - 1;
	}

	public int addSurname(String surname, int index) {
		testAddSurname(surname, index);
		return doAddSurname(surname, index);
	}

	protected void testAddSurname(String surname, int index) {
	}

	protected int doAddSurname(String surname, int index) {
		if (index >= surnames.size()) {
			return doAddSurname(surname);
		}
		surnames.add(index, surname);
		return index;
	}

	public String getPrimaryMiddle() {
		return middles.size() == 0 ? null : middles.get(0);
	}

	public List<String> getMiddles() {
		return Collections.unmodifiableList(middles);
	}

	public void setPrimaryMiddle(String name) {
		this.middles.add(0, name);
	}

	public int addMiddle(String middle) {
		testAddMiddle(middle);
		return doAddMiddle(middle);
	}

	protected void testAddMiddle(String middle) {
	}

	protected int doAddMiddle(String middle) {
		middles.add(middle);
		return middles.size() - 1;
	}

	protected int addMiddle(String middle, int index) {
		testAddMiddle(middle, index);
		return doAddMiddle(middle, index);
	}

	protected void testAddMiddle(String middle, int index) {
	}

	protected int doAddMiddle(String middle, int index) {
		if (index >= middles.size()) {
			return doAddMiddle(middle);
		}
		middles.add(index, middle);
		return index;
	}

	public Address getAddress(String name) {
		return addresses.get(name);
	}

	public void putAddress(String name, Address address) {
		testPutAddress(name, address);
		doPutAddress(name, address);
	}

	protected void testPutAddress(String name, Address address) {
		if (addresses.containsKey(name)) {
			throw new IllegalArgumentException("addresses already contains key");
		}
	}

	protected void doPutAddress(String name, Address address) {
		addresses.put(name, address);

		if (addresses.size() == 1) {
			doSetPrimaryAddressName(name);
		}
	}

	public Address getPrimaryAddress() {
		return primaryAddressName == null ? null : addresses
				.get(primaryAddressName);
	}

	public void setPrimaryAddressName(String name) {
		testSetPrimaryAddressName(name);
		doSetPrimaryAddressName(name);
	}

	protected void testSetPrimaryAddressName(String name) {
		if (!addresses.containsKey(name)) {
			throw new IllegalArgumentException(
					"addresses does not contain given key");
		}
	}

	protected void doSetPrimaryAddressName(String name) {
		primaryAddressName = name;
	}

	public void setPrimaryAddress(String name, Address address,
			boolean leniently) {

	}

	public void removeAllSurnames() {
		testRemoveAllSurnames();
		doRemoveAllSurnames();
	}

	protected void testRemoveAllSurnames() {
	}

	protected void doRemoveAllSurnames() {
		surnames.clear();
	}

	protected void removeSurname(String surname) {
		testRemoveSurname(surname);
		doRemoveSurname(surname);
	}

	protected void testRemoveSurname(String surname) {
	}

	protected void doRemoveSurname(String surname) {
		surnames.remove(surname);
	}
}
