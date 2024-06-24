package bai9;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.LinkedList;
import java.util.ListIterator;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {
	private static LinkedList<String> list1 = new LinkedList<>();
	private static LinkedList<String> list2 = new LinkedList<>();
	private static JTextArea displayArea;

	public static void main(String[] args) {
		// Create test data
		createTestData();

		// Set up frame
		JFrame frame = new JFrame("LinkedList Operations");
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());

		// Text area to display data
		displayArea = new JTextArea();
		displayArea.setEditable(false);
		JScrollPane scrollPane = new JScrollPane(displayArea);
		frame.add(scrollPane, BorderLayout.CENTER);

		// Panel for buttons
		JPanel buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3, 2, 10, 10));

		JButton showListsButton = new JButton("Hiển thị danh sách ban đầu");
		showListsButton.addActionListener(e -> showLists());
		buttonPanel.add(showListsButton);

		JButton transferButton = new JButton("Chuyển phần tử từ List 1 sang List 2");
		transferButton.addActionListener(e -> transferElements());
		buttonPanel.add(transferButton);

		JButton removeButton = new JButton("Xóa 'Banana' khỏi List 2");
		removeButton.addActionListener(e -> removeElement());
		buttonPanel.add(removeButton);

		JButton addButton = new JButton("Thêm 'Grape' vào List 2");
		addButton.addActionListener(e -> addElement());
		buttonPanel.add(addButton);

		JButton copyButton = new JButton("Sao chép List 2 sang List 3");
		copyButton.addActionListener(e -> copyList());
		buttonPanel.add(copyButton);

		JButton reverseButton = new JButton("Hiển thị List 3 theo thứ tự ngược lại");
		reverseButton.addActionListener(e -> reverseList());
		buttonPanel.add(reverseButton);

		frame.add(buttonPanel, BorderLayout.SOUTH);

		frame.setVisible(true);
	}

	private static void createTestData() {
		list1.add("Apple");
		list1.add("Banana");
		list1.add("Cherry");

		list2.add("Date");
		list2.add("Elderberry");
		list2.add("Fig");
	}

	private static void showLists() {
		displayArea.setText("List 1 ban đầu: " + list1 + "\n");
		displayArea.append("List 2 ban đầu: " + list2 + "\n");
	}

	private static void transferElements() {
		list2.addAll(list1);
		displayArea.append("List 2 sau khi thêm các phần tử từ List 1: " + list2 + "\n");
	}

	private static void removeElement() {
		list2.remove("Banana");
		displayArea.append("List 2 sau khi xóa phần tử 'Banana': " + list2 + "\n");
	}

	private static void addElement() {
		list2.add("Grape");
		displayArea.append("List 2 sau khi thêm phần tử 'Grape': " + list2 + "\n");
	}

	private static void copyList() {
		LinkedList<String> list3 = new LinkedList<>(list2);
		displayArea.append("List 3 (sao chép từ List 2): " + list3 + "\n");
	}

	private static void reverseList() {
		LinkedList<String> list3 = new LinkedList<>(list2);
		displayArea.append("List 3 theo thứ tự ngược lại: ");
		ListIterator<String> iterator = list3.listIterator(list3.size());
		while (iterator.hasPrevious()) {
			displayArea.append(iterator.previous() + " ");
		}
		displayArea.append("\n");
	}
}
