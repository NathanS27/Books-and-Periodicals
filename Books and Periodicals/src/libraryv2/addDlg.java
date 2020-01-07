package libraryv2;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import BreezySwing.*;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class addDlg extends GBDialog {
	
	ButtonGroup itemType = new ButtonGroup();
    JRadioButton book  = addRadioButton ("Book", 1,1,1,1);
    JRadioButton periodical  = addRadioButton ("Periodical", 1,2,1,1);
	
    JLabel nameLabel = addLabel("Name:",2,1,1,1);
    JTextField name = addTextField("",2,2,2,1);
    
    JLabel periodNumLbl = addLabel("Periodical Number:",3,1,1,1);
    JTextField periodNum = addTextField("",3,2,2,1);
    
    JLabel authorlbl = addLabel("Major:",4,1,1,1);
    JTextField author = addTextField("",4,2,2,1);
   
    JFrame parentClass;
    
    private ArrayList<Item> library;
    
    JButton add = addButton("Add",5,2,1,1);
    
    private ChangeListener cl = new ChangeListener() {
    	@Override
    	public void stateChanged(ChangeEvent e) {
    		JRadioButton source = (JRadioButton) e.getSource();
    		
    		if(source==book && book.isSelected()) {
    			periodNumLbl.setVisible(false);
				periodNum.setVisible(false);
				
				authorlbl.setVisible(true);
				author.setVisible(true);
			}
			if(source==periodical && periodical.isSelected()) {
				periodNumLbl.setVisible(true);
				periodNum.setVisible(true);
				
				authorlbl.setVisible(false);
				author.setVisible(false);
			}
			
    	}
    };
    
	
	public addDlg(JFrame parent, ArrayList<Item> p) {
		super(parent);
		library=p;
		setTitle("add");
		getContentPane().setBackground(new Color(84,134,249));
		itemType.add(book);
		itemType.add(periodical);
		book.addChangeListener(cl);
		periodical.addChangeListener(cl);
		book.setSelected(true);
		setDlgCloseIndicator("Cancel");
		setSize(400, 200);
		setLocationRelativeTo(null);
		parentClass=parent;
		
	}
	
	public void buttonClicked(JButton buttonObj) {
			library.add(new Book(name.getText(),author.getText()));
			dispose();	
	}
	
	private void errorMsg(String str) {
		ErrorDlg display = new ErrorDlg(parentClass,str);
		display.setVisible(true);
	}
}