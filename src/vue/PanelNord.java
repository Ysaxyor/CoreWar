package	src.vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class PanelNord extends JPanel {

	private JButton solve;
	private JButton menu;
	private PanelWest pw;

	public PanelNord(PanelWest pw){

		this.pw=pw;

		this.setLayout(new FlowLayout(FlowLayout.CENTER,100,50));

		this.solve=new JButton("Solve Game");
		this.menu= new JButton("Menu");

		this.add(solve);
		this.add(menu);
		this.menu.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				PanelNord.this.pw.setMenu();
				PanelNord.this.pw.isMenu();
			}

		});

		this.setVisible(true);
	}


}
