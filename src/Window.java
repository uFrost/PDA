
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Random;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;


public class Window extends JFrame {

	JTextField chat = new JTextField();
	JScrollPane scroll = new JScrollPane();
	
	ChatInput CI = new ChatInput();
	PeoplePanel p = new PeoplePanel();
	JPanel newMessagePage = new JPanel(){{this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));}};
	
		
	public Window(){
	
		super(StartupMessages.StartupMessages[new Random().nextInt(StartupMessages.StartupMessages.length)]);
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(550,530));
		
		this.add(chat, BorderLayout.CENTER);
		this.add(CI, BorderLayout.SOUTH);
		
		scroll = new JScrollPane(p,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scroll, BorderLayout.WEST);
		
		scroll = new JScrollPane(newMessagePage,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		this.add(scroll, BorderLayout.EAST);
		
		pack();
		setVisible(true);
		
	}
	
	
}
