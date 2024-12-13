import java.util.*;
public class Train {
    private String tcode;// ma tau
    private String name;
    private String dstation;// ga tau khoi hanh
    private String astation;// ga tau cap ben;
    private double dtime;// h khoi hanh
    private int seat;// so luong cho ngoi
    private int booked;// so luong ghe da duoc dat
    private double atime;// h tau den
    public Train(String tcode,String name,String dstation,String astation,double dtime,int seat,int booked,double atime){
        this.tcode=tcode;
        this.name=name;
        this.dstation=dstation;
        this.astation=astation;
        this.dtime=dtime;
        this.seat=seat;
        this.booked=booked;
        this.atime=atime;
    }
    public String getTcode(){
        return tcode;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return tcode+"/"+name+"/"+dstation+"/"+astation+"/"+dtime+"/"+atime+"/"+seat+"/"+booked;
    }
    public static Train fromString(String str) {
      String parts[]= str.split("/");
      String tcode = parts[0];               
    String name = parts[1];                 
    String dstation = parts[2];             
    String astation = parts[3];            
    double dtime = Double.parseDouble(parts[4]);  
    double atime = Double.parseDouble(parts[5]);  
    int seat = Integer.parseInt(parts[6]); 
    int booked = Integer.parseInt(parts[7]);
    return new Train(tcode,name,dstation,astation,dtime,seat,booked,atime);
    }
    
}