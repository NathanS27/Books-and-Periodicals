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
		int index = bookList.getSelectedIndex(); 
		// if something is actually selected
		if (index >= 0){
			sortList(library.get(index));
		}
	}
	
	private void sortList(Object obj) {
		int[] code= new int[library.size()];
		int index=0;
		if(obj.getClass().equals(Book.class)) {
			System.out.println("issa book");
			for(Item i:library) {
				try {
					code[index]=i.compareTo(obj);
					index++;
				}
				catch(ClassCastException e) {
					code[index]=-2;
					index++;
				}
			}
		}
		else if(obj.getClass().equals(Periodical.class)) {
			System.out.println("issa magazine");
			for(Item i:library) {
				try {
					code[index]=i.compareTo(obj);
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
	
	private void addToList(ArrayList<Item> list) {
		DefaultListModel model = (DefaultListModel) bookList.getModel();
		model.clear();
		for(Item temp: list) {
			model.addElement(temp.getName());
		}
	}
	private void addToListColor(ArrayList<Item> list,int[] code) {
		DefaultListModel model = (DefaultListModel) bookList.getModel();
		for(int i:code) {
			System.out.println(i);
		}
		model.clear();
		int index=0;
		for(Item temp: list) {
			String str="ERROR";
			if(code[index]==0) {
				str=String.format("<html><font color='blue'>%s</font></html>", temp.getName());
				System.out.println("Match");
			}
			else if(code[index]==-1) {
				str=String.format("<html><font color='red'>%s</font></html>", temp.getName());
				System.out.println("after");
			}
			else if(code[index]==-2) {
				str=String.format("<html><font color='black'>%s</font></html>", temp.getName());
				System.out.println("Nope");
			}
			else if(code[index]==1) {
				str=String.format("<html><font color='green'>%s</font></html>", temp.getName());
				System.out.println("before");
			}
			model.addElement(str);
			index++;
		}
	}
}
