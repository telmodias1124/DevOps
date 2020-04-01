package gui.MatchView;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JTextArea;

public class JPanelProgress extends JPanel {
	
	private ArrayList<String> allrecap;
	
	public JPanelProgress(ArrayList<String> allrecap) {
		super();
		this.allrecap=allrecap;
		String infos = new String();
		
		for(int i=0; i<allrecap.size(); i++) {
	    	infos+=allrecap.get(i)+"\n";
	    }
		
		JTextArea jTextArea =new JTextArea(infos);
		jTextArea.setName("Journal de la Bete");
		jTextArea.setSize(600, 2000);
		
		this.add(jTextArea);
	}

}
