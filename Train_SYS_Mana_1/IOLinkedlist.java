import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
public class IOLinkedlist {
    public static <T> LinkedLists<T> readFromFile(String filename,Function<String, T>fromString) {
        LinkedLists<T> list=new LinkedLists<>();
        try (BufferedReader br=new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line=br.readLine())!=null) {
                T obj=fromString.apply(line);
                list.add(obj);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static <T> void writeToFile(String filename, LinkedLists<T> list) {
        try (BufferedWriter bw =new BufferedWriter(new FileWriter(filename))) {
            Node<T> temp=list.getHead();
            while (temp!=null) {
                bw.write(temp.data.toString());
                bw.newLine();
                temp = temp.next;
            }
            System.out.println("Danh Sach Duoc Luu Thanh Cong");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e);
        }
    }
    public static <T> void addToFileAndList(String filename,LinkedLists<T> list,T obj) {
        list.add(obj);
        try (BufferedWriter bw =new BufferedWriter(new FileWriter(filename,true))) {
            bw.write(obj.toString());
            bw.newLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
