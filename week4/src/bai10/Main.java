package bai10;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Main {
	private static List<PhoneBookEntry> phoneBook = new LinkedList<>();
	private static JTextArea displayArea;

	public static void main(String[] args) {
		// Create test data
		createTestData();

		// Set up frame
		JFrame frame = new JFrame("Phone Book");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Text area to display data
		displayArea = new JTextArea();
		displayArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(displayArea);
		frame.add(scrollPane, BorderLayout.CENTER);

		// Panel for input and buttons
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(3, 2, 10, 10));

		JTextField searchField = new JTextField();
		inputPanel.add(new JLabel("Nhập địa chỉ hoặc số điện thoại:"));
		inputPanel.add(searchField);

		JButton searchByAddressButton = new JButton("Tra cứu theo địa chỉ");
		searchByAddressButton.addActionListener(e -> searchByAddress(searchField.getText()));
		inputPanel.add(searchByAddressButton);

		JButton searchByPhoneNumberButton = new JButton("Tra cứu theo số điện thoại");
		searchByPhoneNumberButton.addActionListener(e -> searchByPhoneNumber(searchField.getText()));
		inputPanel.add(searchByPhoneNumberButton);

		frame.add(inputPanel, BorderLayout.NORTH);

		frame.setVisible(true);
	}

	private static void createTestData() {
		phoneBook.add(new PhoneBookEntry("Nguyen Van A", "123 Nguyen Trai", "0909123456"));
		phoneBook.add(new PhoneBookEntry("Le Thi B", "456 Le Loi", "0918123456"));
		phoneBook.add(new PhoneBookEntry("Tran Van C", "789 Tran Hung Dao", "0927123456"));
		phoneBook.add(new PhoneBookEntry("Pham Thi D", "321 Hai Ba Trung", "0936123456"));
	}

	private static void searchByAddress(String address) {
		displayArea.setText("Kết quả tra cứu theo địa chỉ:\n");
		for (PhoneBookEntry entry : phoneBook) {
			if (entry.getAddress().equalsIgnoreCase(address)) {
				displayArea.append(entry.toString() + "\n");
			}
		}
	}

	private static void searchByPhoneNumber(String phoneNumber) {
		displayArea.setText("Kết quả tra cứu theo số điện thoại:\n");
		for (PhoneBookEntry entry : phoneBook) {
			if (entry.getPhoneNumber().equals(phoneNumber)) {
				displayArea.append(entry.toString() + "\n");
			}
		}
	}
}
