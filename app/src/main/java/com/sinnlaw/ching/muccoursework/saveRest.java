package com.sinnlaw.ching.muccoursework;

import java.io.Serializable;

/**
 * Created by ching on 2015/11/25.
 */
public class saveRest implements Serializable{

    private String restName;

    public String getRestName(){return restName;}

    public void setRestName(String restName){this.restName = restName;}

    public String toString(){
        String savedRestData;
        savedRestData = "Name: " + restName;
        return savedRestData;
    }

}
