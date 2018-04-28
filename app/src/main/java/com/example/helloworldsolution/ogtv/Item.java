package com.example.helloworldsolution.ogtv;

/**
 * Created by HelloWorldSolution on 4/17/2018.
 */

public class Item {
    private String kind;

    public String getKind() { return this.kind; }

    public void setKind(String kind) { this.kind = kind; }

    private String etag;

    public String getEtag() { return this.etag; }

    public void setEtag(String etag) { this.etag = etag; }

    private Id id;

    public Id getId() { return this.id; }

    public void setId(Id id) { this.id = id; }

    private Snippet snippet;

    public Snippet getSnippet() { return this.snippet; }

    public void setSnippet(Snippet snippet) { this.snippet = snippet; }

}
