package com.liudiao.uiframe.model;

/**
 * Created by match on 15-4-28.
 */
public class PictureModel implements ICommonModel {

    private String desciption;
    private String imageUrl;
    private String time;

    public PictureModel(String desciption, String imageUrl, String time) {
        this.desciption = desciption;
        this.imageUrl = imageUrl;
        this.time = time;
    }

    @Override
    public String getDescription() {
        return desciption;
    }

    @Override
    public String getImageUrl() {
        return imageUrl;
    }

    @Override
    public String getTime() {
        return time;
    }
}
