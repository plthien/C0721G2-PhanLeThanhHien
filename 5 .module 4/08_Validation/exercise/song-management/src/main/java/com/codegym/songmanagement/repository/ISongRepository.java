package com.codegym.songmanagement.repository;

import com.codegym.songmanagement.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ISongRepository extends JpaRepository<Song,Integer> {

    @Query(value="select * from song where song.id = :id ",nativeQuery=true)
    Song findSongById(@Param("id")int id);
}
