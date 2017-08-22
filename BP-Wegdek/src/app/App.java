package app;

import datastructures.linkQue.VoertuigLinkQue;
import datastructures.stack.StackLink;
import entity.Voertuig;
import entity.Wegdek;
import service.Service;

/**
 * Created by abhoendie on 8/13/2017.
 */
public class App {
    Service service = new Service();
    static Wegdek noord;
    static Wegdek zuid;
    static Wegdek oost;
    static Wegdek west;
    static VoertuigLinkQue prioriteitsVoertuigen;
    static VoertuigLinkQue reversePrioriteitsVoertuigen;
    static StackLink reversePlayback;

    public void init() {
        VoertuigLinkQue voertuigQueN = new VoertuigLinkQue(service.insertNoord());
        VoertuigLinkQue voertuigQueZ = new VoertuigLinkQue(service.insertZuid());
        VoertuigLinkQue voertuigQueO = new VoertuigLinkQue(service.insertOost());
        VoertuigLinkQue voertuigQueW = new VoertuigLinkQue(service.insertWest());

        noord = new Wegdek(voertuigQueN, "N");
        zuid = new Wegdek(voertuigQueZ, "Z");
        oost = new Wegdek(voertuigQueO, "O");
        west = new Wegdek(voertuigQueW, "W");
    }

    public void priorityQueInit() {
        prioriteitsVoertuigen = new VoertuigLinkQue();
        reversePrioriteitsVoertuigen = new VoertuigLinkQue();
        reversePlayback = new StackLink();
        while (noord.getVoertuigen().peekFirst().getPrioriteit() < 3) {
            Voertuig voertuig = noord.getVoertuigen().remove();
            prioriteitsVoertuigen.insert(voertuig);
            reversePrioriteitsVoertuigen.insert(voertuig);
            reversePlayback.push(voertuig);
        }

        while (zuid.getVoertuigen().peekFirst().getPrioriteit() < 3) {
            Voertuig voertuig = zuid.getVoertuigen().remove();
            prioriteitsVoertuigen.insert(voertuig);
            reversePrioriteitsVoertuigen.insert(voertuig);
            reversePlayback.push(voertuig);
        }

        while (oost.getVoertuigen().peekFirst().getPrioriteit() < 3) {
            Voertuig voertuig = oost.getVoertuigen().remove();
            prioriteitsVoertuigen.insert(voertuig);
            reversePrioriteitsVoertuigen.insert(voertuig);
            reversePlayback.push(voertuig);
        }

        while (west.getVoertuigen().peekFirst().getPrioriteit() < 3) {
            Voertuig voertuig = west.getVoertuigen().remove();
            prioriteitsVoertuigen.insert(voertuig);
            reversePrioriteitsVoertuigen.insert(voertuig);
            reversePlayback.push(voertuig);
        }
    }

    public void prioVoertuigOprijden() {
        int countPrio = prioriteitsVoertuigen.getCount();
        for (int x = 0; x < countPrio; x++) {
            if (x == 0) {
                System.out.println("Politie rijdt op!");
                prioriteitsVoertuigen.remove();
            } else if (x == 1) {
                System.out.println("Ambulance rijdt op!");
                prioriteitsVoertuigen.remove();
            } else if (x == 2) {
                System.out.println("Brandweer rijdt op!\n");
                prioriteitsVoertuigen.remove();
            }
        }
    }

    public void reversePrio(){
        reversePrioriteitsVoertuigen.reverse();
    }

    public void rijRonde() {
        noord = service.oprijden(noord);
        zuid = service.oprijden(zuid);
        oost = service.oprijden(oost);
        west = service.oprijden(west);
    }

    public static void main(String[] args) {
        App start = new App();
        start.init();
        start.priorityQueInit();
        int count=0;

        while(!noord.getVoertuigen().isEmpty()
                || !zuid.getVoertuigen().isEmpty()
                || !oost.getVoertuigen().isEmpty()
                || !west.getVoertuigen().isEmpty()){

            start.prioVoertuigOprijden();
            start.rijRonde();
            count++;
        }

        System.out.println("Totaal aantal ronden: " + count + "\n");
        System.out.println("==================== Reverse Playback====================");

        int countPrio = reversePrioriteitsVoertuigen.getCount();
        for (int x = countPrio; x > -1; x--) {
            if (x == 0) {
                System.out.println("Politie rijdt terug!");
                reversePrioriteitsVoertuigen.remove();
            } else if (x == 1) {
                System.out.println("Ambulance rijdt terug!");
                reversePrioriteitsVoertuigen.remove();
            } else if (x == 2) {
                System.out.println("Brandweer rijdt terug!");
                reversePrioriteitsVoertuigen.remove();
            }
        }
    }
}
