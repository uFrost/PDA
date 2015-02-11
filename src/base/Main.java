package base;

import login.LoginForm;
import login.NewAccountForm;
import chat.PixDumpWindow;
import chat.chatWindow;

public class Main {
	
	public static chatWindow window ;
	public static LoginForm login;
	public static NewAccountForm newAccountForm= new NewAccountForm();
	public static PixDumpWindow pwin;
	
	public static void main(String[] args) {
		pwin = new PixDumpWindow();
		login = new LoginForm();
		window = new chatWindow();
		
	
	}
}
