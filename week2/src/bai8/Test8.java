package bai8;
import java.util.Scanner;
public class Test8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		CDList cdlist = new CDList(5);
		
		while(true) {
			System.out.println("Menu:");
			System.out.println("1.Thêm CD vào danh sách: ");
			System.out.println("2.Số lượng CD trong danh sách");
			System.out.println("3.Tổng giá thành của các CD");
			System.out.println("4.Thông tin tất cả các CD");
			System.out.println("5.Sắp xếp danh sách theo tựa CD");
			System.out.println("6.Thoát");
			System.out.println("-------------0--------------");
			
			int choice= sc.nextInt();
			switch(choice) {
			 case 1:
                 System.out.print("Nhập mã CD: ");
                 int maCD = sc.nextInt();
                 sc.nextLine(); // Consume newline
                 System.out.print("Nhập tựa CD: ");
                 String tuaCD = sc.nextLine();
                 System.out.print("Nhập số bài hát: ");
                 int soBaiHat = sc.nextInt();
                 System.out.print("Nhập giá thành: ");
                 double giaThanh = sc.nextDouble();
                 CD cd = new CD(maCD, tuaCD, soBaiHat, giaThanh);
                 if (cdlist.themCD(cd)) {
                     System.out.println("Thêm CD thành công!");
                 } else {
                     System.out.println("Thêm CD thất bại. Mã CD đã tồn tại hoặc danh sách đầy.");
                 }
                 break;
             case 2:
                 System.out.println("Số lượng CD trong danh sách: " + cdlist.soLuongCD());
                 break;
             case 3:
                 System.out.println("Tổng giá thành của các CD: " + cdlist.tongGiaThanh());
                 break;
             case 4:
                 System.out.println("Thông tin tất cả CD:");
                 System.out.println(cdlist.thongTinTatCaCD());
                 break;
             case 5:
                 cdlist.sapXepTheoTuaCD();
                 System.out.println("Danh sách đã được sắp xếp theo tựa CD.");
                 break;
             case 6:
                 System.out.println("Thoát chương trình.");
                 sc.close();
                 System.exit(0);
                 break;
             default:
                 System.out.println("Chức năng không hợp lệ. Vui lòng chọn lại.");
			}
		}
	}

}
