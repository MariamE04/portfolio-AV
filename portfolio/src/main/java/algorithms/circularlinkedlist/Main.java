package algorithms.circularlinkedlist;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Node list = ListFactory.buildList(1, 2, 3, 4, 5);
        if(!hasCircle(list))
        System.out.println(list);

       Node circularList = ListFactory.buildListWithCycle();
         if(!hasCircle(circularList))
        System.out.println(circularList);
    }

    public static boolean hasCircle(Node head){
        // slow går 1 skridt, fast går 2 skridt
        Node slow = head;
        Node fast = head;

        // hvis listen er tom eller kun 1 element → ingen cyklus
        if(head == null || head.next == null) return false;

        // vi fortsætter så længe fast kan bevæge sig
        while(fast != null && fast.next != null){
            slow = slow.next;          // 1 skridt
            fast = fast.next.next;     // 2 skridt

            // hvis de mødes → cyklus fundet
            if(slow == fast) return true;
        }

        // hvis vi rammer enden → ingen cyklus
        return false;
    }
}
