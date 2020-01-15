package libraryv2;

public abstract class Item implements Comparable{
	
	private String name;
	
	public Item(String nm) throws FormatException {
		if(nm.trim().isEmpty()) {
			throw new FormatException("Please enter a Title");
		}
		setName(nm);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return name;
	}
	
	public abstract int compareTo(Object obj);
	
	public abstract String print();
}
