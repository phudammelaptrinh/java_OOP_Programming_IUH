package bai4;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class QuanLySinhVienGUI extends JFrame {
	private QuanLySinhVien qlsv;
	private JTextField txtMa, txtHoTen, txtNamSinh, txtTimKiem;
	private JTextArea areaDanhSach;

	public QuanLySinhVienGUI() {
		qlsv = new QuanLySinhVien();

		// Thiết lập giao diện
		setTitle("Quản Lý Sinh Viên");
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Tạo tabbed pane
		JTabbedPane tabbedPane = new JTabbedPane();

		// Khởi tạo các thành phần cho trang quản lý sinh viên
		txtMa = new JTextField(15);
		txtHoTen = new JTextField(20);
		txtNamSinh = new JTextField(10);
		JButton btnThem = new JButton("Thêm");
		JButton btnXoa = new JButton("Xóa");
		JButton btnSua = new JButton("Sửa");

		// Tạo panel cho trang quản lý sinh viên
		JPanel panelQuanLy = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(10, 10, 10, 10);

		// Tiêu đề
		gbc.gridx = 0;
		gbc.gridy = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		JLabel lblTitle = new JLabel("Trang Quản Lý Sinh Viên");
		lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
		panelQuanLy.add(lblTitle, gbc);

		// Label và TextField cho Mã
		gbc.gridwidth = 1;
		gbc.anchor = GridBagConstraints.EAST;
		gbc.gridy = 1;
		gbc.gridx = 0;
		panelQuanLy.add(new JLabel("Mã:"), gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panelQuanLy.add(txtMa, gbc);

		// Label và TextField cho Họ Tên
		gbc.gridy = 2;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		panelQuanLy.add(new JLabel("Họ Tên:"), gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panelQuanLy.add(txtHoTen, gbc);

		// Label và TextField cho Năm Sinh
		gbc.gridy = 3;
		gbc.gridx = 0;
		gbc.anchor = GridBagConstraints.EAST;
		panelQuanLy.add(new JLabel("Năm Sinh:"), gbc);
		gbc.gridx = 1;
		gbc.anchor = GridBagConstraints.WEST;
		panelQuanLy.add(txtNamSinh, gbc);

		// Nút Thêm, Xóa, Sửa
		JPanel panelButtons = new JPanel();
		panelButtons.add(btnThem);
		panelButtons.add(btnXoa);
		panelButtons.add(btnSua);

		gbc.gridy = 4;
		gbc.gridx = 0;
		gbc.gridwidth = 2;
		gbc.anchor = GridBagConstraints.CENTER;
		panelQuanLy.add(panelButtons, gbc);

		// Thêm trang quản lý sinh viên vào tabbed pane
		tabbedPane.addTab("Quản Lý Sinh Viên", panelQuanLy);

		// Khởi tạo các thành phần cho trang hiển thị kết quả
		areaDanhSach = new JTextArea(20, 50);
		areaDanhSach.setEditable(false);
		txtTimKiem = new JTextField(20);
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		JButton btnSapXep = new JButton("Sắp Xếp");

		// Tạo panel cho trang hiển thị kết quả
		JPanel panelHienThi = new JPanel(new BorderLayout());
		JPanel panelTimKiem = new JPanel(new FlowLayout());
		panelTimKiem.add(new JLabel("Tìm kiếm:"));
		panelTimKiem.add(txtTimKiem);
		panelTimKiem.add(btnTimKiem);
		panelTimKiem.add(btnSapXep);
		panelHienThi.add(panelTimKiem, BorderLayout.NORTH);
		panelHienThi.add(new JScrollPane(areaDanhSach), BorderLayout.CENTER);

		// Thêm trang hiển thị kết quả vào tabbed pane
		tabbedPane.addTab("Hiển Thị Kết Quả", panelHienThi);

		// Thêm tabbed pane vào frame
		add(tabbedPane);

		// Thêm hành động cho các nút trong trang quản lý sinh viên
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ma = txtMa.getText().trim();
				String hoTen = txtHoTen.getText().trim();
				String namSinhStr = txtNamSinh.getText().trim();
				if (ma.isEmpty() || hoTen.isEmpty() || namSinhStr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
					return;
				}
				int namSinh;
				try {
					namSinh = Integer.parseInt(namSinhStr);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Năm sinh phải là số nguyên.");
					return;
				}
				qlsv.themSinhVien(new SinhVien(ma, hoTen, namSinh));
				JOptionPane.showMessageDialog(null, "Thêm sinh viên thành công!");
				txtMa.setText("");
				txtHoTen.setText("");
				txtNamSinh.setText("");
				capNhatDanhSach();
			}
		});

		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ma = txtMa.getText().trim();
				if (ma.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sinh viên cần xóa.");
					return;
				}
				qlsv.xoaSinhVien(ma);
				JOptionPane.showMessageDialog(null, "Xóa sinh viên thành công!");
				txtMa.setText("");
				capNhatDanhSach();
			}
		});

		btnSua.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String ma = txtMa.getText().trim();
				String hoTen = txtHoTen.getText().trim();
				String namSinhStr = txtNamSinh.getText().trim();
				if (ma.isEmpty() || hoTen.isEmpty() || namSinhStr.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin.");
					return;
				}
				int namSinh;
				try {
					namSinh = Integer.parseInt(namSinhStr);
				} catch (NumberFormatException ex) {
					JOptionPane.showMessageDialog(null, "Năm sinh phải là số nguyên.");
					return;
				}
				qlsv.suaThongTinSinhVien(ma, hoTen, namSinh);
				JOptionPane.showMessageDialog(null, "Sửa thông tin sinh viên thành công!");
				txtMa.setText("");
				txtHoTen.setText("");
				txtNamSinh.setText("");
				capNhatDanhSach();
			}
		});

		btnSapXep.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				qlsv.sapXepTheoMaTangDan();
				capNhatDanhSach();
			}
		});

		// Thêm hành động cho nút Tìm kiếm trong trang hiển thị kết quả
		btnTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String timKiem = txtTimKiem.getText().trim();
				if (timKiem.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập mã hoặc tên sinh viên cần tìm.");
					return;
				}
				SinhVien sv = qlsv.timKiemTheoMa(timKiem);
				if (sv != null) {
					areaDanhSach.setText(String.format("%-10s %-20s %-10s\n", "Mã", "Họ Tên", "Năm Sinh"));
					areaDanhSach.append(sv.toString());
				} else {
					List<SinhVien> ketQua = qlsv.timKiemTheoTen(timKiem);
					if (!ketQua.isEmpty()) {
						areaDanhSach.setText(String.format("%-10s %-20s %-10s\n", "Mã", "Họ Tên", "Năm Sinh"));
						for (SinhVien sinhVien : ketQua) {
							areaDanhSach.append(sinhVien.toString() + "\n");
						}
					} else {
						areaDanhSach.setText("Không tìm thấy sinh viên.");
					}
				}
				txtTimKiem.setText("");
			}
		});

		// Thêm DocumentListener cho ô nhập liệu mã sinh viên để tự động điền thông tin
		txtMa.getDocument().addDocumentListener(new DocumentListener() {
			@Override
			public void insertUpdate(DocumentEvent e) {
				capNhatThongTinSinhVien();
			}

			@Override
			public void removeUpdate(DocumentEvent e) {
				capNhatThongTinSinhVien();
			}

			@Override
			public void changedUpdate(DocumentEvent e) {
				capNhatThongTinSinhVien();
			}

			private void capNhatThongTinSinhVien() {
				String ma = txtMa.getText().trim();
				if (!ma.isEmpty()) {
					SinhVien sv = qlsv.timKiemTheoMa(ma);
					if (sv != null) {
						txtHoTen.setText(sv.getHoTen());
						txtNamSinh.setText(String.valueOf(sv.getNamSinh()));
					} else {
						txtHoTen.setText("");
						txtNamSinh.setText("");
					}
				} else {
					txtHoTen.setText("");
					txtNamSinh.setText("");
				}
			}
		});

		capNhatDanhSach();
	}

	private void capNhatDanhSach() {
		List<SinhVien> danhSach = qlsv.getDanhSachSinhVien();
		areaDanhSach.setText(String.format("%-10s %-20s %-10s\n", "Mã", "Họ Tên", "Năm Sinh"));
		for (SinhVien sv : danhSach) {
			areaDanhSach.append(sv.toString() + "\n");
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				QuanLySinhVienGUI frame = new QuanLySinhVienGUI();
				frame.setVisible(true);
			}
		});
	}
}
