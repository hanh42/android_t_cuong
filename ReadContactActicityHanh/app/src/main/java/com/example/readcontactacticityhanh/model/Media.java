package com.example.readcontactacticityhanh.model;

public class Media {
    private String album;
    private String title;
    private String duration;

    public Media() {
    }

    public Media(String album, String title, String duration) {
        this.album = album;
        this.title = title;
        this.duration = duration;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Media{" +
                "album='" + album + '\'' +
                ", title='" + title + '\'' +
                ", duration='" + duration + '\'' +
                '}';
    }
}
