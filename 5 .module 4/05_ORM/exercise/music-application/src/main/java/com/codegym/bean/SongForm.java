package com.codegym.bean;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private Integer id;
    private String name;
    private String singer;
    private String kindOfMusic;
    private MultipartFile path;

    public SongForm() {
    }

    public SongForm(String name, String singer, String kindOfMusic, MultipartFile path) {
        this.name = name;
        this.singer = singer;
        this.kindOfMusic = kindOfMusic;
        this.path = path;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getKindOfMusic() {
        return kindOfMusic;
    }

    public void setKindOfMusic(String kindOfMusic) {
        this.kindOfMusic = kindOfMusic;
    }

    public MultipartFile getPath() {
        return path;
    }

    public void setPath(MultipartFile path) {
        this.path = path;
    }
}
