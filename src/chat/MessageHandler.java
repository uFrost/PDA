package chat;


import javax.swing.SwingUtilities;

import base.Main;

import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MessageHandler {

	public static boolean correct = true;
	ChatPane cp;
	Firebase fb = new Firebase("https://apcsmessenger.firebaseio.com/"); 
	long count =0;
	String ms;
	ChildEventListener listener;
	
	public MessageHandler(String ms){
		this.ms= ms;
	}

	public  void init(){
		getChildCount();    
		listener = fb.child(ms).addChildEventListener(new ChildEventListener(){

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void onChildAdded(DataSnapshot snapshot, String message) {

				cp.updateChat((String)snapshot.getValue());
				Main.window.scrollDown();
				
				if(chatWindow.focus==false){
					Main.window.toFront();
			        Main.window.repaint();
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
	}
	
	public void SendMessage(String message){
		
		
		getChildCount();
	
		if(correct){
		fb.child(ms).child(count+"").setValue(message);
		
		}
		else{
			correct=true;
		}
	}
	
	public void setChatPane(ChatPane cp){
	this.cp=cp;	
	}
	
	public  long getChildCount(){
		
		fb.child(ms).addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {
			count= snapshot.getChildrenCount();
			}

			@Override
			public void onCancelled(FirebaseError arg0) {
				// TODO Auto-generated method stub
				
			}
		});
		return count;
	}

	


}
