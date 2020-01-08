package libraryv2;

public class Book extends Item {
	
	private String author;
	
	public Book(String nm, String ath) {
		super(nm);
		author=ath;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int compareTo(Object obj) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return getName()+" "+  getAuthor();
	}
}

