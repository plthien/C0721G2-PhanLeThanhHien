package com.codegym.songmanagement.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity(name = "song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Ten bai hat khong chua cac ky tu dac biet, toi da 800 ky tu" )
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,800}$",message = "Ten bai hat khong chua cac ky tu dac biet, toi da 800 ky tu")
    @Column(name = "name",columnDefinition = "VARCHAR(800)")
    private String name;
    @NotBlank(message = "Ten bai hat khong chua cac ky tu dac biet, toi da 800 ky tu" )
    @Pattern(regexp = "^[a-zA-Z0-9 ]{1,300}$",message = "Ten Ca sy khong chua cac ky tu dac biet, toi da 300 ky tu")
    @Column(name = "singer",columnDefinition = "VARCHAR(300)")
    private String singer;
    @NotBlank(message = "Ten bai hat khong chua cac ky tu dac biet, toi da 800 ky tu" )
    @Pattern(regexp = "^[a-zA-Z0-9 ,]{1,1000}$",message = "Ten the loai khong chua cac ky tu dac biet, toi da 1000 ky tu")
    @Column(name = "kind_of_music",columnDefinition = "VARCHAR(1000)")
    private String kindOfMusic;

    public Song() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
}
