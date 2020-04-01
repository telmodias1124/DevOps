package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;
import gui.Knockout.KnockoutPanel;
public class PreviousAction implements ActionListener {
	private MainFrame mf;
	private KnockoutPanel kpp;
	
	public PreviousAction(MainFrame mf, KnockoutPanel kpp) {
		super();
		this.mf = mf;
		this.kpp=kpp;
	}
	public void actionPerformed(ActionEvent e) {
		mf.getContentPane().removeAll();
		mf.add(mf.getGpp().getSp());
		mf.add(mf.getGpp().getMp());
		mf.createGroupPhasePanel(mf.getGp(), mf.getKp());
		mf.revalidate();
		mf.repaint();
		mf.setVisible(true);
		
	}
}
