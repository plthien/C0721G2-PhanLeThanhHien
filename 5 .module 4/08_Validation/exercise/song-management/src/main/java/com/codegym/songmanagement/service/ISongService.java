package com.codegym.songmanagement.service;

import com.codegym.songmanagement.model.Song;
import org.springframework.data.domain.Page;

public interface ISongService {
    Page<Song> findAllSongs(int pageNo, int size);

    void save(Song song);

    Song findSongById(int id);
}
