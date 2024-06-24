package bai6;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.table.DefaultTableModel;

public class QuanLyPhongHocGUI extends JFrame {
	private QuanLyPhongHoc quanLyPhongHoc;
	private JTextField txtMaPhong, txtDayNha, txtDienTich, txtSoBongDen, txtThemMayTinh, txtTimKiem;
	private JTextArea areaKetQuaTimKiem;
	private JTable tableDanhSachDatChuan, tableDanhSachPhongHoc;
	private JLabel lblTongSoPhongHoc, lblPhongMay60May;

	public QuanLyPhongHocGUI() {
		quanLyPhongHoc = new QuanLyPhongHoc();

		// Thêm dữ liệu kiểm tra
		themDuLieuTest();

		// Thiết lập giao diện
		setTitle("Quản Lý Phòng Học");
		setSize(900, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);

		// Tạo tabbed pane
		JTabbedPane tabbedPane = new JTabbedPane();

		// Khởi tạo các thành phần cho trang quản lý phòng học
		txtMaPhong = new JTextField(15);
		txtDayNha = new JTextField(15);
		txtDienTich = new JTextField(10);
		txtSoBongDen = new JTextField(5);
		txtThemMayTinh = new JTextField(5);
		txtTimKiem = new JTextField(15);
		areaKetQuaTimKiem = new JTextArea(20, 50);
		areaKetQuaTimKiem.setEditable(false);

		JButton btnThem = new JButton("Thêm");
		JButton btnXoa = new JButton("Xóa");
		JButton btnCapNhatMayTinh = new JButton("Sửa");

		lblTongSoPhongHoc = new JLabel("Tổng số phòng học: 0");
		lblPhongMay60May = new JLabel("Số phòng máy >= 60 máy: 0");

		// Tạo panel cho trang quản lý phòng học
		JPanel panelQuanLy = new JPanel();
		panelQuanLy.setLayout(new BorderLayout());
		panelQuanLy.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		JPanel panelInput = new JPanel(new GridBagLayout());
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 0;
		gbc.gridy = 0;
		panelInput.add(new JLabel("Mã Phòng:"), gbc);
		gbc.gridx = 1;
		panelInput.add(txtMaPhong, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panelInput.add(new JLabel("Dãy Nhà:"), gbc);
		gbc.gridx = 1;
		panelInput.add(txtDayNha, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panelInput.add(new JLabel("Diện Tích:"), gbc);
		gbc.gridx = 1;
		panelInput.add(txtDienTich, gbc);

		gbc.gridx = 0;
		gbc.gridy = 3;
		panelInput.add(new JLabel("Số Bóng Đèn:"), gbc);
		gbc.gridx = 1;
		panelInput.add(txtSoBongDen, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		panelInput.add(new JLabel("Thêm Máy Tính (nếu có):"), gbc);
		gbc.gridx = 1;
		panelInput.add(txtThemMayTinh, gbc);

		JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
		panelButtons.add(btnThem);
		panelButtons.add(btnXoa);
		panelButtons.add(btnCapNhatMayTinh);

		JPanel panelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
		panelInfo.add(lblTongSoPhongHoc);
		panelInfo.add(lblPhongMay60May);

		panelQuanLy.add(panelInput, BorderLayout.NORTH);
		panelQuanLy.add(panelButtons, BorderLayout.CENTER);
		panelQuanLy.add(panelInfo, BorderLayout.SOUTH);

		// Tạo panel cho trang tìm kiếm và hiển thị kết quả
		JPanel panelTimKiem = new JPanel(new BorderLayout());
		JPanel panelTimKiemInput = new JPanel(new FlowLayout());
		JButton btnTimKiem = new JButton("Tìm Kiếm");
		JButton btnSapXepDayNha = new JButton("Sắp Xếp Dãy Nhà");
		JButton btnSapXepDienTich = new JButton("Sắp Xếp Diện Tích");
		JButton btnSapXepBongDen = new JButton("Sắp Xếp Bóng Đèn");

		panelTimKiemInput.add(new JLabel("Tìm Kiếm Mã Phòng:"));
		panelTimKiemInput.add(txtTimKiem);
		panelTimKiemInput.add(btnTimKiem);
		panelTimKiemInput.add(btnSapXepDayNha);
		panelTimKiemInput.add(btnSapXepDienTich);
		panelTimKiemInput.add(btnSapXepBongDen);

		panelTimKiem.add(panelTimKiemInput, BorderLayout.NORTH);
		panelTimKiem.add(new JScrollPane(areaKetQuaTimKiem), BorderLayout.CENTER);

		// Tạo bảng danh sách phòng học
		String[] columnNames = { "Mã Phòng", "Dãy Nhà", "Diện Tích", "Số Bóng Đèn", "Loại Phòng" };
		DefaultTableModel modelPhongHoc = new DefaultTableModel(columnNames, 0);
		tableDanhSachPhongHoc = new JTable(modelPhongHoc);
		JScrollPane scrollPanePhongHoc = new JScrollPane(tableDanhSachPhongHoc);

		// Tạo bảng danh sách đạt chuẩn
		DefaultTableModel modelDatChuan = new DefaultTableModel(columnNames, 0);
		tableDanhSachDatChuan = new JTable(modelDatChuan);
		JScrollPane scrollPaneDatChuan = new JScrollPane(tableDanhSachDatChuan);

		// Thêm bảng danh sách phòng học và đạt chuẩn vào tab "Tìm Kiếm & Hiển Thị"
		JPanel panelDanhSachPhongHoc = new JPanel(new BorderLayout());
		panelDanhSachPhongHoc.add(new JLabel("Danh Sách Phòng Học"), BorderLayout.NORTH);
		panelDanhSachPhongHoc.add(scrollPanePhongHoc, BorderLayout.CENTER);

		JPanel panelDanhSachDatChuan = new JPanel(new BorderLayout());
		panelDanhSachDatChuan.add(new JLabel("Danh Sách Đạt Chuẩn"), BorderLayout.NORTH);
		panelDanhSachDatChuan.add(scrollPaneDatChuan, BorderLayout.CENTER);

		JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panelTimKiem, panelDanhSachPhongHoc);
		splitPane.setDividerLocation(250);

		JSplitPane splitPaneDanhSach = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane, panelDanhSachDatChuan);
		splitPaneDanhSach.setDividerLocation(400);

		// Thêm panel vào tabbed pane
		tabbedPane.addTab("Quản Lý Phòng Học", panelQuanLy);
		tabbedPane.addTab("Tìm Kiếm & Hiển Thị", splitPaneDanhSach);

		// Thêm tabbed pane vào frame
		add(tabbedPane);

		// Thêm hành động cho các nút
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Object[] options = { "Thêm Lý Thuyết", "Thêm Máy Tính", "Thêm Thí Nghiệm" };
				int n = JOptionPane.showOptionDialog(null, "Chọn loại phòng học muốn thêm:", "Chọn loại phòng học",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[2]);
				if (n == 0) {
					themPhongLyThuyet();
				} else if (n == 1) {
					themPhongMayTinh();
				} else if (n == 2) {
					themPhongThiNghiem();
				}
			}
		});

		btnTimKiem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String maPhong = txtTimKiem.getText().trim();
				PhongHoc phongHoc = quanLyPhongHoc.timKiemPhongHoc(maPhong);
				if (phongHoc != null) {
					areaKetQuaTimKiem.setText(phongHoc.toString());
				} else {
					areaKetQuaTimKiem.setText("Không tìm thấy phòng học với mã phòng này.");
				}
			}
		});

		txtMaPhong.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					String maPhong = txtMaPhong.getText().trim();
					PhongHoc phongHoc = quanLyPhongHoc.timKiemPhongHoc(maPhong);
					if (phongHoc != null) {
						txtDayNha.setText(phongHoc.getDayNha());
						txtDienTich.setText(String.valueOf(phongHoc.getDienTich()));
						txtSoBongDen.setText(String.valueOf(phongHoc.getSoBongDen()));
						if (phongHoc instanceof PhongMayTinh) {
							txtThemMayTinh.setText(String.valueOf(((PhongMayTinh) phongHoc).getSoLuongMayTinh()));
						} else {
							txtThemMayTinh.setText("");
						}
					} else {
						txtDayNha.setText("");
						txtDienTich.setText("");
						txtSoBongDen.setText("");
						txtThemMayTinh.setText("");
						JOptionPane.showMessageDialog(null, "Không tìm thấy phòng học với mã phòng này.");
					}
				}
			}
		});

		btnSapXepDayNha.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quanLyPhongHoc.sapXepTheoDayNha();
				capNhatDanhSach();
			}
		});

		btnSapXepDienTich.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quanLyPhongHoc.sapXepTheoDienTichGiamDan();
				capNhatDanhSach();
			}
		});

		btnSapXepBongDen.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				quanLyPhongHoc.sapXepTheoSoBongDenTangDan();
				capNhatDanhSach();
			}
		});

		btnXoa.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String maPhong = txtMaPhong.getText().trim();
				quanLyPhongHoc.xoaPhongHoc(maPhong);
				capNhatDanhSach();
			}
		});

		btnCapNhatMayTinh.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String maPhong = txtMaPhong.getText().trim();
				int soLuongMayTinh = Integer.parseInt(txtThemMayTinh.getText().trim());
				quanLyPhongHoc.capNhatSoMayTinh(maPhong, soLuongMayTinh);
				capNhatDanhSach();
			}
		});

		capNhatDanhSach();
	}

	private void themPhongLyThuyet() {
		JTextField txtMaPhong = new JTextField(15);
		JTextField txtDayNha = new JTextField(15);
		JTextField txtDienTich = new JTextField(10);
		JTextField txtSoBongDen = new JTextField(5);

		JPanel panel = new JPanel(new GridLayout(0, 2));
		panel.add(new JLabel("Mã Phòng:"));
		panel.add(txtMaPhong);
		panel.add(new JLabel("Dãy Nhà:"));
		panel.add(txtDayNha);
		panel.add(new JLabel("Diện Tích:"));
		panel.add(txtDienTich);
		panel.add(new JLabel("Số Bóng Đèn:"));
		panel.add(txtSoBongDen);

		int result = JOptionPane.showConfirmDialog(null, panel, "Thêm Phòng Lý Thuyết", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			String maPhong = txtMaPhong.getText().trim();
			String dayNha = txtDayNha.getText().trim();
			double dienTich = Double.parseDouble(txtDienTich.getText().trim());
			int soBongDen = Integer.parseInt(txtSoBongDen.getText().trim());
			boolean coMayChieu = true; // Giả sử mặc định có máy chiếu
			PhongLyThuyet phongLT = new PhongLyThuyet(maPhong, dayNha, dienTich, soBongDen, coMayChieu);
			quanLyPhongHoc.themPhongHoc(phongLT);
			capNhatDanhSach();
		}
	}

	private void themPhongMayTinh() {
		JTextField txtMaPhong = new JTextField(15);
		JTextField txtDayNha = new JTextField(15);
		JTextField txtDienTich = new JTextField(10);
		JTextField txtSoBongDen = new JTextField(5);
		JTextField txtSoLuongMayTinh = new JTextField(5);

		JPanel panel = new JPanel(new GridLayout(0, 2));
		panel.add(new JLabel("Mã Phòng:"));
		panel.add(txtMaPhong);
		panel.add(new JLabel("Dãy Nhà:"));
		panel.add(txtDayNha);
		panel.add(new JLabel("Diện Tích:"));
		panel.add(txtDienTich);
		panel.add(new JLabel("Số Bóng Đèn:"));
		panel.add(txtSoBongDen);
		panel.add(new JLabel("Số Lượng Máy Tính:"));
		panel.add(txtSoLuongMayTinh);

		int result = JOptionPane.showConfirmDialog(null, panel, "Thêm Phòng Máy Tính", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			String maPhong = txtMaPhong.getText().trim();
			String dayNha = txtDayNha.getText().trim();
			double dienTich = Double.parseDouble(txtDienTich.getText().trim());
			int soBongDen = Integer.parseInt(txtSoBongDen.getText().trim());
			int soLuongMayTinh = Integer.parseInt(txtSoLuongMayTinh.getText().trim());
			PhongMayTinh phongMT = new PhongMayTinh(maPhong, dayNha, dienTich, soBongDen, soLuongMayTinh);
			quanLyPhongHoc.themPhongHoc(phongMT);
			capNhatDanhSach();
		}
	}

	private void themPhongThiNghiem() {
		JTextField txtMaPhong = new JTextField(15);
		JTextField txtDayNha = new JTextField(15);
		JTextField txtDienTich = new JTextField(10);
		JTextField txtSoBongDen = new JTextField(5);

		JPanel panel = new JPanel(new GridLayout(0, 2));
		panel.add(new JLabel("Mã Phòng:"));
		panel.add(txtMaPhong);
		panel.add(new JLabel("Dãy Nhà:"));
		panel.add(txtDayNha);
		panel.add(new JLabel("Diện Tích:"));
		panel.add(txtDienTich);
		panel.add(new JLabel("Số Bóng Đèn:"));
		panel.add(txtSoBongDen);

		int result = JOptionPane.showConfirmDialog(null, panel, "Thêm Phòng Thí Nghiệm", JOptionPane.OK_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE);
		if (result == JOptionPane.OK_OPTION) {
			String maPhong = txtMaPhong.getText().trim();
			String dayNha = txtDayNha.getText().trim();
			double dienTich = Double.parseDouble(txtDienTich.getText().trim());
			int soBongDen = Integer.parseInt(txtSoBongDen.getText().trim());
			String chuyenNganh = "Chuyen Nganh"; // Giả sử mặc định chuyên ngành
			int sucChua = 50; // Giả sử mặc định sức chứa
			boolean coBonRua = true; // Giả sử mặc định có bồn rửa
			PhongThiNghiem phongTN = new PhongThiNghiem(maPhong, dayNha, dienTich, soBongDen, chuyenNganh, sucChua,
					coBonRua);
			quanLyPhongHoc.themPhongHoc(phongTN);
			capNhatDanhSach();
		}
	}

	private void themDuLieuTest() {
		// Thêm một số phòng lý thuyết
		quanLyPhongHoc.themPhongHoc(new PhongLyThuyet("LT001", "A", 60.0, 10, true));
		quanLyPhongHoc.themPhongHoc(new PhongLyThuyet("LT002", "B", 55.0, 9, true));

		// Thêm một số phòng máy tính
		quanLyPhongHoc.themPhongHoc(new PhongMayTinh("MT001", "A", 70.0, 12, 65));
		quanLyPhongHoc.themPhongHoc(new PhongMayTinh("MT002", "B", 80.0, 15, 50));

		// Thêm một số phòng thí nghiệm
		quanLyPhongHoc.themPhongHoc(new PhongThiNghiem("TN001", "A", 50.0, 8, "Hóa học", 40, true));
		quanLyPhongHoc.themPhongHoc(new PhongThiNghiem("TN002", "B", 60.0, 10, "Vật lý", 45, true));
	}

	private void capNhatDanhSach() {
		List<PhongHoc> danhSach = quanLyPhongHoc.getDanhSachPhongHoc();
		DefaultTableModel modelPhongHoc = (DefaultTableModel) tableDanhSachPhongHoc.getModel();
		modelPhongHoc.setRowCount(0); // Clear existing data

		int tongSoPhongHoc = danhSach.size();
		int phongMay60May = 0;

		for (PhongHoc ph : danhSach) {
			String loaiPhong = ph instanceof PhongLyThuyet ? "Lý Thuyết"
					: ph instanceof PhongMayTinh ? "Máy Tính" : "Thí Nghiệm";
			modelPhongHoc.addRow(
					new Object[] { ph.getMaPhong(), ph.getDayNha(), ph.getDienTich(), ph.getSoBongDen(), loaiPhong });
			if (ph instanceof PhongMayTinh && ((PhongMayTinh) ph).getSoLuongMayTinh() >= 60) {
				phongMay60May++;
			}
		}

		lblTongSoPhongHoc.setText("Tổng số phòng học: " + tongSoPhongHoc);
		lblPhongMay60May.setText("Số phòng máy >= 60 máy: " + phongMay60May);

		// Cập nhật danh sách đạt chuẩn trong tab "Tìm Kiếm & Hiển Thị"
		List<PhongHoc> danhSachDatChuan = quanLyPhongHoc.inDanhSachPhongHocDatChuan();
		DefaultTableModel modelDatChuan = (DefaultTableModel) tableDanhSachDatChuan.getModel();
		modelDatChuan.setRowCount(0); // Clear existing data

		for (PhongHoc ph : danhSachDatChuan) {
			String loaiPhong = ph instanceof PhongLyThuyet ? "Lý Thuyết"
					: ph instanceof PhongMayTinh ? "Máy Tính" : "Thí Nghiệm";
			modelDatChuan.addRow(
					new Object[] { ph.getMaPhong(), ph.getDayNha(), ph.getDienTich(), ph.getSoBongDen(), loaiPhong });
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				QuanLyPhongHocGUI frame = new QuanLyPhongHocGUI();
				frame.setVisible(true);
			}
		});
	}
}
