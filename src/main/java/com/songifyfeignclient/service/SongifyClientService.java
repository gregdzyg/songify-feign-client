package com.songifyfeignclient.service;

import com.songifyfeignclient.domain.Song;
import com.songifyfeignclient.songifyproxy.dto.request.SongifyCreateSongRequestDto;
import com.songifyfeignclient.songifyproxy.SongifyProxy;
import com.songifyfeignclient.songifyproxy.dto.request.SongifyPartiallyUpdateSongRequestDto;
import com.songifyfeignclient.songifyproxy.dto.request.SongifyUpdateSongRequestDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Log4j2
@Service
public class SongifyClientService {

    SongifyProxy songifyProxy;

    SongifyClientService(SongifyProxy songifyProxy) {
        this.songifyProxy = songifyProxy;
    }

    public void makeGetAllSongsRequest() {
        log.info(songifyProxy.getAllSongs());
    }

    public void makeGetSongByIdRequest() {
        log.info(songifyProxy.getSongById(1));
    }

    public void makeCreateSongRequest(Song song) {
        log.info(songifyProxy.createSong(new SongifyCreateSongRequestDto(song.name(), song.artist())));
    }

    public void makeDeleteSongByIdRequest(Integer id) {
        log.info(songifyProxy.deleteSong(id));
    }

    public void makeUpdateSongRequest(Integer id, Song newSong) {
        log.info(songifyProxy.updateSongById(id,
                new SongifyUpdateSongRequestDto(newSong.name(), newSong.artist())));
    }

    public void makePartiallyUpdateSongRequest(Integer id, Song changedSong) {
       String newName =  changedSong.name() == null || changedSong.name().isBlank() ?
               null : changedSong.name();

       String newArtist = changedSong.artist() == null || changedSong.artist().isBlank() ?
               null : changedSong.artist();

        log.info(songifyProxy.partiallyUpdateSongById(id,
                new SongifyPartiallyUpdateSongRequestDto(newName, newArtist)));

    }
}
