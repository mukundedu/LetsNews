package com.example.testing;

import java.util.ArrayList;

public class mainNews {

    private String status;
    private String totalResult;
    private ArrayList<ModelClass> articles;


    /////////////Constructor
    public mainNews(String status, String totalResult) {
        this.status = status;
        this.totalResult = totalResult;
        this.articles = articles;
    }


/////////Getter And Setter
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public ArrayList<ModelClass> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<ModelClass> articles) {
        this.articles = articles;
    }
}
