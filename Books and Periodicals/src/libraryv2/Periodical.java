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
	@Override
	public int compareTo(Object obj) {
		if(number==((Periodical)obj).getNumber()) {
			return 0;
		}
		else if(number>((Periodical)obj).getNumber()) {
			return 1;
		}
		return -1;	}
	@Override
	public String print() {
		// TODO Auto-generated method stub
		return getName()+"; "+getNumber();
	}
}
