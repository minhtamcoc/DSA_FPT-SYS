import java.util.*;
import java.io.*;
public class BSKhach {
    private NodeKH root;
    private NodeKH Insert(KhachHang k,NodeKH node){
        if(node==null){
            return new NodeKH(k);
        }
        if(node.data.getPcode().compareTo(k.getPcode())>0){
            node.left=Insert(k,node.left);
        }
        else node.right=Insert(k,node.right);
        return node;
    }
    public void AddNode(KhachHang k){
        root=Insert(k,root);
    }
    private void Post_Oder(NodeKH node){
        if(node!=null){
            Post_Oder(node.left);
            Post_Oder(node.right);
            System.out.println(node.data.toString());
        }
    }
    public void duyetsau(){
        Post_Oder(root);
    }
    public void LuuFile(String fname){
        try{
            BufferedWriter w=new BufferedWriter(new FileWriter(fname));
            savePre_Order(root, w);
            w.close();
        }catch(IOException e){
            System.out.println(e);
        }
    }
    private void savePre_Order(NodeKH node,BufferedWriter w) throws IOException{
       if(node!=null){
        w.write(node.data.toString());
        w.newLine();
        savePre_Order(node.left,w);
        savePre_Order(node.right,w);
       }
    }
    public NodeKH DocFile(String fname){
        try{
            BufferedReader r=new BufferedReader(new FileReader(fname));
            String line;
            while((line=r.readLine())!=null){
                String[] ss=line.split("/");
                String pcode=ss[0];
                String name=ss[1];
                String phone=ss[2];
                KhachHang tmp=new KhachHang(pcode,name,phone);
                AddNode(tmp);
            }
        }catch(IOException e){
            System.out.println(e);
        }
        return root;
    }
    public KhachHang SearchPcode(String pcode){
        Queue<NodeKH> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            NodeKH tmp=q.peek();
            q.poll();
            if(tmp.data.getPcode().equals(pcode)){
                return tmp.data;
            }
            if(tmp.left!=null) q.add(tmp.left);
            if(tmp.right!=null) q.add(tmp.right);
        }
        return null;
    }
    private void SearchName(String name,NodeKH root){
        if(root!=null){
            SearchName(name,root.left);
            if(root.data.getName().endsWith(name)) System.out.println(root.data);
            SearchName(name, root.right);
        }
    }
    public void Sname(String name){
        SearchName(name,root);
    }
    private NodeKH xoaTheoPcode(String s,NodeKH node){
        if(node==null){
            return null;
        }
        if(s.compareTo(node.data.getPcode())<0){
            node.left=xoaTheoPcode(s,node.left);
        }
        else if(s.compareTo(node.data.getPcode())>0){
            node.right=xoaTheoPcode(s,node.right);
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
                NodeKH tmp=node.left;
                while(tmp.right!=null){
                    tmp=tmp.right;
                }
                tmp.right=node.right;
                return node.left;
            }
        }
        return node;
    }
    public void XoaPcode(String pcode){
        root=xoaTheoPcode(pcode,root);
    }
}
