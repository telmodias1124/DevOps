package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import data.GroupPhase;
import gui.MainFrame;
import gui.GroupGUI.GamePanel;
import gui.GroupGUI.StandingPanel;

public class NextAction implements ActionListener {
	private MainFrame mf;
	
	public NextAction(MainFrame mf) {
		super();
		this.mf = mf;
	}
	public void actionPerformed(ActionEvent e) {
		this.mf.getContentPane().removeAll();
		mf.createKnockout();
		this.mf.revalidate();
		this.mf.repaint();
		this.mf.setVisible(true);
	}
}
