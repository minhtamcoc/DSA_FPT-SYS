import java.util.*;
import java.io.*;
public class Main {
    static  Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        LinkedLists<Train> list1=new LinkedLists<>();
        LinkedLists<KhachHang> lists2=new LinkedLists<>();
        LinkedLists<Booking> lists3=new LinkedLists<>();
        while(true){
            System.out.println("DANH SACH TAU: ");
            System.out.println("0.Thoat chuong trinh");
            System.out.println("1.1.Tai du lieu tu file trains.txt");
            System.out.println("1.2.Nhap them vao cuoi");
            System.out.println("1.3.Hien Thi Du Lieu");
            System.out.println("1.4.Luu danh sach tau vao file");
            System.out.println("1.5.Tim kiem theo ma tau");
            System.out.println("1.6.Xoa tau theo ma");
            System.out.println("1.7.Sap xep theo ma tau");
            System.out.println("1.8.Nhap them vao dau");
            System.out.println("1.9.Them truoc vi tri K(>=0)");
            System.out.println("1.10.Xoa vi tri thu K");
            System.out.println("1.11.Tim kiem theo ten");
            System.out.println("1.12 Tim kiem ghe da dat theo ma tau");
            System.out.println("DANH SACH HANH KHACK");
            System.out.println("2.1.Tai du lieu tu file acts.txt");
            System.out.println("2.2.Nhap them vao cuoi");
            System.out.println("2.3.Hien thi du lieu trong file acts.txt");
            System.out.println("2.4.Luu danh sach vao file acts.txt");
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
                System.out.println("------------------------END----------------------");
                    System.exit(0);
                    break;
                case "1.1":
                    System.out.println("Du lieu se duoc tai tu tep trains.txt");
                    list1=IOLinkedlist.readFromFile("trains.txt", Train::fromString);
                    System.out.println("-------------------------------------------------");
                    break;
                case "1.2":
                    System.out.println("Nhap du lieu moi");
                    System.out.print("tcode: ");
                    String tcode=sc.nextLine();
                    System.out.print("name: ");
                    String name=sc.nextLine();
                    System.out.print("dstation: ");
                    String dstation=sc.nextLine();
                    System.out.print("astation: ");
                    String astation=sc.nextLine();
                    System.out.print("dtime: ");
                    double dtime=sc.nextDouble();
                    System.out.print("seat: ");
                    int seat=sc.nextInt();
                    System.out.print("booked: ");
                    int booked=sc.nextInt();
                    System.out.print("atime: ");
                    double atime=sc.nextDouble();
                    Train res=new Train(tcode, name, dstation, astation, dtime, seat, booked, atime);
                    IOLinkedlist.addToFileAndList("trains.txt",list1,res);
                    System.out.println("-------------------------------------------------");
                    break;
                case "1.3":
                    System.out.println("Du lieu trong file trains.txt:");
                    list1.display();
                    System.out.println("-------------------------------------------------");
                    break;
                case "1.4":
                    IOLinkedlist.writeToFile("trains.txt",list1);
                    System.out.println("-------------------------------------------------");
                    break;
                case "1.5":
                    System.out.print("Nhap Ma Tau Can Tim Cua Ban: ");
                    String aim=sc.next();
                    Node<Train> tmp=list1.getHead();
                    int check=0;
                    while(tmp!=null){
                        if(tmp.data.getTcode().equals(aim)){
                            System.out.println("Co Tim Thay Tau Ma: "+aim);
                            check=1;
                            break;
                        }
                        tmp=tmp.next;
                    }
                    if(check==0) System.out.println("KHONG TIM THAY!!!!!!!!!!!");
                    System.out.println("-------------------------------------------------");
                    break;
                case "1.6":
                    System.out.print("Nhap Ma Tau Can Xoa: ");
                    String Txoa=sc.next();
                    Node<Train> idx=list1.getHead();
                    Node<Train> pre=null;
                    while(idx!=null){
                        if(idx.data.getTcode().equals(Txoa)){
                            if(pre==null){
                                list1.setHead(idx.next);
                            }
                            else{
                                pre.next=idx.next;
                            }
                            break;
                        }
                        pre=idx;
                        idx=idx.next;
                    }
                    System.out.println("Danh sach tau sau khi xoa: ");
                    list1.display();
                    System.out.println("-------------------------------------------------");
                    break;
                case "1.7":
                    list1.sapxepTCode();
                    System.out.println("-------------------------------------------------");
                    break;
                case "1.8":
                    System.out.println("Nhap Du Lieu Can Them Vao Dau: ");
                    System.out.print("tcode: ");
                    String t1=sc.next();
                    System.out.print("name: ");
                    String t2=sc.nextLine();
                    System.out.print("dstation: ");
                    String t3=sc.nextLine();
                    System.out.print("astation: ");
                    String t4=sc.nextLine();
                    System.out.print("dtime ");
                    double t5=sc.nextDouble();
                    System.out.print("seat: ");
                    int t6=sc.nextInt();
                    System.out.print("booked: ");
                    int t7=sc.nextInt();
                    System.out.print("atime: ");
                    double t8=sc.nextDouble();
                    Train cmp=new Train(t1,t2,t3,t4,t5,t6,t7,t8);
                    Node<Train> newHead=new Node<Train>(cmp);
                    list1.addHead(newHead);
                    System.out.println("-------------------------------------------------");
                    break;
                case "1.9":
                    System.out.print("Nhap Vi Tri Thu K Can Thêm: ");
                    int bla=sc.nextInt();
                    sc.nextLine();
                    System.out.println("Nhap Noi Dung Chuyen Tau Can Them: ");
                    System.out.print("tcode: ");
                    String t11=sc.nextLine();
                    System.out.print("name: ");
                    String t22=sc.nextLine();
                    System.out.print("dstation: ");
                    String t33=sc.nextLine();
                    System.out.print("astation: ");
                    String t44=sc.nextLine();
                    System.out.print("dtime ");
                    double t55=sc.nextDouble();
                    System.out.print("seat: ");
                    int t66=sc.nextInt();
                    System.out.print("booked: ");
                    int t77=sc.nextInt();
                    System.out.print("atime: ");
                    double t88=sc.nextDouble();
                    Train tam=new Train(t11,t22,t33,t44,t55,t66,t77,t88);
                    Node<Train> ntam=new Node<Train>(tam);
                    if(bla<=1){
                        ntam.next=list1.getHead();
                        list1.setHead(ntam);
                    }
                    else{
                        Node<Train> crr=list1.getHead();
                        int inn=1;
                        while(crr!=null&&inn<bla-1){
                            crr=crr.next;
                            inn++;
                        }
                        if(crr==null||crr.next==null){
                            System.out.println("K khong hop le");
                        }
                        else{
                            ntam.next=crr.next;
                            crr.next=ntam;
                        }
                    }
                    list1.display();
                    System.out.println("-------------------------------------------------");
                    break;
                case "1.11":
                        System.out.print("Nhap Ten Tau Can Tim Kiem: ");
                        String Fname=sc.next();
                        Node<Train> first=list1.getHead();
                        int check2=0;
                        while(first!=null){
                            if(first.data.getName().equals(Fname)){
                                System.out.println("CO TAU!!!!!!!");
                                check2=1;
                                break;
                            }
                            first=first.next;
                        }
                        if(check2==0) System.out.println("KHONG TIM THAY TEN TAU!!!");
                        System.out.println("-------------------------------------------------");
                          break;
                case "1.10":
                    System.out.println("Nhap Vi Tri Can Xoa");
                    int Kxoa=sc.nextInt();
                    sc.nextLine();
                    list1.xoavitrithuk(Kxoa);
                    System.out.println("-------------------------------------------------");
                     break;
                case "1.12":
                        System.out.print("Nhap Ma Tau Da Dat: ");
                        String k1=sc.next();
                        Node<Train> L1=list1.getHead();
                        int cnt=0;
                        while(L1!=null){
                            if(L1.data.getTcode().equals(k1)){
                                System.out.println("ID Tau Co Ton Tai ");
                                cnt++;
                                break;
                            }
                        }
                        if(cnt==0) System.out.println("Ma Tau Khong Ton Tai");
                        else{
                        System.out.println("Thong tin khach hang trong chuyen tau: ");
                        Node<Booking> L3=lists3.getHead();
                        while(L3!=null){
                            if(L3.data.getBcode().equals(k1)){
                                Node<KhachHang> L2=lists2.getHead();
                                while(L2!=null){
                                    if(L2.data.getPcode().equals(L3.data.getPcode())){
                                        System.out.println(L2.data);
                                    }
                                    L2=L2.next;
                                }
                            }
                            L3=L3.next;
                        }
                    }
                        System.out.println("--------------------------------------------------");
                          break;
                case "2.1":
                    System.out.println("Tai Du Lieu Tu File acts.txt");
                    lists2=IOLinkedlist.readFromFile("acts.txt",KhachHang::fromString);
                    System.out.println("--------------------------------------------------");
                          break;
                case "2.2":
                        System.out.println("Nhap Khach Hang Moi: ");
                        System.out.print("pcode: ");
                        String pcode=sc.nextLine();
                        System.out.print("Name: ");
                        String nameKH=sc.nextLine();
                        System.out.print("Phone: ");
                        String phone=sc.next();
                        KhachHang newMember=new KhachHang(pcode,nameKH,phone);
                        IOLinkedlist.addToFileAndList("acts",lists2,newMember);
                        System.out.println("-------------------------------------------------");
                        break;
                case "2.3":
                        System.out.println("Du Lieu Trong File acts.txt:");
                        lists2.display();
                        System.out.println("-------------------------------------------------");
                        break;
                case "2.4":
                        IOLinkedlist.writeToFile("acts.txt",lists2);
                        System.out.println("-------------------------------------------------");
                        break;
                case "2.5":
                        System.out.print("Nhap Ma Khach Hang Can Tim: ");
                        String Fkh=sc.next();
                        Node<KhachHang> first_list2=lists2.getHead();
                        int check3=0;
                        while(first_list2!=null){
                            if(first_list2.data.getPcode().equals(Fkh)){
                                System.out.println("Co Tim Thay!!!!!!!");
                                check3=1;
                                break;
                            }
                            first_list2=first_list2.next;
                        }
                        if(check3==0) System.out.println("Khong Tim Thay!!!!!!!!!");
                        System.out.println("-------------------------------------------------");
                        break;
                case "2.7":
                        System.out.print("Nhap Ten Khach Hang Can Tim: ");
                        String NKH=sc.nextLine();
                        Node<KhachHang> first_VNQA=lists2.getHead();
                        int check4=0;
                        while(first_VNQA!=null){
                            if(first_VNQA.data.getName().equals(NKH)){
                                System.out.println("Co Tim Thay!!!!!!!");
                                check4=1;
                                break;
                            }
                            first_VNQA=first_VNQA.next;
                        }
                        if(check4==0) System.out.println("Khong Tim Thay");
                        System.out.println("-------------------------------------------------");
                        break;
                case "2.6":
                        System.out.print("Nhap Ma Khach Hang Can Xoa: ");
                        String NTN=sc.next();
                        Node<KhachHang> ans=lists2.getHead();
                        Node<KhachHang> pre1=null;
                        while(ans!=null){
                            if(ans.data.getPcode().equals(NTN)){
                                if(pre1==null){
                                    lists2.setHead(ans.next);
                                }
                                else{
                                    pre1.next=ans.next;
                                }
                            }
                            pre1=ans;
                            ans=ans.next;
                        }
                        System.out.println("Danh sach khach hang sau khi xoa: ");
                        lists2.display();
                        System.out.println("-------------------------------------------------");
                        break;
                    case "2.8":
                        System.out.println("Nhap ma khach Hang: ");
                        String k2=sc.next();
                        Node<KhachHang> LoThon1=lists2.getHead();
                        int cnts=0;
                        while(LoThon1!=null){
                            if(LoThon1.data.getPcode().equals(k2)){
                                System.out.println("ID Khach hang co ton tai!");
                                cnts=1;
                                break;
                            }
                            LoThon1=LoThon1.next;
                        }
                        if(cnts==0){
                            System.out.println("ID Khach hang khong ton tai!");
                        }
                        else{
                            System.out.println("Danh Sach Cac Chuyen Tau Cua Khach Hang Nay La:");
                            Node<Booking> LoThon3=lists3.getHead();
                            while(LoThon3!=null){
                                if(LoThon3.data.getPcode().equals(k2)){
                                    Node<Train> LoThon2=list1.getHead();
                                    while(LoThon2!=null){
                                        if(LoThon2.data.getTcode().equals(LoThon3.data.getBcode())){
                                            System.out.println(LoThon2.data);
                                        }
                                        LoThon2=LoThon2.next;
                                    }
                                }
                                LoThon3=LoThon3.next;
                            }
                        }
                        System.out.println("-------------------------------------------------");
                        break;
                    case "3.1":
                        lists3=IOLinkedlist.readFromFile("bookings.txt", Booking::fromString);
                        System.out.println("-------------------------------------------------");
                        break;
                    case "3.2":
                        System.out.println("Thong Tin Dat Ve: ");
                        System.out.print("bcode: ");
                        String r1="";
                        while(true){
                            String c=sc.next();
                            Node<Train> f1=list1.getHead();
                            boolean check5=false;
                           while (f1!=null) {
                                if(f1.data.getTcode().equals(c)){
                                    r1=c;
                                    check5=true;
                                    break;
                                }
                                f1=f1.next;
                           }
                           if(check5) break;
                           System.out.println("ID Tau Khong Ton Tai! Hay Nhap Lai.");
                        }
                        System.out.print("pcode: "); // ma khach hang dat ve nhaaaaaaa
                        String r2;
                        while(true){
                            r2=sc.next();
                            boolean check6=false;
                            Node<KhachHang> l2_firt=lists2.getHead();
                            while(l2_firt!=null){
                                if(l2_firt.data.getPcode().equals(r2)){
                                    check6=true;
                                    break;
                                }
                                l2_firt=l2_firt.next;
                            }
                            if(check6) break;
                            System.out.println("ID Khach Hang Khong Ton Tai! Hay Nhap Lai.");
                        }
                        System.out.print("odate: ");
                        String odate=sc.next();
                        System.out.print("Trang Thai Thanh Toan(0-1): ");
                        int paid=sc.nextInt();
                        System.out.println("So Luong Ghe Duoc Dat: ");
                        int seat1=sc.nextInt();
                        Booking b=new Booking(r1,r2,odate,paid,seat1);
                        IOLinkedlist.addToFileAndList("bookings.txt",lists3,b);
                    case "3.3":
                        lists3.display();
                        System.out.println("-------------------------------------------------");
                        break;
                    case "3.4":
                        IOLinkedlist.writeToFile("bookings.txt", lists3);
                        System.out.println("-------------------------------------------------");
                        break;
                    case "3.5":
                         lists3.sapxeptheoBcode();
                         System.out.println("Sap xep theo Bcode: ");
                        lists3.display();
                        lists3.sapxeptheoPcode();
                        System.out.println("Sap xep theo Pcode: ");
                        lists3.display();
                         System.out.println("-------------------------------------------------");
                         break;
                    case "3.6":
                        System.out.println("Nhap Thong Tin Cua Lan Dat Ve: ");
                        System.out.print("bcode: ");
                        String rk=sc.next();
                        System.out.print("pcode: ");
                        String kh=sc.next();
                        Node<Booking> o=lists3.getHead();
                        while(o!=null){
                            if(o.data.getBcode().equals(rk)&&o.data.getPcode().equals(kh)){
                                if(o.data.getPaid()==0){
                                    o.data.setPaided();
                                }
                            }
                            o=o.next;
                        }
                        lists3.display();
                        System.out.println("-------------------------------------------------");
                        break;
            }
        }
    }
}
