package com.example.demo;

public class Post {
    private int postId;
    private String userName;
    private String postDate;
    private String wish;
    private static int counter;

    public Post() {
        this.postId = counter++;
    }

    public static void initCounter(){
        counter = 0;
    }

    public int getPostId() {
        return postId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPostDate() {
        return postDate;
    }

    public void setPostDate(String postDate) {
        this.postDate = postDate;
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }


}
