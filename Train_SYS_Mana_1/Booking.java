import java.sql.Date;
import java.util.*;;
public class Booking {
    private String bcode;// ma chuyen tau duoc dat;
    private String pcode;// ma khach hang
    private String odate;// ngay thanh toan
    private int paid;// trang thai thanh toan
    private int seat;// so luong ghe duoc dat
    public Booking(String bcode,String pcode,String odate,int paid,int seat){
        this.bcode=bcode;
        this.pcode=pcode;
        this.odate=odate;
        this.paid=paid;
        this.seat=seat;
    }
    public int getPaid(){
        return paid;
    }
    public void setPaided(){
        this.paid=1;
    }
    public String getBcode(){
        return bcode;
    }
    public String getPcode(){
        return pcode;
    }
    public String toString(){
        return bcode+" "+pcode+" "+odate+" "+paid+" "+seat;
    }
    public static Booking fromString(String str){
        String[] ss=str.split(" ");
        String bcode=ss[0];
        String pcode=ss[1];
        String odate=ss[2];
        int paid=Integer.parseInt(ss[3]);
        int seat=Integer.parseInt(ss[4]);
        return new Booking(bcode,pcode,odate,paid,seat);
    }
}
