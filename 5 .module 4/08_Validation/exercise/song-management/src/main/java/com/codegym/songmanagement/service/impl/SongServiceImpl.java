package com.codegym.songmanagement.service.impl;

import com.codegym.songmanagement.model.Song;
import com.codegym.songmanagement.repository.ISongRepository;
import com.codegym.songmanagement.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SongServiceImpl implements ISongService {

    @Autowired
    private ISongRepository iSongRepository;

    @Override
    public Page<Song> findAllSongs(int pageNo, int size) {
        Pageable pageable = PageRequest.of(pageNo, size);
        return iSongRepository.findAll(pageable);
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findSongById(int id) {
        return iSongRepository.findSongById(id);
    }
}
