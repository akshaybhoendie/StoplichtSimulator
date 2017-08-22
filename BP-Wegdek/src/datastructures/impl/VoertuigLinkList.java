package datastructures.impl;

import datastructures.link.VoertuigLink;
import entity.Voertuig;

/**
 * Created by abhoendie on 8/13/2017.
 */
public class VoertuigLinkList{

    private VoertuigLink first;
    private VoertuigLink last;

    public VoertuigLinkList() {
        first = null;
        last = null;
    }

    public boolean isEmpty() {
        return first==null;
    }

    public void insert(Voertuig voertuigData) {
        VoertuigLink newNode = new VoertuigLink(voertuigData);
        VoertuigLink previous = null;
        VoertuigLink current = first;

        while (current != null && voertuigData.getPrioriteit() >= current.getVoertuigData().getPrioriteit()) {
            previous = current;
            current = current.getNext();
        }

        if (previous == null) {
            newNode.setNext(first);
            first = newNode;
        }

        else {
            previous.setNext(newNode);
            newNode.setNext(current);
        }
    }

    public void insertLast(Voertuig voertuig) {
        VoertuigLink newLink = new VoertuigLink(voertuig);
        if( isEmpty() )
            first = newLink;
        else
            last.setNext(newLink);
        last = newLink;

    }

    public Voertuig deleteFirst() {
        Voertuig temp = first.getVoertuigData();
        if(first.getNext() == null)
            last = null;
        first = first.getNext();
        return temp;
    }

    public void displayList() {
        VoertuigLink current = first;
        while(current != null)
        {
            current.displayVoertuigLink();
            current = current.getNext();
        }
        System.out.println("");
    }

    // length van linked list!
    public int getCount(){
        VoertuigLink temp = first;
        int count = 0;
        while (temp != null)
        {
            count++;
            temp = temp.getNext();
        }
        return count;
    }

    public VoertuigLink peekFirst(){
        if(first != null){
            return first;
        }else{
            return null;
        }
    }

    public VoertuigLink peekLast(){
        if(last != null){
            return last;
        }else{
            return null;
        }
    }

    //=========== Que reversal ==============
    public VoertuigLink reverse(VoertuigLink voertuigLink){
        if(voertuigLink == null){
            return null;
        }
        if(voertuigLink.getNext() == null){
            return voertuigLink;
        }
        VoertuigLink ret = reverse(voertuigLink.getNext());
        voertuigLink.getNext().getNext().setNext(voertuigLink);
        voertuigLink.setNext(null);
        return ret;
    }

    public void reverse(){
        reverse(this.peekFirst());
    }
}
