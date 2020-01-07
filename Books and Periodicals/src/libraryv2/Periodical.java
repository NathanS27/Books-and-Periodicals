package libraryv2;

public class Periodical extends Item {

	private int number;
	
	public Periodical(String nm, int num) {
		super(nm);
		number=num;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
}
