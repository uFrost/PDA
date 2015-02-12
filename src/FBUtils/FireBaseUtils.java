package FBUtils;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class FireBaseUtils {

	static Firebase firebase;

	public static String chatName;

	public static long count;

	public static String myName = "test";

	public static void init() {
		firebase = new Firebase("https://pda.firebaseio.com/");
		
	}

	public static void setChat(String name2) {

		// Main.window.c.removeAll();
		chatName = (myName.compareTo(name2) == 1) ? (myName + name2)
				: (name2 + myName);
		
		
	

	}

	public static void SendMessage(String data) {
		getChildCount();
		firebase.child("Chats").child(chatName).child("" + (count))
				.setValue(data);

		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}

	public static void receiveMessage() {
		firebase.child("Chats").child(chatName)
				.addValueEventListener(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot snapshot) {
						System.out.println(snapshot.getValue());
						// Main.window.c.UpdateChat(snapshot.getValue());
					}

					@Override
					public void onCancelled(FirebaseError arg0) {
						// TODO Auto-generated method stub

					}
				});
	}

	public static void getChildCount() {
	
		firebase.child("Chats").child(chatName)
				.addValueEventListener(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot snapshot) {
						count = snapshot.getChildrenCount();
					}

					@Override
					public void onCancelled(FirebaseError arg0) {
						// TODO Auto-generated method stub

					}
				});
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
