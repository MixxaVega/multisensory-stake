package com.example.supdude.multisensorystake;

import java.io.Serializable;

public class Parcela implements Serializable {

    private String id;
    private String parcela;
    private String ph;
    private String salinidad;
    private String temperatura;
    private String humedad;

    public Parcela(){
        id = "";
        parcela = "";
        ph = "";
        salinidad = "";
        temperatura = "";
        humedad = "";
    }

    public Parcela(String i, String par, String p, String sal, String temp, String hum){
        id = i;
        parcela = par;
        ph = p;
        salinidad = sal;
        temperatura = temp;
        humedad = hum;
    }

    public void setId(String i){
        id = i;
    }

    public void setParcela(String par){
        parcela = par;
    }

    public void setPh(String p){
        ph = p;
    }

    public void setSalinidad(String sal){
        salinidad = sal;
    }

    public void setTemperatura(String temp){
        temperatura = temp;
    }

    public void setHumedad(String hum){
        humedad = hum;
    }

    public String getId(){
        return id;
    }

    public String getParcela(){
        return parcela;
    }

    public String getPh(){
        return ph;
    }

    public String getSalinidad(){
        return salinidad;
    }

    public String getTemperatura(){
        return temperatura;
    }

    public String getHumedad(){
        return humedad;
    }

}
