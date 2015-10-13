/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.esn.conversetionsdecoder;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author scraelos
 */
public class Location {

    private String name;
    private List<Npc> npcs;

    public Location(String name) {
        this.name = name;
        this.npcs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Npc> getNpcs() {
        return npcs;
    }

    public void setNpcs(List<Npc> npcs) {
        this.npcs = npcs;
    }

}
