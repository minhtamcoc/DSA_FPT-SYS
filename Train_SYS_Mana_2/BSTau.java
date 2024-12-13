import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;
public class BSTau {    
    private  NodeTau root;
    private int sotau;
    static Train[] a;
    static int n;
    private NodeTau Insert(NodeTau tmp,Train x){// them node vao cay
        if(tmp==null){
            return new NodeTau(x);
        }
        if(x.getSoTau()<tmp.data.getSoTau()){
            tmp.left=Insert(tmp.left,x);
        }
        else tmp.right=Insert(tmp.right,x);
        return tmp;
    }
    public void AddNode(Train x){
        root=Insert(root,x);
    }
    private void Pre_oder(NodeTau node){
        if(node!=null){
            System.out.println(node.data.toString());
            Pre_oder(node.left);
            Pre_oder(node.right);
        }
    }
    public void duyetgiua(){
        In_Oder(root);
    }
    public void duyettruoc(){
        Pre_oder(root);
    }
    public Train TimKiemTheoMaTau(String tcode){ // ket qua tra ve Tau
        NodeTau tmp;
        Queue<NodeTau> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            NodeTau k=q.peek();
            q.poll();
            if(k.data.getTcode().equals(tcode)){
                tmp=k;
                return k.data;
            }
            if(k.left!=null) q.add(k.left);
            if(k.right!=null) q.add(k.right);
        }
        return null;
    }
    public void LuuFileTheoIN_order(String fname){
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(fname));
            saveIn_order(root,w);
            w.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    private void saveIn_order(NodeTau node,BufferedWriter w) throws IOException{
        if(node!=null){
            saveIn_order(node.left,w);
            w.write(node.data.toString());
            w.newLine();
            saveIn_order(node.right,w);
        }
    }
    public void HienThiTauTheoBreadth_first(){  
        Queue<NodeTau> q=new LinkedList<>();
        q.add(root);
         while(!q.isEmpty()){
            NodeTau tmp=q.peek();
            q.poll();
            System.out.println(tmp.data);
            if(tmp.left!=null) q.add(tmp.left);
            if(tmp.right!=null) q.add(tmp.right);
         }
    } 
    public NodeTau docFile(String fname){
        try{
            BufferedReader r=new BufferedReader(new FileReader(fname));
            String line;
            while((line=r.readLine())!=null){
                String[] ss= line.split("/");
                String tcode=ss[0];
                String name=ss[1];
                String dstation=ss[2];
                String astation=ss[3];
                double dtime=Double.parseDouble(ss[4]);
                double atime=Double.parseDouble(ss[5]);
                int seat=Integer.parseInt(ss[6]);
                int booked=Integer.parseInt(ss[7]);
                Train tmp=new Train(tcode, name, dstation, astation, dtime, seat, booked, atime);
                AddNode(tmp);
            }
        } catch(IOException e){
            System.out.println(e);
        }
        return root;
    }
    private void Balance(int l,int r){
        if(l>r) return;
        int mid=(l+r)/2;
        AddNode(a[mid]);
        Balance(l,mid-1); 
        Balance(mid+1,r);
    }
    private void In_Oder(NodeTau node){
        if(node!=null){
             In_Oder(node.left);
             a[n++]=node.data;
            In_Oder(node.right);
        }
    }
    public void CanBang(){
        a=new Train[100];
        n=0;
        In_Oder(root);// sao chep
        root=null;
        Balance(0,n-1);
    }
    private void Post_Oder(NodeTau node){
        if(node!=null){
            Post_Oder(node.left);
            Post_Oder(node.right);
            sotau++;

        }
    }
    public int getSoTau(){
        sotau=0;
        Post_Oder(root);
        return sotau;
    }
    public Train TimKiemTheoTen(String name){
        Queue<NodeTau> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            NodeTau tmp=q.peek();
            q.poll();
            if(tmp.data.getName().equals(name)){
                return tmp.data;
            }
            if(tmp.left!=null) q.add(tmp.left);
            if(tmp.right!=null) q.add(tmp.right);
        }
        return null;
    }
    private NodeTau minNodeP(NodeTau node){
        while(node.left!=null){
            node=node.left;
        }
        return node;
    }
    private NodeTau XoaTheoTcodeBYCopy(String s,NodeTau node){
        if(node==null){
            return null;
        }
        // tim kiem tcode
        if(s.compareTo(node.data.getTcode())<0){// tim sang ben trai
            node.left=XoaTheoTcodeBYCopy(s,node.left);
        }
        else if(s.compareTo(node.data.getTcode())>0){ //tim sang ben phai
            node.right=XoaTheoTcodeBYCopy(s,node.right);
        }
        else {// tim thay
            if(node.left==null&&node.right==null){
                return null;
            }
            else if(node.left==null){
                return node.right;
            }
            else if(node.right==null){
                return node.left;
            }
            else{
                NodeTau min=minNodeP(node.right);// tim root nho nhat 
                node.data=min.data;// sao chep
                node.right=XoaTheoTcodeBYCopy(node.data.getTcode(),node.right);
            }
        }
        return node;
    }
    public void Xoa1(String s){
        root=XoaTheoTcodeBYCopy(s,root);
    }
    private NodeTau XoaTauTcodeBYMerge(String s,NodeTau node){
        if(node==null){
            return null;
        }
        if(s.compareTo(node.data.getTcode())<0){
            node.left=XoaTauTcodeBYMerge(s,node.left);
        }
        else if(s.compareTo(node.data.getTcode())>0){
            node.right=XoaTauTcodeBYMerge(s,node.right);
        }
        else{
            if(node.left==null&&node.right==null){
                return null;
            }
            else if(node.left==null){
                return node.right;
            }
            else if(node.right==null){
                return node.left;
            }
            else{
                NodeTau tmp=node.left;
                while(tmp.right!=null){
                    tmp=tmp.right;
                }
                tmp.right=node.right;
            }
            return node.left;
        }
        return node;
    }
    public void Xoa2(String s){
        root=XoaTauTcodeBYMerge(s,root);
    }
}