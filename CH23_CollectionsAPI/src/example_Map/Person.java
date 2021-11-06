package example_Map;

import java.util.Objects;

public class Person implements Comparable<Person> {
	private String name;
	
	public Person(String name) {
		this.name = name;
	}	
	
	public String toString() {
		return name;
	}

	@Override
	public int compareTo(Person other) {

		return name.compareTo(other.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name);
	}
	
}
