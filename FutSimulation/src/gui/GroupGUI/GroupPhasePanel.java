package gui.GroupGUI;

import java.awt.GridLayout;

import javax.swing.JPanel;

import data.GroupPhase;

public class GroupPhasePanel extends JPanel{
	private StandingPanel sp;
	
	public GroupPhasePanel() {
		super();
		this.setLayout(new GridLayout(2,1));
	}
	
	public void createStandingPanel(GroupPhase gp) {
		sp = new StandingPanel();
		
		sp.createGroupPanel("Group A", gp.getGroupA());
		sp.createGroupPanel("Group B", gp.getGroupB());
		sp.createGroupPanel("Group C", gp.getGroupC());
		sp.createGroupPanel("Group D", gp.getGroupD());
		
		this.add(sp);
	}
}
