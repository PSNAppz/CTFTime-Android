package com.neonsec.ctftime.ctf_timemobile;

/**
 * Created by psn on 3/4/18.
 */

public class CardModel {
    private int imageId;
    private String title;
    private String type;
    private String url;
    private String start;
    private String imageURL;
    private Boolean onsite;

    public CardModel(int imageId, String title, String type, String url, String start, Boolean onsite, String imageURL) {
        this.imageId = imageId;
        this.title = title;
        this.type = type;
        this.url = url;
        this.start = start;
        this.onsite = onsite;
        this.imageURL = imageURL;
    }

    public int getImageId() {
        return imageId;
    }
    public void setImageId(int imageId) {
        this.imageId = imageId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public Boolean getOnsite() {
        return onsite;
    }

    public void setOnsite(Boolean onsite) {
        this.onsite = onsite;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }


}