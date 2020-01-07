package libraryv2;

import java.awt.Color;
import java.util.ArrayList;

import javax.swing.*;
import BreezySwing.*;

public class libraryv2UI extends GBFrame {
	
	JMenuItem add = addMenuItem("Edit","add");
	
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
	}
	
	public void listItemSelected (JList listObj){
		int index = bookList.getSelectedIndex(); 
		// if something is actually selected
		if (index >= 0){
			
		}
	}
	
	public void listDoubleClicked(JList listObj,String itemClicked) {
	}
	
	private void display() {
		
	}
	
	private void addToList(ArrayList<Item> list) {
		DefaultListModel model = (DefaultListModel) bookList.getModel();
		model.clear();
		for(Item temp: list) {
			model.addElement(temp.getName());
		}
	}
}
