package model;

public class Tag {
	public final TagType type;
	public final String value;
	
	public Tag(TagType type, String value) {
		assert type != null : "Expect type to be set";
		assert value != null && value.length() > 0 : "Expect value to be set";

		this.type = type;
		this.value = value;
	}
	
	@Override
	public int hashCode() {
		return this.type.hashCode() * this.value.hashCode();
	}
	
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		
		if (!(o instanceof Tag))
			return false;
		
		Tag other = (Tag) o;
		
		return this.type.equals(other.type)
				&& this.value.equals(other.value);
	}
	
	@Override
	public String toString() {
		return type.toString() + ": " + value;
	}
}
