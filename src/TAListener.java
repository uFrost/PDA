import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextArea;


public class TAListener extends JTextArea {

	
	public TAListener(String name){
		
		this.setEditable(false);
		this.setBackground(new Color(80, 80, 80));
		this.setForeground(new Color(200, 200, 200));
		this.setMaximumSize(new Dimension(120,25));
		
		this.setText(name);
		
		this.addMouseListener(new MouseListener(){{
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			//PUT SOME SELECTION STUFF HERE, UPDATE TEXT WITH THE TEXT FROM THAT PERSON, CHANGE COLOR
			
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
		m.setBackground(new Color(100, 80, 80));
		m.setForeground(new Color(200, 200, 200));
	}
	
}
