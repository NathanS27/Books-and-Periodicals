package libraryv2;

import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.*;
import BreezySwing.*;

public class libraryv2UI extends GBFrame {
	
	JMenuItem add = addMenuItem("Edit","Add");
	JMenuItem populate = addMenuItem("Edit","Populate");
	JMenuItem reset = addMenuItem("Edit","Reset");
	JMenuItem clear = addMenuItem("Edit","Clear");
	
	JList bookList = addList(1,1,1,1);
	JTextArea bookInfo = addTextArea("",1,2,1,1);
	
	ArrayList<Item> library = new ArrayList<Item>();
	ArrayList<Item> toDisplay = new ArrayList<Item>();
	
	public libraryv2UI() {
		bookInfo.setFont(new Font("Times", Font.ROMAN_BASELINE, 20));
		bookList.setFont(new Font("Times", Font.PLAIN, 15));
	}	
	
	public static void main(String[] args) {
		JFrame frm = new libraryv2UI();
		frm.setSize(800,500);
		frm.setTitle("Nathans NEW AND IMPROVED Library");
		frm.getContentPane().setBackground(new Color(54,134,249));
		frm.setResizable(true);
		frm.setVisible(true);
		frm.setLocationRelativeTo(null);
	}
	
	public void menuItemSelected(JMenuItem menuItem) {
		if(menuItem==add) {
			addDlg dlg = new addDlg(this,library);
			dlg.setVisible(true);
			addToList(library);
			revalidate();
		}
		if(menuItem==populate) {
			try {
				library.add(new Book("Horton Hears a Who","Dr. Seuss"));
				library.add(new Book("Cat In The Hat","Dr. Seuss"));
				library.add(new Book("The Grapes Of Wrath","john steinbeck"));
				library.add(new Book("To Kill A Mockingbird","Harper Lee"));
				library.add(new Book("Of Mice and Men","John Steinbeck"));
				library.add(new Periodical("Sport Illustrated","23"));
				library.add(new Periodical("Sport Illustrated","1"));
				library.add(new Periodical("Sport Illustrated","123"));
				library.add(new Periodical("Sport Illustrated","12"));
				library.add(new Periodical("Sport Illustrated","4123"));
				library.add(new Periodical("Sport Illustrated","4123"));
				library.add(new Periodical("Flying","1"));
				library.add(new Periodical("Flying","2"));
				library.add(new Periodical("Flying","2"));
				library.add(new Periodical("Flying","2"));
				library.add(new Periodical("Flying","4"));
				library.add(new Periodical("Flying","6"));
				addToList(library);
				revalidate();
			}
			catch(FormatException e) {
				
			}
		}
		if(menuItem==clear) {
			library.clear();
			bookInfo.setText("");
			addToList(library);
			revalidate();
		}
		if(menuItem==reset) {
			bookInfo.setText("");
			addToList(library);
			revalidate();
		}
	}
	
	public void listItemSelected (JList listObj){
		int index = bookList.getSelectedIndex();
		// if something is actually selected
		if (index >= 0){
			display(library.get(index));
		}
	}
	
	public void listDoubleClicked(JList listObj,String itemClicked) {
		int index = bookList.getSelectedIndex(); 
		// if something is actually selected
		if (index >= 0){
			sortList(library.get(index));
			displayMultiple(toDisplay);
		}
	}
	
	private void sortList(Object obj) {
		toDisplay.clear();
		int[] code= new int[library.size()];
		int index=0;
		if(obj.getClass().equals(Book.class)) {
			for(Item i:library) {
				try {
					code[index]=i.compareTo(obj);
					if(code[index]==0) {
						toDisplay.add(i);
					}
					else if(code[index]>0) {
						code[index]=1;
					}
					else if(code[index]<0) {
						code[index]=-1;
					}
					index++;
				}
				catch(ClassCastException e) {
					code[index]=-2;
					index++;
				}
			}
		}
		else if(obj.getClass().equals(Periodical.class)) {
			for(Item i:library) {
				try {
					code[index]=i.compareTo(obj);
					if(code[index]==0) {
						toDisplay.add(i);
					}
					index++;
				}
				catch(ClassCastException e) {
					code[index]=-2;
					index++;
				}
			}
		}
		addToListColor(library,code);
	}
	
	private void display(Item i) {
		bookInfo.setText(i.print());
	}
	
	private void displayMultiple(ArrayList<Item> list) {
		String str="";
		int items=0;
		for(Item i: list) {
			if(items==1) {
				str+="\n----Matches----\n";
			}
			str+=i.print()+"\n";
			items++;
		}
		bookInfo.setText(str);
	}
	
	private void addToList(ArrayList<Item> list) {
		DefaultListModel model = (DefaultListModel) bookList.getModel();
		model.clear();
		for(Item temp: list) {
			model.addElement(temp.getName());
		}
	}
	private void addToListColor(ArrayList<Item> list,int[] code) {
		DefaultListModel model = (DefaultListModel) bookList.getModel();
		model.clear();
		int index=0;
		for(Item temp: list) {
			String str=String.format("<html><font color='black'>%s </font></html>", temp.getName());;
			if(code[index]==0) {
				str=String.format("<html><font color='blue'>%s: </font>Match</html>", temp.getName());
			}
			else if(code[index]==-1) {
				str=String.format("<html><font color='green'>%s: </font>Before</html>", temp.getName());
			}
			else if(code[index]==1) {
				str=String.format("<html><font color='red'>%s: </font>After</html>", temp.getName());
			}
			model.addElement(str);
			index++;
		}
	}
}
