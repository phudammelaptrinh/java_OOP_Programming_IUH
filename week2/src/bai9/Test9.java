package bai9;

import java.util.Scanner;

public class Test9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Nhập số lượng công nhân = ");
		int n = sc.nextInt();
		DanhSachCongNhan ds = new DanhSachCongNhan(n);
		int i = 0;
		while(i< n) {
			sc.nextLine();
			System.out.print("Nhập họ công nhân :");
			String ho = sc.nextLine();
			System.out.print("Nhập tên công nhân :  ");
			String ten = sc.nextLine();
			System.out.print("Nhập số sản phẩm :" );
			int soSP = sc.nextInt();
			CongNhan cn = new CongNhan(ho,ten,soSP);
			if(ds.them(cn)) {
				System.out.println("Thêm công nhân thành công");
			}
			else {
				System.out.println("Không thể thêm công  nhân !");
			}
		i++;
		}
		
		while(true) {
			System.out.println("Menu : ");
			System.out.println("1.Xuất thông tin tất cả công nhân :  ");
			System.out.println("2.Số lượng công nhân : ");
			System.out.println("3.Xuất thông tin công nhân làm trên 200 sản phẩm :  ");
			System.out.println("4.Sắp xếp công nhân theo số sản phẩm giảm dần");
			System.out.println("5.Thoát");
			System.out.println("Chọn chức năng :  ");
			int chon = sc.nextInt();
			switch(chon) {
				case 1 :
				ds.xuatThongTinALL();
				break;
				case 2 : 
				System.out.print("Số lượng công nhân"+ ds.soLuongCongNhan());
				break;
				case 3 : 
				ds.xuatCN200SP();
				break;
				case 4 : 
				ds.sapXepTheoSoSPGiamDan();
				System.out.println("Đã sắp xếp công nhân theo sản phẩm giảm dần!");
				break;
				case 5 : 
				System.out.println("Thoát chương trình !");
				break;
				default:
					System.out.println("Chức năng không hợp lệ ! Vui lòng chọn lại !");
			}
			
		}
	}
	

}
