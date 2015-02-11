package login;

import base.Main;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;


public class LoginConfirmation {
	public static boolean Admin = true;
	private static String UserName;
	private static Firebase fb = new Firebase("https://apcsdnd.firebaseio.com/"); 
	private static boolean valid;
	
	static boolean checkLogin(final String userName, final String passWord ){
		
		fb.child("Login").addChildEventListener(new ChildEventListener(){

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildAdded(DataSnapshot snapshot, String message) {
					//System.out.println(userName+","+passWord);
					//System.out.println(snapshot.getValue());
				if((userName+","+passWord).equals((String)snapshot.getValue() )){
					valid=true;
					UserName = userName;
					
				}
			}

			@Override
			public void onChildChanged(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildMoved(DataSnapshot arg0, String arg1) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildRemoved(DataSnapshot arg0) {
				// TODO Auto-generated method stub
				
			}
			
		
		});
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return valid;
	}
	
	public static String getUserName(){
		 return UserName;
	 }

}
