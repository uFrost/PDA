package login;

import java.util.ArrayList;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;


public class NewAccountCreation {
	
	private static ArrayList<String> accounts = new ArrayList<String>();
	private static Firebase fb = new Firebase("https://apcsdnd.firebaseio.com/"); 
	
	public static void createAccount(String userName, String password){
		
		fb.child("Login").child(userName).setValue(userName+","+password);
		getAccounts();
	}
	
	public static ArrayList<String> getAccounts(){
		
		accounts = new ArrayList<String>(0);
		
	fb.child("Login").addChildEventListener(new ChildEventListener(){

		@Override
		public void onCancelled(FirebaseError arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onChildAdded(DataSnapshot snapshot, String arg1) {
			String x = ((String)snapshot.getKey());
			accounts.add(x);
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
	try{
		Thread.sleep(1000);
	}
	catch(Exception e){
		
	}
	return accounts;
	}
}
