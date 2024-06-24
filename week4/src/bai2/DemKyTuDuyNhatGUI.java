package bai2;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class DemKyTuDuyNhatGUI extends JFrame {
	private JTextField oNhapLieu;
	private JTextArea khuVucKetQua;
	private Map<String, Integer> boNhoDemKyTu;

	public DemKyTuDuyNhatGUI() {
		// Khởi tạo giao diện người dùng
		setTitle("Đếm Ký Tự Duy Nhất");
		setSize(400, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Khởi tạo các thành phần
		boNhoDemKyTu = new HashMap<>();
		oNhapLieu = new JTextField(20);
		khuVucKetQua = new JTextArea(10, 30);
		khuVucKetQua.setEditable(false);
		JButton nutDem = new JButton("Đếm");

		// Thiết lập bố cục
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		JPanel panelNhapLieu = new JPanel();
		panelNhapLieu.add(new JLabel("Nhập chuỗi:"));
		panelNhapLieu.add(oNhapLieu);
		panelNhapLieu.add(nutDem);
		panel.add(panelNhapLieu, BorderLayout.NORTH);
		panel.add(new JScrollPane(khuVucKetQua), BorderLayout.CENTER);

		// Thêm hành động cho nút "Đếm"
		nutDem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String chuoi = oNhapLieu.getText();
				if (!chuoi.isEmpty()) {
					int soKyTuDuyNhat = demKyTuDuyNhat(chuoi);
					khuVucKetQua.append("Chuỗi: \"" + chuoi + "\" có " + soKyTuDuyNhat + " ký tự duy nhất.\n");
					oNhapLieu.setText("");
				}
			}
		});

		// Thêm bảng điều khiển vào khung
		add(panel);
	}

	// Phương thức đếm ký tự duy nhất và lưu vào boNhoDemKyTu
	public int demKyTuDuyNhat(String chuoi) {
		if (boNhoDemKyTu.containsKey(chuoi)) {
			return boNhoDemKyTu.get(chuoi);
		}

		int soKyTuDuyNhat = (int) chuoi.chars().distinct().count();
		boNhoDemKyTu.put(chuoi, soKyTuDuyNhat);
		return soKyTuDuyNhat;
	}

	// Khởi tạo và hiển thị giao diện người dùng
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new DemKyTuDuyNhatGUI().setVisible(true);
			}
		});
	}
}
