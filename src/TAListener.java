
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JTextArea;


public class TAListener extends JTextArea {

	static ArrayList<JTextArea> list = new ArrayList<JTextArea>(); 
	
	public TAListener(String name){
		
		this.setEditable(false);
		this.setBackground(new Color(80, 80, 80));
		this.setForeground(new Color(200, 200, 200));
		this.setMaximumSize(new Dimension(120,25));
		
		this.setText(name);
		
		list.add(this);
		
		
		this.addMouseListener(new MouseListener(){

		@Override
		public void mouseClicked(MouseEvent e) {
		
			//UpdateChat
			selectThis((JTextArea)e.getComponent());
			for(String x: Main.window.n.notFrom){
				System.out.println(x == ((JTextArea)e.getComponent()).getText());
				
				if(((JTextArea)e.getComponent()).getText()==x){
					Main.window.n.notFrom.remove(x);
				}
			}
			Main.window.n.UpdateNotPanel();
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}});
		
		
		
	}
	
	public void selectThis(JTextArea m){
		
		m.setBackground(new Color(200, 40, 40));
		m.setForeground(new Color(200, 200, 200));
		
		for(JTextArea x: list){
			if(!(x.getText().equals(m.getText()))){
				
				x.setBackground(new Color(80, 80, 80));
				x.setForeground(new Color(200, 200, 200));
			}
		}
		
	}
	
}
