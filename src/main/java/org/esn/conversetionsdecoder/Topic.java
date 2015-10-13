/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.esn.conversetionsdecoder;

/**
 *
 * @author scraelos
 */
public class Topic {

    private String playerText;
    private String npcText;

    public Topic(String playerText, String npcText) {
        this.playerText = playerText;
        this.npcText = npcText;
    }

    public String getPlayerText() {
        return playerText;
    }

    public void setPlayerText(String playerText) {
        this.playerText = playerText;
    }

    public String getNpcText() {
        return npcText;
    }

    public void setNpcText(String npcText) {
        this.npcText = npcText;
    }

}
