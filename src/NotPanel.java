import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextPane;


public class NotPanel extends JPanel{
	
	public static ArrayList<String> notFrom = new ArrayList<String>();
	
	public NotPanel(){
		
		
		
		this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
		
		
		
		notFrom.add("Little Johny");
		notFrom.add("Stacy");
		notFrom.add("Some other bitch");
		UpdateNotPanel();
	}
	
	void UpdateNotPanel(){
		
		this.removeAll();
		
		JTextPane a = new JTextPane();
		a.setText("Notification From:");
		a.setEditable(false);
		a.setBackground(new Color(40, 40, 40));
		a.setForeground(new Color(200, 200, 200));
		this.add(a);
		
		for(String x: notFrom){
		this.add(new JTextArea(x){{setEditable(false);setBackground(new Color(80, 80, 80));setForeground(new Color(200, 200, 200));setMaximumSize(new Dimension(120,25));}});
		}
	}
	void deNot(String name){
		notFrom.remove(name);
	}

}
