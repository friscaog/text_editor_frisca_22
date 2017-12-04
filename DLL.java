package dll;
import java.util.*;
/**
 *
 * @author Frisca
 */
class Node{
    char kar;
    Node next, prev;
    // Constructor to create a new node
    public Node(char kar){
        this.kar = kar;
        next = null;
        prev = null;
    }
}

public class DLL {

    /**
     * @param args the command line arguments
     */
    Node head=null;
    Node hapus, temp, baru, lihat;
    int status = 0;
    
    public Node tambah(char k){
        baru = new Node(k);//masukkan k ke node baru
        if(head==null)
        {
            head = baru;
            temp = baru;
            baru.prev = null;
            baru.next = null;
        }
        else if(status==0)
        {
            baru.next = temp.next; //membuat null
            baru.prev = temp;
            temp.next = baru;
            temp = temp.next;
        }
        else if(status==1)
        {
            baru.next = temp;
            baru.prev = temp.prev;
            temp.prev = baru;
            lihat = baru.prev;
            if(lihat!=null)
                lihat.next = baru;
            else
                head = baru;
        }
        return null;    
    }
    
    public void cetak()
    {
        lihat = head;
        if(lihat==null)
            System.out.println("Data Kosong!");
        System.out.println("List: ");
        while(lihat!=null)
        {
            System.out.print(" "+lihat.kar);
            lihat = lihat.next;
        }
        System.out.println("");
    }
    
    public void hapus()
    {
        if(head!=null)
        {
            if(status==0)
            {
                hapus = temp;
                System.out.println("Karakter sudah dihapus" );
                if(hapus == head)
                {
                    temp = temp.next;
                    hapus = head;
                    head = hapus;
                    if(head != null)
                        head.prev = null;
                }
                else
                {
                    temp = temp.prev;
                    temp.next = hapus.next;
                    if(hapus.next != null)
                        hapus.next.prev = temp;
                }//di java tidak perlu free(hapus)
            }
            else if(temp != head)
            {
                hapus = temp.prev;
                System.out.println("Karakter sudah dihapus" );
                if(hapus.prev != null)
                {
                    hapus.prev.next = temp;
                    temp.prev = hapus.prev;
                }
                else
                {
                    temp.prev = null;
                    head = temp;
                }
            }
        }
    }
    
    public void pindahR()
    {
        if(status == 1)
            status = 0;
        else
            if(temp.next == null)
            {
                System.out.println("Linked list sudah paling kanan");;
            }
            else
                temp = temp.next;   
    }
    
    public void pindahL()
    {
        if(status == 0)
            status = 1; 
        else
            temp = temp.prev;
    }
    
    public static void main(String[] args) {
        DLL dll = new DLL();
        Scanner scan = new Scanner(System.in);
        int i=0;//increment sampai jumlah inputan
        System.out.println("Jumlah inputan: ");
        int n = scan.nextInt();
        
        while(i<n)
        {
            System.out.println("Menu: ");
            System.out.println("1. Add  2. Print  3. Delete");
            System.out.println("4. Shift R  5. Shift L  6. Exit");
            System.out.println("Your choice: ");
            int pil = scan.nextInt();
            if(pil==1)
            {
                System.out.println("Enter char: ");
                char k = scan.next().charAt(0);
                dll.tambah(k);
            }
            else if(pil==2)
                dll.cetak();
            else if(pil==3)
                dll.hapus();
            else if(pil==4)
                dll.pindahR();
            else if(pil==5)
                dll.pindahL();
            else if(pil==6)
                return;
            i++;
        }
        System.out.println("Jumlah inputan sudah maksimal");
        return;//return statement simply aborts execution of the current method
    }
}
