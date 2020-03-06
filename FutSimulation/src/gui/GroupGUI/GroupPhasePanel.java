package gui.GroupGUI;

import java.awt.GridLayout;

import javax.swing.JPanel;

import data.GroupPhase;
import gui.MainFrame;

public class GroupPhasePanel extends JPanel{
	private StandingPanel sp;
	private GamePanel mp;
	
	public GroupPhasePanel() {
		super();
		this.setLayout(new GridLayout(2,1));
		this.setOpaque(false);
	}
	
	public void fillGroupPhasePanel(GroupPhase gp, MainFrame mf) {
		sp = new StandingPanel();
		mp = new GamePanel(gp, sp, mf);
		
		sp.fillStandingPanel("Group A", gp.getStandingGroupA(), false);
		sp.fillStandingPanel("Group B", gp.getStandingGroupB(), false);
		sp.fillStandingPanel("Group C", gp.getStandingGroupC(), false);
		sp.fillStandingPanel("Group D", gp.getStandingGroupD(), false);
		sp.setOpaque(false);
		/*mp.createGamePanel("Group A", gp.getListMatchGroupA());
		mp.createGamePanel("Group B", gp.getListMatchGroupB());
		mp.createGamePanel("Group C", gp.getListMatchGroupC());
		mp.createGamePanel("Group D", gp.getListMatchGroupD());*/
		mp.createStartPanel();
		mp.setOpaque(false);

		this.add(sp);
		this.add(mp);
		
	}
}
