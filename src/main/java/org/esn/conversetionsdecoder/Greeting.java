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
public class Greeting {

    private String num;
    private String text;

    public Greeting(String num, String text) {
        this.num = num;
        this.text = text;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

}
