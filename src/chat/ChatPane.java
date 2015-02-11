package chat;

import java.awt.Color;
import java.util.Scanner;

public class ChatPane extends ColorPane {

	private static final long serialVersionUID = 1L;
	// PULLTEST
	public MessageHandler messageHandler;

	public ChatPane(MessageHandler messageHandler) {
		this.messageHandler = messageHandler;
		messageHandler.setChatPane(this);
		messageHandler.init();

	}

	public void updateChat(String message) {

		this.setEditable(true);

		this.append(processColor(message), ("\n" + processMessage(message)), processBold(message));
		this.setEditable(false);

	}

	public void updateAllChat(String message) {

		this.setText("");
		this.append(new Color((int) (Math.random() * 255),
				(int) (Math.random() * 255), (int) (Math.random() * 255)),
				("\n" + message), processBold(message));
	}

	public boolean processBold(String s){
		Scanner scanner = new Scanner(s);
		scanner.useDelimiter("");
		if(scanner.hasNext("~")){
			scanner.skip("~");
			return true;
		}
		return false;
	}
	
	public Color processColor(String s) {
		String r = "", g = "", b = "";
		int count = 0;
		Scanner scanner = new Scanner(s);
		scanner.useDelimiter("");
		
		if (scanner.hasNext("\\*")) {

			scanner.skip("\\*");
			if (scanner.hasNext("\\(")) {
				scanner.skip("\\(");
				while (scanner.hasNext()) {
					if (scanner.hasNext("\\,")) {
						scanner.skip("\\,");
						count++;
					} else if (scanner.hasNext("\\)")) {
						scanner.skip("\\)");
						break;
					} else {
						switch (count) {
						case 0:
							r += scanner.next();
							break;
						case 1:
							g += scanner.next();
							break;
						case 2:
							b += scanner.next();
							break;
						default:
							return Color.BLACK;
						}
					}
				}

			}
			return new Color(Integer.parseInt(r), Integer.parseInt(g),
					Integer.parseInt(b));

		} else {

			return Color.BLACK;
		}

	}

	public String processMessage(String s) {
		String message = "";

		Scanner scanner = new Scanner(s);
		scanner.useDelimiter("");
		if(scanner.hasNext("~")){
			scanner.skip("~");
		}
		if (scanner.hasNext("\\*")) {

			scanner.skip("\\*");
			while (!scanner.hasNext("\\)")) {
				scanner.next();

			}
			scanner.skip("\\)");
			while (scanner.hasNext()) {
				message += scanner.next();
			}
			return message;

		} else {

			return s;
		}

	}
}
