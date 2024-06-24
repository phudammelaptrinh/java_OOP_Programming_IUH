package bai3;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class TapHopSoNguyenGUI extends JFrame {
	private JTextField inputField1;
	private JTextField inputField2;
	private JTextArea resultArea;

	public TapHopSoNguyenGUI() {
		// Khởi tạo giao diện người dùng
		setTitle("Tính Toán Tập Hợp Số Nguyên");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Khởi tạo các thành phần
		inputField1 = new JTextField(20);
		inputField2 = new JTextField(20);
		resultArea = new JTextArea(15, 40);
		resultArea.setEditable(false);
		JButton calculateButton = new JButton("Tính Toán");

		// Thiết lập bố cục
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(3, 2)); // Sử dụng GridLayout để dễ dàng căn chỉnh
		inputPanel.add(new JLabel("Nhập tập hợp 1 (các số cách nhau bằng dấu phẩy):"));
		inputPanel.add(inputField1);
		inputPanel.add(new JLabel("Nhập tập hợp 2 (các số cách nhau bằng dấu phẩy):"));
		inputPanel.add(inputField2);
		inputPanel.add(new JLabel("")); // Thêm nhãn rỗng để căn chỉnh nút tính toán
		inputPanel.add(calculateButton);
		panel.add(inputPanel, BorderLayout.NORTH);
		panel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

		// Thêm hành động cho nút "Tính Toán"
		calculateButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String input1 = inputField1.getText();
				String input2 = inputField2.getText();

				if (!input1.isEmpty() && !input2.isEmpty()) {
					Set<Integer> set1 = taoTapHop(input1);
					Set<Integer> set2 = taoTapHop(input2);

					if (set1 != null && set2 != null) {
						Set<Integer> giao = new HashSet<>(set1);
						giao.retainAll(set2);

						Set<Integer> hop = new HashSet<>(set1);
						hop.addAll(set2);

						Set<Integer> hieu = new HashSet<>(set1);
						hieu.removeAll(set2);

						resultArea.setText("");
						resultArea.append("Giao của hai tập hợp: " + sapXep(giao) + "\n");
						resultArea.append("Hợp của hai tập hợp: " + sapXep(hop) + "\n");
						resultArea.append("Hiệu của hai tập hợp (tập hợp 1 - tập hợp 2): " + sapXep(hieu) + "\n");
					} else {
						resultArea.setText("Vui lòng nhập đúng định dạng các số nguyên cách nhau bằng dấu phẩy.");
					}
				} else {
					resultArea.setText("Vui lòng nhập cả hai tập hợp.");
				}
			}
		});

		// Thêm bảng điều khiển vào khung
		add(panel);
	}

	// Phương thức tạo tập hợp từ chuỗi đầu vào
	private Set<Integer> taoTapHop(String input) {
		try {
			Set<Integer> set = new HashSet<>();
			String[] parts = input.split(",");
			for (String part : parts) {
				set.add(Integer.parseInt(part.trim()));
			}
			return set;
		} catch (NumberFormatException e) {
			return null;
		}
	}

	// Phương thức sắp xếp tập hợp theo thứ tự tăng dần và trả về danh sách
	private List<Integer> sapXep(Set<Integer> set) {
		List<Integer> list = new ArrayList<>(set);
		Collections.sort(list);
		return list;
	}

	// Khởi tạo và hiển thị giao diện người dùng
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new TapHopSoNguyenGUI().setVisible(true);
			}
		});
	}
}
