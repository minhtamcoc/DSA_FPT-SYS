public class LinkedLists<T> {
    private Node<T> head;
    public LinkedLists() {
        this.head=null;
    }
    public void add(T data) {
        Node<T> newNode = new Node<>(data);
        if (head==null) {
            head=newNode;
        } else {
            Node<T> temp=head;
            while (temp.next != null) {
                temp=temp.next;
            }
            temp.next=newNode;
        }
    }
    public void display() {
        Node<T> temp=head;
        while (temp!=null) {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
    public Node<T> getHead() {
        return head;
    }
    public void setHead(Node<T> head){
        this.head=head;
    }
    public void sapxepTCode(){ // sap xep chon
        if(head==null) return;
        Node<T> tmp=head;
        while(tmp!=null){
            Node<T> i=tmp;
            Node<T> j=tmp.next;
            while(j!=null){
                if(((Train) j.data).getTcode().compareTo(((Train) i.data).getTcode())<0){
                    i=j;
                }
                j=j.next;
            }
            if(i!=tmp){
                T temp=tmp.data;
                tmp.data=i.data;
                i.data=temp;
            }
            tmp=tmp.next;
        }
    }
    public void sapxeptheoBcode(){
        if(head==null) return;
        Node<T> tmp=head;
        while(tmp!=null){
            Node<T> i=tmp;
            Node<T> j=tmp.next;
            while(j!=null){
                if(((Booking) j.data).getBcode().compareTo(((Booking) i.data).getBcode())>0){
                    i=j;
                }
                j=j.next;
            }
            if(i!=tmp){
                T temp=tmp.data;
                tmp.data=i.data;
                i.data=temp;
            }
            tmp=tmp.next;
        }
    }
    public void sapxeptheoPcode(){
        if(head==null) return;
        Node<T> tmp=head;
        while(tmp!=null){
            Node<T> i=tmp;
            Node<T> j=tmp.next;
            while(j!=null){
                if(((Booking) j.data).getPcode().compareTo(((Booking) i.data).getPcode())>0){
                    i=j;
                }
                j=j.next;
            }
            if(i!=tmp){
                T temp=tmp.data;
                tmp.data=i.data;
                i.data=temp;
            }
            tmp=tmp.next;
        }
    }
    public void addHead(Node<T> newHead){
            if(head==null) return;
            newHead.next=head;
            head=newHead;
    }
    public void xoavitrithuk(int k){
        if(k<0||head==null){
            System.out.println("Vi tri KHong ton tai");
            return;
        }
        if(k==1){
            head=head.next;
            return;
        }
        Node<T> cur=head;
        for(int i=0;cur!=null&&i<k-1;i++){
            cur=cur.next;
        }
        if(cur==null){
            System.out.println("Vi tri KHong ton tai");
            return;
        }
        cur.next=cur.next.next; 
    }
}