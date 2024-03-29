package com.example.healthmate;

import com.google.firebase.firestore.ServerTimestamp;

import java.util.Date;

public class Post {

//    private String email;
    private String documentId;
    private String title;
    private String contents;
    @ServerTimestamp
    private Date date;

    public Post(String documentId, String title, String contents) {
        this.documentId = documentId;
        this.title = title;
//        this.email = email;
        this.contents = contents;
    }

//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getDocumentId() {
        return documentId;
    }

    public void setDocumentId(String documentId) {
        this.documentId = documentId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Post{" +
                "documentId='" + documentId + '\'' +
                ", title='" + title + '\'' +
                ", contents='" + contents + '\'' +
                ", date=" + date +
                '}';
    }
}

