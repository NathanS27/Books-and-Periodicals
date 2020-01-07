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
}
