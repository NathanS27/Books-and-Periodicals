package libraryv2;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
import BreezySwing.*;

public class libraryv2UI extends GBFrame {
	
	JMenuItem add = addMenuItem("Edit","add");
	JMenuItem populate = addMenuItem("Edit","Populate");
	
	JList bookList = addList(1,1,1,1);
	JTextArea bookInfo = addTextArea("",1,2,2,1);
	
	ArrayList<Item> library = new ArrayList<Item>();
	
	public libraryv2UI() {
		
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
			library.add(new Book("Cat In The Hat","Dr. Seuss"));
			library.add(new Book("Cat In The Hat","Dr. Seuss"));
			library.add(new Book("The Grapes Of Wrath","John Steinbeck"));
			library.add(new Book("To Kill A Mockingbird","Harper Lee"));
			library.add(new Book("Webster’s Dictionary","Webster"));
			library.add(new Periodical("Sport Illustrated",23));
			library.add(new Periodical("Sport Illustrated",123));
			library.add(new Periodical("Sport Illustrated",12));
			library.add(new Periodical("Sport Illustrated",4123));
			library.add(new Periodical("Sport Illustrated",11));
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
	//TODO change color based on sort
	}
	
	private void sortList(Object obj) {
		if(obj.getClass().equals(Book.class)) {
			for(Item i: library) {
				if((i instanceof Book)&&(((Book)i).compareTo(obj)==1)) {
					
				}
			}
		}
	}
	
	private void display(Item i) {
		bookInfo.setText(i.print());
	}
	
	private void addToList(ArrayList<Item> list) {
		DefaultListModel model = (DefaultListModel) bookList.getModel();
		model.clear();
		for(Item temp: list) {
			model.addElement(temp.getName());
		}
	}
}
