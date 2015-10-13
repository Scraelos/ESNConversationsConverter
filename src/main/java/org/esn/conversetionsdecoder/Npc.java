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
public class Npc {

    private String name;
    private List<Subtitle> subtitles;
    private List<Topic> topics;
    private List<Greeting> greetings;

    public Npc(String name) {
        this.name = name;
        this.subtitles = new ArrayList<>();
        this.topics = new ArrayList<>();
        this.greetings = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Subtitle> getSubtitles() {
        return subtitles;
    }

    public void setSubtitles(List<Subtitle> subtitles) {
        this.subtitles = subtitles;
    }

    public List<Topic> getTopics() {
        return topics;
    }

    public void setTopics(List<Topic> topics) {
        this.topics = topics;
    }

    public List<Greeting> getGreetings() {
        return greetings;
    }

    public void setGreetings(List<Greeting> greetings) {
        this.greetings = greetings;
    }

}
