package bai1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class CongTyTrueLove extends CongTy {
	private Set<String> tenDaDung = new HashSet<>();
	private Map<String, Integer> tanSuatTen = new HashMap<>();
	private Queue<String> danhSachDuLich = new LinkedList<>();

	@Override
	public void themNhanVien(String ten) {
		super.themNhanVien(ten);
		tanSuatTen.put(ten, tanSuatTen.getOrDefault(ten, 0) + 1);
	}

	@Override
	public void xoaNhanVien(String ten) {
		super.xoaNhanVien(ten);
		tanSuatTen.put(ten, tanSuatTen.get(ten) - 1);
	}

	public String chonNguoiNhanQua() {
		if (danhSachNhanVien.isEmpty()) {
			return "Khong co nhan vien nao ";
		}
		int chiSoNgauNhien = new Random().nextInt(danhSachNhanVien.size());
		return (String) danhSachNhanVien.toArray()[chiSoNgauNhien];
	}

	public String datTenSanPham() {
		for (String ten : danhSachNhanVien) {
			if (tenDaDung.add(ten)) {
				return ten;
			}
		}
		return "Khong co ten nao moi ";
	}

	public void dangKyDuLich(String ten) {
		if (danhSachNhanVien.contains(ten)) {
			danhSachDuLich.add(ten);
		}
	}

	public String nguoiDiDuLichTiepTheo() {
		return danhSachDuLich.isEmpty() ? "Khong co ai trong danh sach du lich. " : danhSachDuLich.poll();
	}

	public String tenPhoBienNhat() {
		return tanSuatTen.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey)
				.orElse("Không có tên phổ biến.");
	}

	@Override
	public void hienThiBang() {
		// TODO Auto-generated method stub
		String[] columnNames = { "Chức năng", "Kết quả" };
		DefaultTableModel model = new DefaultTableModel(columnNames, 0);

		model.addRow(new Object[] { "Người nhận quà ngẫu nhiên", chonNguoiNhanQua() });
		model.addRow(new Object[] { "Người nhận quà ngẫu nhiên", chonNguoiNhanQua() });

		model.addRow(new Object[] { "Tên sản phẩm mới", datTenSanPham() });
		model.addRow(new Object[] { "Tên sản phẩm mới", datTenSanPham() });
		model.addRow(new Object[] { "Tên sản phẩm mới", datTenSanPham() });
		model.addRow(new Object[] { "Tên sản phẩm mới", datTenSanPham() });

		model.addRow(new Object[] { "Tên phổ biến nhất", tenPhoBienNhat() });

		dangKyDuLich("An");
		dangKyDuLich("Binh");
		dangKyDuLich("Chi");
		dangKyDuLich("Binh");
		model.addRow(new Object[] { "Người đăng ký du lịch tiếp theo", nguoiDiDuLichTiepTheo() });
		model.addRow(new Object[] { "Người đăng ký du lịch tiếp theo", nguoiDiDuLichTiepTheo() });
		model.addRow(new Object[] { "Người đăng ký du lịch tiếp theo", nguoiDiDuLichTiepTheo() });
		model.addRow(new Object[] { "Người đăng ký du lịch tiếp theo", nguoiDiDuLichTiepTheo() });
		model.addRow(new Object[] { "Người đăng ký du lịch tiếp theo", nguoiDiDuLichTiepTheo() });

		JTable table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		JFrame frame = new JFrame("Kết quả công ty TrueLove");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(scrollPane);
		frame.setSize(800, 400);
		frame.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CongTyTrueLove congTy = new CongTyTrueLove();
		congTy.themNhanVien("An");
		congTy.themNhanVien("Binh");
		congTy.themNhanVien("Chi");
		congTy.themNhanVien("An");
		congTy.themNhanVien("Dat");
		congTy.themNhanVien("Lan");
		congTy.themNhanVien("Minh");
		congTy.themNhanVien("Trang");

		congTy.hienThiBang();
	}

}
