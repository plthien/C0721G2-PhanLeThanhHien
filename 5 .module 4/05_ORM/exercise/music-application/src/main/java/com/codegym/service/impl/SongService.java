package com.codegym.service.impl;

import com.codegym.bean.Song;
import com.codegym.repository.ISongRepository;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public List<Song> findAll() {
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(Integer id) {
        return iSongRepository.findById(id);
    }

    @Override
    public void update(Song song) {
        iSongRepository.update(song);
    }

    @Override
    public void remove(Song song) {
        iSongRepository.remove(song);
    }
}
