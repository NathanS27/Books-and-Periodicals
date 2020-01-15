package libraryv2;

public class Periodical extends Item {

	private int number;
	
	public Periodical(String nm, String num) throws FormatException {
		super(nm);
		if(num.isEmpty()) {
			throw new FormatException("Please input an Issue number");
		}
		try {
			int temp=Integer.parseInt(num);
			if(temp>0) {
				number=temp;
			}
		
		}
		catch(NumberFormatException e) {
			throw new FormatException("Issue number must be an Integer");
		}
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
		return "Title: "+getName()+"\nIssue: "+getNumber()+"\n\n";
	}
}
