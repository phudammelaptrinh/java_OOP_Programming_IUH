package bai5;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class ChuoiGUI extends JFrame {
	private ChuoiUtils chuoiUtils;
	private JTextField txtChuoiNhap;
	private JTextArea areaKetQua;

	public ChuoiGUI() {
		chuoiUtils = new ChuoiUtils();

		// Thiết lập giao diện
		setTitle("Đếm Số Ký Tự Duy Nhất");
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Khởi tạo các thành phần
		txtChuoiNhap = new JTextField(30);
		JButton btnDem = new JButton("Đếm Ký Tự Duy Nhất");
		areaKetQua = new JTextArea(10, 50);
		areaKetQua.setEditable(false);

		// Tạo bố cục cho giao diện
		JPanel panelNhap = new JPanel();
		panelNhap.setLayout(new FlowLayout());
		panelNhap.add(new JLabel("Nhập chuỗi:"));
		panelNhap.add(txtChuoiNhap);
		panelNhap.add(btnDem);

		JPanel panelKetQua = new JPanel();
		panelKetQua.setLayout(new BorderLayout());
		panelKetQua.add(new JScrollPane(areaKetQua), BorderLayout.CENTER);

		// Thêm các panel vào frame
		add(panelNhap, BorderLayout.NORTH);
		add(panelKetQua, BorderLayout.CENTER);

		// Thêm hành động cho nút đếm
		btnDem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String chuoiNhap = txtChuoiNhap.getText().trim();
				if (chuoiNhap.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập một chuỗi.");
					return;
				}
				int soKyTuDuyNhat = chuoiUtils.demKyTuDuyNhat(chuoiNhap);
				Set<Character> kyTuDuyNhat = chuoiUtils.getKyTuDuyNhatTruocDo().get(chuoiNhap);
				areaKetQua.append("Chuỗi: " + chuoiNhap + " - Số ký tự duy nhất: " + soKyTuDuyNhat
						+ " - Ký tự duy nhất: " + kyTuDuyNhat + "\n");
				hienThiKetQuaTruocDo();
			}
		});
	}

	// Phương thức hiển thị kết quả đã tính toán trước đó
	private void hienThiKetQuaTruocDo() {
		Map<String, Integer> ketQuaTruocDo = chuoiUtils.getKetQuaTruocDo();
		Map<String, Set<Character>> kyTuDuyNhatTruocDo = chuoiUtils.getKyTuDuyNhatTruocDo();
		areaKetQua.append("\nKết quả đã tính toán trước đó:\n");
		for (Map.Entry<String, Integer> entry : ketQuaTruocDo.entrySet()) {
			String chuoi = entry.getKey();
			int soKyTuDuyNhat = entry.getValue();
			Set<Character> kyTuDuyNhat = kyTuDuyNhatTruocDo.get(chuoi);
			areaKetQua.append("Chuỗi: " + chuoi + " - Số ký tự duy nhất: " + soKyTuDuyNhat + " - Ký tự duy nhất: "
					+ kyTuDuyNhat + "\n");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				ChuoiGUI frame = new ChuoiGUI();
				frame.setVisible(true);
			}
		});
	}
}
