package libraryv2;

public class Book extends Item{
	
	private String author;
	
	public Book(String nm, String ath) throws FormatException {
		super(nm);
		if(ath.isEmpty()) {
			throw new FormatException("Please Enter an Author");
		}
		setAuthor(ath);
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public int compareTo(Object obj) {
		return getAuthor().compareTo(((Book)obj).getAuthor());
	}

	@Override
	public String print() {
		// TODO Auto-generated method stub
		return "Title: "+getName()+"\nAuthor: "+  getAuthor()+"\n\n";
	}
}

