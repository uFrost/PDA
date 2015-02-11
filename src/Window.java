import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;


public class Window extends JFrame {

	static boolean focus = false;
	JTextArea chatInput = new JTextArea();
	JTextField chat = new JTextField();
	JPanel kiddieHolder = new JPanel(){{this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));}};
	JScrollPane scroll = new JScrollPane();
	
	public Window(){
		
		super("\"I'd date me\" - Jacob Freeland");
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(550,530));
		
		this.add(chat, BorderLayout.CENTER);
		this.add(chatInput, BorderLayout.SOUTH);
		
		UpdatePeople(new String[]{"Little Johny","Poor Susan","Michael Jackson's Kid"});
		this.add(kiddieHolder, BorderLayout.WEST);
		
		pack();
		setVisible(true);
		
		this.addWindowFocusListener(new WindowAdapter() {
			
			public void windowGainedFocus(WindowEvent e){
				focus = true;
			}
		
			public void windowLostFocus(WindowEvent e) {
	   		 	focus = false;
			}
	    });
		
	}
	
	
	void UpdateChat(String newChat){
		chat.setText(newChat);
	}
	
	void UpdatePeople(String[] newPeople){
		
		
		for(String x: newPeople){			
			kiddieHolder.add(new TAListener(x));
		}
		
		
	}
	
}
