package entity;

/**
 * Created by abhoendie on 8/13/2017.
 */
public class Voertuig {

    private int volgNummer;
    private String kentekenNummer;
    // Priority voor voertuig type, vb: 1- politie, 2-ambulance, 3-brandweer
    int prioriteit;

    public Voertuig(int volgNummer, String kentekenNummer, int prioriteit) {
        this.volgNummer = volgNummer;
        this.kentekenNummer = kentekenNummer;
        this.prioriteit = prioriteit;
    }

    public int getVolgNummer() {
        return volgNummer;
    }

    public void setVolgNummer(int volgNummer) {
        this.volgNummer = volgNummer;
    }

    public String getKentekenNummer() {
        return kentekenNummer;
    }

    public void setKentekenNummer(String kentekenNummer) {
        this.kentekenNummer = kentekenNummer;
    }

    public int getPrioriteit() {
        return prioriteit;
    }

    public void setPrioriteit(int prioriteit) {
        this.prioriteit = prioriteit;
    }

    @Override
    public String toString() {
        return "Voertuig{" +
                "volgNummer=" + volgNummer +
                ", kentekenNummer='" + kentekenNummer + '\'' +
                ", prioriteit=" + prioriteit +
                '}';
    }
}
