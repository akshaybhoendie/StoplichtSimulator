package entity;

import datastructures.impl.VoertuigLinkList;
import datastructures.linkQue.VoertuigLinkQue;
import datastructures.stack.StackLink;

/**
 * Created by abhoendie on 8/19/2017.
 */
public class Wegdek {

    private String name;
    private VoertuigLinkQue voertuigen;
    private StackLink reverseVoertuigen;

    public Wegdek(VoertuigLinkQue voertuigen,String name) {
        this.voertuigen = voertuigen;
        this.reverseVoertuigen = new StackLink();
        this.name = name;
    }

    public VoertuigLinkQue getVoertuigen() {
        return voertuigen;
    }

    public void setVoertuigen(VoertuigLinkQue voertuigen) {
        this.voertuigen = voertuigen;
    }

    public StackLink getReverseVoertuigen() {
        return reverseVoertuigen;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
