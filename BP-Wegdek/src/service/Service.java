package service;

import datastructures.impl.VoertuigLinkList;
import datastructures.linkQue.VoertuigLinkQue;
import entity.Voertuig;
import entity.Wegdek;

/**
 * Created by abhoendie on 8/19/2017.
 */
public class Service {

    public VoertuigLinkList insertNoord() {
        //NOORD
        VoertuigLinkList voertuigLinkList = new VoertuigLinkList();
        voertuigLinkList.insert(new Voertuig(1, "13-34 PA", 3));
        voertuigLinkList.insert(new Voertuig(2, "23-65 PA", 3));
        voertuigLinkList.insert(new Voertuig(3, "34-54 PA", 3));
        voertuigLinkList.insert(new Voertuig(4, "00-22 AM", 1));
        return voertuigLinkList;
    }
    public VoertuigLinkList insertZuid() {
        //ZUID
        VoertuigLinkList voertuigLinkList = new VoertuigLinkList();
        voertuigLinkList.insert(new Voertuig(1, "32-56 PB", 3));
        voertuigLinkList.insert(new Voertuig(2, "65-23 PB", 3));
        voertuigLinkList.insert(new Voertuig(3, "44-86 PB", 3));
        voertuigLinkList.insert(new Voertuig(4, "34-78 PB", 3));
        voertuigLinkList.insert(new Voertuig(5, "76-89 PB", 3));
        voertuigLinkList.insert(new Voertuig(6, "34-21 PB", 3));
        voertuigLinkList.insert(new Voertuig(7, "89-56 PB", 3));
        voertuigLinkList.insert(new Voertuig(8, "23-47 PB", 3));
        voertuigLinkList.insert(new Voertuig(9, "66-75 PB", 3));
        voertuigLinkList.insert(new Voertuig(10, "54-87 PB", 3));
        voertuigLinkList.insert(new Voertuig(11, "87-98 PB", 3));
        voertuigLinkList.insert(new Voertuig(12, "32-45 PB", 3));
        voertuigLinkList.insert(new Voertuig(13, "34-65 PB", 3));
        voertuigLinkList.insert(new Voertuig(14, "90-56 PB", 3));
        voertuigLinkList.insert(new Voertuig(15, "43-22 PB", 3));
        voertuigLinkList.insert(new Voertuig(16, "24-22 PB", 3));
        voertuigLinkList.insert(new Voertuig(17, "78-56 PB", 3));
        voertuigLinkList.insert(new Voertuig(18, "00-33 BW", 2));
        return voertuigLinkList;
    }
    public VoertuigLinkList insertOost() {
        //OOST
        VoertuigLinkList voertuigLinkList = new VoertuigLinkList();
        voertuigLinkList.insert(new Voertuig(1, "56-78 PC", 3));
        voertuigLinkList.insert(new Voertuig(2, "23-98 PC", 3));
        voertuigLinkList.insert(new Voertuig(3, "38-45 PC", 3));
        voertuigLinkList.insert(new Voertuig(4, "56-90 PC", 3));
        voertuigLinkList.insert(new Voertuig(5, "34-22 PC", 3));
        return voertuigLinkList;
    }
    public VoertuigLinkList insertWest(){
        //WEST
        VoertuigLinkList voertuigLinkList = new VoertuigLinkList();
        voertuigLinkList.insert(new Voertuig(1,"56-78 PC", 3));
        voertuigLinkList.insert(new Voertuig(2,"56-78 PC", 3));
        voertuigLinkList.insert(new Voertuig(3,"23-98 PC", 3));
        voertuigLinkList.insert(new Voertuig(4,"38-45 PC", 3));
        voertuigLinkList.insert(new Voertuig(5,"56-90 PC", 3));
        voertuigLinkList.insert(new Voertuig(6,"56-90 PC", 3));
        voertuigLinkList.insert(new Voertuig(7,"56-90 PC", 3));
        voertuigLinkList.insert(new Voertuig(8,"56-90 PC", 3));
        voertuigLinkList.insert(new Voertuig(9,"56-90 PC", 3));
        voertuigLinkList.insert(new Voertuig(10,"56-90 PC", 3));
        voertuigLinkList.insert(new Voertuig(11,"56-90 PC", 3));
        voertuigLinkList.insert(new Voertuig(12,"56-90 PC", 3));
        voertuigLinkList.insert(new Voertuig(13,"56-90 PC", 3));
        voertuigLinkList.insert(new Voertuig(14,"00-22 PO", 0));
        return voertuigLinkList;
    }
    public Wegdek oprijden(Wegdek wegdek){
        int times = wegdek.getVoertuigen().getCount();
        switch (wegdek.getName()) {
            case "O":
                System.out.println("========Wegdek Oost aan de beurt========");
                if (wegdek.getVoertuigen().isEmpty()) {
                    System.out.println("Sensor oost aangeslagen! Beurt overgeslagen \n");
                    break;
                }else {
                    for(int x = 0; x < 5;x++){
                        if(wegdek.getVoertuigen().peekFirst() != null) {
                            System.out.println("Voertuig " + wegdek.getVoertuigen().peekFirst().getVolgNummer() + " met Kenteken nummer : "+ wegdek.getVoertuigen().peekFirst().getKentekenNummer() + " rijdt op.");
                            wegdek.getReverseVoertuigen().push(wegdek.getVoertuigen().remove());
                        }
                    }
                }
                System.out.println("\n");
                break;
            case "Z":
                System.out.println("========Wegdek Zuid aan de beurt========");
                if (wegdek.getVoertuigen().isEmpty()) {
                    System.out.println("Er zijn geen voertuigen op wegdek Zuid");
                    break;
                }

                if (wegdek.getVoertuigen().getCount() > 10) {
                    System.out.println("Er zijn meer dan 10 voertuigen aanwezig in Zuid! \n");
                    times = 10;
                }
                else if (wegdek.getVoertuigen().getCount() >= 5) {
                    times = 5;
                }

                for (int x = 0; x < times; x++) {
                    if(wegdek.getVoertuigen().peekFirst() != null) {
                        System.out.println("Voertuig " + wegdek.getVoertuigen().peekFirst().getVolgNummer() + " met Kenteken nummer : "+ wegdek.getVoertuigen().peekFirst().getKentekenNummer() + " rijdt op.");
                        wegdek.getReverseVoertuigen().push(wegdek.getVoertuigen().remove());
                    }
                }

                System.out.println("\n");
                break;

            case "W":
                System.out.println("========Wegdek West aan de beurt========");
                if (wegdek.getVoertuigen().isEmpty()) {
                    System.out.println("Er zijn geen voertuigen op wegdek West \n");
                    break;
                }

                if (wegdek.getVoertuigen().getCount() > 10) {
                    //System.out.println("Er zijn meer dan 10 voertuigen aanwezig in West!");
                    times = 10;
                }
                else if (wegdek.getVoertuigen().getCount() >= 5) {
                    times = 5;
                }

                for (int x = 0; x < times; x++) {
                    if(wegdek.getVoertuigen().peekFirst() != null) {
                        System.out.println("Voertuig " + wegdek.getVoertuigen().peekFirst().getVolgNummer() + " met Kenteken nummer : "+ wegdek.getVoertuigen().peekFirst().getKentekenNummer() + " rijdt op.");
                        wegdek.getReverseVoertuigen().push(wegdek.getVoertuigen().remove());
                    }
                }

                System.out.println("\n");
                break;

            case "N":
                System.out.println("========Wegdek Noord aan de beurt========");
                if (wegdek.getVoertuigen().isEmpty()) {
                    System.out.println("Er zijn geen voertuigen op wegdek Noord \n");
                    break;
                }else{
                    for(int x = 0; x < 5;x++){
                        if(wegdek.getVoertuigen().peekFirst() != null) {
                            System.out.println("Voertuig " + wegdek.getVoertuigen().peekFirst().getVolgNummer() + " met Kenteken nummer : "+ wegdek.getVoertuigen().peekFirst().getKentekenNummer() + " rijdt op.");
                            wegdek.getReverseVoertuigen().push(wegdek.getVoertuigen().remove());
                        }
                    }
                }
                System.out.println("\n");
                break;
        }
        return wegdek;
    }

}
