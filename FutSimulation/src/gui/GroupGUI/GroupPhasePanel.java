package gui.GroupGUI;

import java.awt.GridLayout;

import javax.swing.JPanel;

import data.GroupPhase;

public class GroupPhasePanel extends JPanel{
	private StandingPanel sp;
	private GamePanel mp;
	
	public GroupPhasePanel() {
		super();
		this.setLayout(new GridLayout(2,1));
	}
	
	public void createStandingPanel(GroupPhase gp) {
		sp = new StandingPanel();
		mp = new GamePanel();
		
		sp.createGroupPanel("Group A", gp.getGroupA());
		sp.createGroupPanel("Group B", gp.getGroupB());
		sp.createGroupPanel("Group C", gp.getGroupC());
		sp.createGroupPanel("Group D", gp.getGroupD());
		
		/*mp.createGamePanel("Group A", gp.getListMatchGroupA());
		mp.createGamePanel("Group B", gp.getListMatchGroupB());
		mp.createGamePanel("Group C", gp.getListMatchGroupC());
		mp.createGamePanel("Group D", gp.getListMatchGroupD());*/
		mp.createStartPanel();
		
		this.add(sp);
		this.add(mp);
		
	}
}
