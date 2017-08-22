package datastructures.linkQue;

import datastructures.impl.VoertuigLinkList;
import datastructures.link.VoertuigLink;
import entity.Voertuig;

/**
 * Created by abhoendie on 8/19/2017.
 */
public class VoertuigLinkQue {

    private VoertuigLinkList theList;

    public VoertuigLinkQue() {
        theList = new VoertuigLinkList();
    }

    public VoertuigLinkQue(VoertuigLinkList theList) {
        this.theList = theList;
    }

    // true if queue is empty
    public boolean isEmpty(){ return theList.isEmpty(); }

    public void insert(Voertuig voertuig){
        theList.insert(voertuig);
    }

    public void insertVoertuigLinkList(VoertuigLinkList voertuigLinkList){
        theList = voertuigLinkList;
    }

    public int getCount(){
        return theList.getCount();
    }

    // remove, front of queue
    public Voertuig remove() {
        return theList.deleteFirst(); }
    //--------------------------------------------------------------
    public void displayQueue() {
        System.out.print("Queue (front-->rear): ");
        theList.displayList();
    }

    public Voertuig peekFirst(){
        if(theList.peekFirst()!= null){
            return theList.peekFirst().getVoertuigData();
        }else {
            return null;
        }
    }

    public Voertuig peekLast(){
        if(theList.peekLast()!= null){
            return theList.peekLast().getVoertuigData();
        }else {
            return null;
        }

    }

    //=========== Que reversal ==============
    public VoertuigLink reverse(VoertuigLink voertuigLink){
        return theList.reverse(voertuigLink);
    }

    public void reverse(){
        theList.reverse();
    }
}
