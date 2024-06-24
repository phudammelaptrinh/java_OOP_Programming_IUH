package bai11;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main {
	private static Queue<Customer> customerQueue = new LinkedList<>();
	private static JTextArea displayArea;

	public static void main(String[] args) {
		// Load data from file
		loadFromFile();

		// Create test data
		createTestData();

		// Set up frame
		JFrame frame = new JFrame("Ticket Management System");
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
		buttonPanel.setLayout(new GridLayout(2, 3, 10, 10));

		JButton addButton = new JButton("Thêm khách hàng");
		addButton.addActionListener(e -> addCustomer());
		buttonPanel.add(addButton);

		JButton sellButton = new JButton("Bán vé");
		sellButton.addActionListener(e -> sellTicket());
		buttonPanel.add(sellButton);

		JButton displayButton = new JButton("Hiển thị danh sách");
		displayButton.addActionListener(e -> displayCustomers());
		buttonPanel.add(displayButton);

		JButton cancelButton = new JButton("Hủy vé");
		cancelButton.addActionListener(e -> cancelTicket());
		buttonPanel.add(cancelButton);

		JButton saveButton = new JButton("Lưu danh sách");
		saveButton.addActionListener(e -> saveToFile());
		buttonPanel.add(saveButton);

		JButton summaryButton = new JButton("Thống kê");
		summaryButton.addActionListener(e -> showSummary());
		buttonPanel.add(summaryButton);

		// Add some padding around the button panel
		JPanel paddedButtonPanel = new JPanel(new BorderLayout());
		paddedButtonPanel.add(buttonPanel, BorderLayout.CENTER);
		paddedButtonPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
		frame.add(paddedButtonPanel, BorderLayout.SOUTH);

		frame.setVisible(true);

		// Display initial data
		displayCustomers();
	}

	private static void addCustomer() {
		String id = JOptionPane.showInputDialog("Nhập số CMND:");
		String name = JOptionPane.showInputDialog("Nhập tên khách hàng:");
		double price = Double.parseDouble(JOptionPane.showInputDialog("Nhập giá tiền:"));

		Customer customer = new Customer(id, name, price);
		customerQueue.offer(customer);

		displayArea.append("Thêm khách hàng: " + customer + "\n");
	}

	private static void sellTicket() {
		Customer customer = customerQueue.poll();
		if (customer != null) {
			displayArea.append("Bán vé cho khách hàng: " + customer + "\n");
		} else {
			displayArea.append("Không có khách hàng trong danh sách chờ.\n");
		}
	}

	private static void displayCustomers() {
		displayArea.setText("Danh sách khách hàng:\n");
		for (Customer customer : customerQueue) {
			displayArea.append(customer + "\n");
		}
	}

	private static void cancelTicket() {
		String id = JOptionPane.showInputDialog("Nhập số CMND khách hàng cần hủy vé:");
		boolean found = false;
		Queue<Customer> tempQueue = new LinkedList<>();

		while (!customerQueue.isEmpty()) {
			Customer customer = customerQueue.poll();
			if (customer.getId().equals(id)) {
				displayArea.append("Hủy vé cho khách hàng: " + customer + "\n");
				found = true;
			} else {
				tempQueue.offer(customer);
			}
		}
		customerQueue = tempQueue;

		if (!found) {
			displayArea.append("Không tìm thấy khách hàng với số CMND: " + id + "\n");
		}
	}

	private static void saveToFile() {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("customers.dat"))) {
			oos.writeObject(new LinkedList<>(customerQueue));
			displayArea.append("Lưu danh sách khách hàng vào file.\n");
		} catch (IOException e) {
			e.printStackTrace();
			displayArea.append("Lỗi khi lưu file.\n");
		}
	}

	@SuppressWarnings("unchecked")
	private static void loadFromFile() {
		File file = new File("customers.dat");
		if (!file.exists()) {
			return;
		}
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
			Object obj = ois.readObject();
			if (obj instanceof Queue) {
				customerQueue = (Queue<Customer>) obj;
			} else {
				displayArea.append("Dữ liệu không hợp lệ.\n");
			}
		} catch (IOException | ClassNotFoundException e) {
			e.printStackTrace();
			displayArea.append("Lỗi khi tải file dữ liệu.\n");
		}
	}

	private static void showSummary() {
		int waitingCustomers = customerQueue.size();
		double totalRevenue = customerQueue.stream().mapToDouble(Customer::getTicketPrice).sum();

		displayArea.append("Thống kê:\n");
		displayArea.append("Số khách hàng đang chờ: " + waitingCustomers + "\n");
		displayArea.append("Tổng số tiền đã thu: " + totalRevenue + "\n");
	}

	private static void createTestData() {
		if (customerQueue.isEmpty()) {
			customerQueue.offer(new Customer("123456789", "Nguyen Van A", 50000));
			customerQueue.offer(new Customer("987654321", "Le Thi B", 60000));
			customerQueue.offer(new Customer("192837465", "Tran Van C", 70000));
			customerQueue.offer(new Customer("564738291", "Pham Thi D", 80000));
			customerQueue.offer(new Customer("102938475", "Hoang Van E", 90000));
		}
	}
}
