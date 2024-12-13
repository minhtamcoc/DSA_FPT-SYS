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
    public int  getSoTau(){
        String re=tcode.substring(1);
        return Integer.parseInt(re);
    }
    public String toString(){
        return tcode+"/"+name+"/"+dstation+"/"+astation+"/"+dtime+"/"+atime+"/"+seat+"/"+booked;
    }
}