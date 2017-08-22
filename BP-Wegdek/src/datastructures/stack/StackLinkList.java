package datastructures.stack;

import datastructures.link.VoertuigLink;
import entity.Voertuig;

/**
 * Created by abhoendie on 8/21/2017.
 */
public class StackLinkList {

    private VoertuigLink first;

    public StackLinkList() {
        this.first = null;
    }

    public VoertuigLink getFirst() {
        return first;
    }

    public void setFirst(VoertuigLink first) {
        this.first = first;
    }

    public boolean isEmpty() {
        return (first == null);
    }

    public void insertFirst(Voertuig voertuig) {

        VoertuigLink newLink = new VoertuigLink(voertuig);
        newLink.setNext(first);
        first = newLink;
    }

    public void insertLast(Voertuig voertuig){
        VoertuigLink current = first;
        VoertuigLink next = null;
        VoertuigLink newLink = new VoertuigLink(voertuig);

        if (current == null) {
            first = newLink;
        } else if (current.getNext() != null) {
            next = current.getNext();
            while (next.getNext() != null) {
                current = next;
                next = current.getNext();

            }
            next.setNext(newLink);
        }else {
            first.setNext(newLink);

        }
    }

    public void insert(Voertuig voertuig) {
        VoertuigLink newLink = new VoertuigLink(voertuig);
        VoertuigLink previous = null;
        VoertuigLink current = first;

        while (current != null && voertuig.getPrioriteit() >= current.getVoertuigData().getPrioriteit()) {
            previous = current;
            current = current.getNext();
        }
        if (previous == null) {
            newLink.setNext(first);
            first = newLink;
        } else {
            previous.setNext(newLink);
            newLink.setNext(current);
        }
    }

    public Voertuig deleteFirst() {
        if (isEmpty()) {

            System.out.println("Lijst is leeg");
            return null;

        } else {
            VoertuigLink temp = first;
            first = first.getNext();
            return temp.getVoertuigData();
        }
    }

    public Voertuig deleteLast() {

        VoertuigLink current = first;
        VoertuigLink next = null;

        if (isEmpty()) {

            System.out.println("Lijst is leeg");
            return null;
        } else if (current.getNext() != null) {
            next = current.getNext();
            while (next.getNext() != null) {
                current = next;
                next = current.getNext();

            }
            current.setNext(null);
            return next.getVoertuigData();
        }else {
            next = first;
            first = null;
            return next.getVoertuigData();
        }
    }

    public void displayList() {
        VoertuigLink current = first;
        while (current != null) {
            current.displayVoertuigLink();
            current = current.getNext();
        }
        System.out.println("");
    }

    public int getCount() {
        VoertuigLink temp = first;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

}
