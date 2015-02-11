package chat;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import base.Main;
import login.LoginConfirmation;


public class chatWindow extends PixDumpWindow {

	private static final long serialVersionUID = 1L;
	JTextArea messageDisplay = new JTextArea();
	public static JTextField chatBox = new JTextField();
	JTextField name = new JTextField();
	JScrollPane scrollPane;
	MessageHandler messageHandler;
	JPanel panel = new JPanel();
	JTabbedPane tabs = new JTabbedPane();
	static boolean focus = false;
	
	TabHandler tabHandler= new TabHandler();
	
	public MessageSpaceDialog messageSpaceDialog = new MessageSpaceDialog();
	
	List<ChatPane> chats = new ArrayList<ChatPane>();
	
	
	
	
	
	public chatWindow(){
		
		this.setTitle("\"It's that damn Hansel! He's so hot right now!\"");
		
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(550,300));
	

		add(tabs);
		//add(name, BorderLayout.NORTH);
		add(chatBox, BorderLayout.SOUTH);
		add(tabHandler,BorderLayout.WEST);
		chatBox.addActionListener(new ActionListener(){

        public void actionPerformed(ActionEvent e){
        		chats.get(tabs.getSelectedIndex()).messageHandler.SendMessage(chatBox.getText());
        		chatBox.setText("");
        			
        }});
		pack();
		setVisible(false);
	
	
		this.addWindowFocusListener(new WindowAdapter() {
		
			public void windowGainedFocus(WindowEvent e){
				focus = true;
			}
		
			public void windowLostFocus(WindowEvent e) {
	   		 	focus = false;
			}
	    });
	}
	
	public void scrollDown(){
		Runnable doScroll = new Runnable() {
	        public void run() {
	        	scrollPane.getVerticalScrollBar().setValue(scrollPane.getVerticalScrollBar().getMaximum()+1);
	        }
	    };
	    SwingUtilities.invokeLater(doScroll);
		
	}
	
	public void setMessageHandler( MessageHandler mh){
		this.messageHandler=mh;
	}

	public void addConvo(String name){
		ChatPane p =new ChatPane(new MessageHandler(name)) ;
		scrollPane = new JScrollPane(p);
		tabs.addTab(name,scrollPane);
		chats.add(p);
	}

	public void closeCurrentTab(){
		chats.remove(tabs.getSelectedIndex());
		tabs.remove(tabs.getComponent(tabs.getSelectedIndex()));
	}
	
	
	
	
	
}
