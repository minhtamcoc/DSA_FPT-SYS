// ma tau (Txx) khong theo thu tu
//ma khach hang(KHxx) khong theo thu tu
// ma tau la dieu kien de xay cay nhi phan
// ma khach ha la dieu kien de xay cay nhi phan
import java.util.*;
import java.io.*;
public class Main {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args) {
       BSTau root1=new BSTau();
       BSKhach root2=new BSKhach();
        while(true){
            System.out.println("DANH SACH TAU: ");
            System.out.println("0.Thoat chuong trinh");
            System.out.println("1.1.Tai du lieu tu file trains.txt");
            System.out.println("1.2.Nhap du lieu va them vao cay");
            System.out.println("1.3.Hien thi du lieu theo pre-order");
            System.out.println("1.4.Luu danh sach tau vao file trainx.txt theo in-order");
            System.out.println("1.5.Tim kiem theo tcode");
            System.out.println("1.6.Xoa theo tcode bang sao chep");
            System.out.println("1.7.Xoa theo tcode bang ghep");
            System.out.println("1.8.Can bang cay");
            System.out.println("1.9.Hien thi du lieu theo breadth-first");
            System.out.println("1.10.Dem so tau");
            System.out.println("1.11.Tim kiem theo ten tau");
            System.out.println("1.12 Tim kiem ghe da dat theo ma tau");
            System.out.println("DANH SACH HANH KHACh");
            System.out.println("2.1.Tai du lieu tu file acts.txt");
            System.out.println("2.2.Nhap Du Lieu Va Them Vao Cay");
            System.out.println("2.3.Hien thi du lieu bang Post_Order");
            System.out.println("2.4.Luu danh sach khach Hang vao file acts.txt duoi dang Pre_Oder");
            System.out.println("2.5.Tim kiem theo pcode");
            System.out.println("2.6.Xoa theo pcode");
            System.out.println("2.7.Tim kiem theo ten");
            System.out.println("2.8.Tim kiem tau theo pcode");
            System.out.println("DANH SACH DAT CHO");
            System.out.println("3.1.Tai du lieu tu tep bookings.txt");
            System.out.println("3.2.Dat Tau");
            System.out.println("3.3.Hien thi trong file booking.txt");
            System.out.println("3.4.Luu File booking.txt");
            System.out.println("3.5.Sap xep theo Bcode , Pcode");
            System.out.println("3.6.Thanh toan");
            String chon;
            System.out.print("Nhap Lua Chon Cua Ban Co Trong Menu: ");
            chon=sc.next();
            sc.nextLine();
            switch (chon) {
                case "0":
                    System.exit(0);
                    System.out.println("------------------------END----------------------");
                    break;
                case "1.1":
                    root1.docFile("trains.txt");
                    System.out.println("------------------------------------------------");
                    break;
                case "1.2":
                    System.out.println("Nhap Du Lieu Tau:");
                    System.out.print("Tcode: ");
                    String tcode=sc.nextLine();
                    System.out.print("Name: ");
                    String name=sc.nextLine();
                    System.out.print("Dstation: ");
                    String dstation=sc.nextLine();
                    System.out.print("Astation: ");
                    String astation=sc.nextLine();
                    System.out.print("Dtime: ");
                    double dtime=sc.nextDouble();
                    System.out.print("Seat: ");
                    int seat=sc.nextInt();
                    System.out.print("Booked: ");
                    int booked=sc.nextInt();
                    System.out.print("Atime: ");
                    double atime=sc.nextDouble();
                    sc.nextLine();
                    Train tau1=new Train(tcode,name,dstation,astation,dtime,seat,booked,atime);
                    root1.AddNode(tau1);
                    System.out.println("------------------------------------------------");
                    break;
                case "1.3":
                    root1.duyettruoc();
                    System.out.println("------------------------------------------------");
                    break;
                case "1.4":
                    root1.LuuFileTheoIN_order("trains.txt");
                    System.out.println("------------------------------------------------");
                    break;
                case "1.5":
                    System.out.print("Nhap Ma Tau Can Tim: ");
                    String s=sc.nextLine();
                    Train t1=root1.TimKiemTheoMaTau(s);
                    if(t1==null) System.out.println("Ma Tau Khong Ton Tai!!!!");
                    else {
                    System.out.print("Thong Tin Ve Tau Can Tim: ");
                    System.out.println(t1);
                    }
                    System.out.println("------------------------------------------------");
                    break;
                case "1.6":
                    System.out.print("Nhap Ma Tau Can Xoa: ");
                    String s3=sc.nextLine();
                    root1.Xoa1(s3);
                    System.out.println("-------------------------------------------------");
                    break;
                case "1.7":
                    System.out.print("Nhap Ma Tau Can Xoa: ");
                    String s4=sc.nextLine();
                    root1.Xoa2(s4);
                    System.out.println("----------------------------------------------------");
                    break;
                case "1.8":
                    root1.CanBang();
                    System.out.println("--------------------------------------------------");
                    break;
                case "1.9":
                    root1.HienThiTauTheoBreadth_first();
                    System.out.println("------------------------------------------------");
                    break;
                case "1.10":
                    System.out.println("So Tau: "+root1.getSoTau());
                    System.out.println("--------------------------------------------------");
                    break;
                case "1.11":
                    System.out.print("Nhap Ten Tau Can Tim: ");
                    String s1=sc.nextLine();
                    Train t2=root1.TimKiemTheoTen(s1);
                    if(t2==null) System.out.println("Ten Tau Khong Ton Tai");
                    else{
                        System.out.print("Thong Tin Ve Tau Do:");
                        System.out.println(t2);
                    }
                    System.out.println("--------------------------------------------------");
                    break;
                case "1.12":
                    System.out.println("----------------------------------------------------");
                    break;
                case "2.1":
                    root2.DocFile("acts.txt");
                    System.out.println("-----------------------------------------------------");
                    break;
                case "2.2":
                    System.out.print("Pcode: ");
                    String pcode=sc.nextLine();
                    System.out.print("Name: ");
                    String name1=sc.nextLine();
                    System.out.print("Phone: ");
                    String phone=sc.nextLine();
                    KhachHang ans=new KhachHang(pcode,name1,phone);
                    root2.AddNode(ans);
                    System.out.println("-------------------------------------------------------");
                    break;
                case "2.3":
                    root2.duyetsau();
                    System.out.println("-------------------------------------------------------");
                    break;
                case "2.4":
                    root2.LuuFile("acts.txt");
                    System.out.println("---------------------------------------------------------");
                    break;
                case "2.5":
                    System.out.print("Nhap Ma Khach Hang: ");
                    String s5=sc.nextLine();
                    KhachHang x=root2.SearchPcode(s5);
                    if(x==null) System.out.println("Khong Ton Tai Ma");
                    else{
                        System.out.println("Thong Tin Khach Hang: "+x);
                    }
                    System.out.println("----------------------------------------------------------");
                    break;
                case "2.6":
                    System.out.print("Nhap Ten Khach Hang: ");
                    String Thon=sc.nextLine();
                    root2.Sname(Thon);
                    System.out.println("----------------------------------------------------------");
                    break;
                case "2.7":
                    System.out.print("Nhap Ma Khach Hang Can Xoa: ");
                    String s6=sc.nextLine();
                    root2.XoaPcode(s6);
                    System.out.println("------------------------------------------------------------");
                    break;
    }
}
}
}