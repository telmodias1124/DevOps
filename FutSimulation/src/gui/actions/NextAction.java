package gui.actions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import gui.MainFrame;
import gui.Knockout.KnockoutPanel;
public class NextAction implements ActionListener {
	private KnockoutPanel kp;
	
	public NextAction(KnockoutPanel kp) {
		super();
		this.kp = kp;
	}
	public void actionPerformed(ActionEvent e) {
		kp.changeStage();
		this.kp.removeAll();
		kp.drawQuarters();
		this.kp.revalidate();
		this.kp.repaint();
		this.kp.setVisible(true);
	}
}
