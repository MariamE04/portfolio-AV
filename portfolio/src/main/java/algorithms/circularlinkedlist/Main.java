package algorithms.circularlinkedlist;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node list = ListFactory.buildList(1, 2, 3, 4, 5);
       if(!hasCircle(list))
        System.out.println(list);

       Node circularList = ListFactory.buildListWithCycle();
         //if(!hasCircle(circularList))
        System.out.println(circularList);
    }

    public static boolean hasCircle(Node head){
        Node slow = head;
        Node fast = head;

        if(head == null || head.next == null) return false;

        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
        return false;
    }
}
