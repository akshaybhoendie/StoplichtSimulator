package datastructures.link;

import entity.Voertuig;

/**
 * Created by abhoendie on 8/13/2017.
 */
public class VoertuigLink {

    private Voertuig voertuigData;
    private VoertuigLink next;

    public VoertuigLink(Voertuig voertuigData) {
        this.voertuigData = voertuigData;
    }

    public Voertuig getVoertuigData() {
        return voertuigData;
    }

    public void setVoertuigData(Voertuig voertuigData) {
        this.voertuigData = voertuigData;
    }

    public VoertuigLink getNext() {
        return next;
    }

    public void setNext(VoertuigLink next) {
        this.next = next;
    }

    public void displayVoertuigLink(){
        System.out.print("Display voertuig " + voertuigData);
    }
}


