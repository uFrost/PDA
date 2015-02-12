package FBUtils;

import java.io.IOException;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class FireBaseUtils {

	static Firebase firebase = new Firebase("https://pda.firebaseio.com/");

	public static String chatName;

	public static long count;

	public static String myName;
	
	public static void setChat( String name2) {
		getChildCount();
		// Main.window.c.removeAll();
		chatName = (myName.compareTo(name2) == 1) ? (myName + name2)
				: (name2 + myName);

	}

	public static void SendMessage(String data) {

		firebase.child("Chats").child(chatName).child("" + (++count ))
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

		firebase.child("Chats").child(chatName).addValueEventListener(
				new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot snapshot) {
						count = snapshot.getChildrenCount();
					}

					@Override
					public void onCancelled(FirebaseError arg0) {
						// TODO Auto-generated method stub

					}
				});
	}

}
