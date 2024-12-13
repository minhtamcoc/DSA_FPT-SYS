public class KhachHang {
    private String pcode;
    private String name;
    private String phone;
    public KhachHang(String pcode,String name,String phone){
        this.pcode=pcode;
        this.name=name;
        this.phone=phone;
    }
    public String getPcode(){
        return pcode;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return pcode+"/"+name+"/"+phone;
    }
}
