package bai5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ChuoiUtils {
	private Map<String, Integer> ketQuaTruocDo;
	private Map<String, Set<Character>> kyTuDuyNhatTruocDo;

	public ChuoiUtils() {
		ketQuaTruocDo = new HashMap<>();
		kyTuDuyNhatTruocDo = new HashMap<>();
	}

	// PT dem so ky tu duy nhat cua mot chuoi
	public int demKyTuDuyNhat(String chuoi) {
		// Kiểm tra nếu kết quả đã được tính trước đó
		if (ketQuaTruocDo.containsKey(chuoi)) {
			return ketQuaTruocDo.get(chuoi);
		}

		// Tính toán số ký tự duy nhất
		Set<Character> kyTuDuyNhat = new HashSet<>();
		for (char kyTu : chuoi.toCharArray()) {
			kyTuDuyNhat.add(kyTu);
		}
		int soKyTuDuyNhat = kyTuDuyNhat.size();

		// Lưu kết quả vào bộ nhớ cache
		ketQuaTruocDo.put(chuoi, soKyTuDuyNhat);
		kyTuDuyNhatTruocDo.put(chuoi, kyTuDuyNhat);

		return soKyTuDuyNhat;
	}

	// PT lay ket qua da tinh toan truoc do
	public Map<String, Integer> getKetQuaTruocDo() {
		return ketQuaTruocDo;
	}

	// Phương thức lấy các ký tự duy nhất đã tính toán trước đó
	public Map<String, Set<Character>> getKyTuDuyNhatTruocDo() {
		return kyTuDuyNhatTruocDo;
	}
}
