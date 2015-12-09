package com.sinnlaw.ching.muccoursework;

/**
 * Created by ching on 2015/12/01.
 */
public class ListData {

    private int rest_img_data;
    private String rest_title_data;
    private String rest_price_data;

    public int getRest_img_data()
    {
        return rest_img_data;
    }
    public void setRest_img_data(int rest_img_data)
    {
        this.rest_img_data = rest_img_data;
    }

    public String getRest_title_data()
    {
        return rest_title_data;
    }
    public void setRest_title_data(String rest_title_data)
    {
        this.rest_title_data = rest_title_data;
    }

    public String getRest_price_data()
    {
        return rest_price_data;
    }
    public void setRest_price_data(String rest_price_data)
    {
        this.rest_price_data = rest_price_data;
    }

    public ListData(int rest_img_data, String rest_title_data, String rest_price_data)
    {
        this.setRest_img_data(rest_img_data);
        this.setRest_price_data(rest_price_data);
        this.setRest_title_data(rest_title_data);
    }

}
