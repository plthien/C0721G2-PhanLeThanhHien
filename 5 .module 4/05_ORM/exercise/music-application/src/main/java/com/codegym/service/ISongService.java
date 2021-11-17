package com.codegym.service;

import com.codegym.bean.Song;

import java.util.List;

public interface ISongService {
    List<Song> findAll();
    void save(Song song);
    Song findById(Integer id);
    void update(Song song);
    void remove(Song song);
}
