package datastructures.stack;

import entity.Voertuig;

/**
 * Created by abhoendie on 8/21/2017.
 */
public class StackLink {
    private StackLinkList reverseList;

    public StackLink() {
        reverseList = new StackLinkList();
    }

    public void push(Voertuig voertuig) {
        reverseList.insertLast(voertuig);
    }

    public Voertuig pop() {
        Voertuig voertuig = reverseList.deleteLast();
        if (voertuig.equals(null)){
            System.out.println("geen voertuig");
        }
        return voertuig;
    }

    public boolean isEmpty() {
        return (reverseList.isEmpty() );
    }

    public void displayStack() {
        System.out.print("stack : ");
        reverseList.displayList();
    }

    public void insertList(StackLinkList list){
        this.reverseList = list;
    }
}
