package com.liudiao.uiframe.model;

/**
 * Created by match on 15-4-28.
 */
public class JokeModel implements ICommonModel {

    private String desciption;
//    private String imageUrl;
    private String time;

    public JokeModel(String desciption, String time) {
        this.desciption = desciption;
        this.time = time;
    }

    @Override
    public String getDescription() {
        return desciption;
    }

    @Override
    public String getImageUrl() {
        return null;
    }

    @Override
    public String getTime() {
        return time;
    }
}
