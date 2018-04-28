package com.example.helloworldsolution.ogtv;

import java.util.ArrayList;

/**
 * Created by HelloWorldSolution on 4/17/2018.
 */

public class Video {
    private String kind;

    public String getKind() { return this.kind; }

    public void setKind(String kind) { this.kind = kind; }

    private String etag;

    public String getEtag() { return this.etag; }

    public void setEtag(String etag) { this.etag = etag; }

    private String nextPageToken;

    public String getNextPageToken() { return this.nextPageToken; }

    public void setNextPageToken(String nextPageToken) { this.nextPageToken = nextPageToken; }

    private String regionCode;

    public String getRegionCode() { return this.regionCode; }

    public void setRegionCode(String regionCode) { this.regionCode = regionCode; }

    private PageInfo pageInfo;

    public PageInfo getPageInfo() { return this.pageInfo; }

    public void setPageInfo(PageInfo pageInfo) { this.pageInfo = pageInfo; }

    private ArrayList<Item> items;

    public ArrayList<Item> getItems() { return this.items; }

    public void setItems(ArrayList<Item> items) { this.items = items; }

}
