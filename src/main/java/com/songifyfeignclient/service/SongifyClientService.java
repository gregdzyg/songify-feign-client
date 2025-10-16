package com.songifyfeignclient.service;

import com.songifyfeignclient.songifyproxy.SongifyProxy;
import org.springframework.stereotype.Service;

@Service
public class SongifyClientService {

    SongifyProxy songifyProxy;

    SongifyClientService(SongifyProxy songifyProxy) {
        this.songifyProxy = songifyProxy;
    }

    public void makeGetAllSongsRequest() {
        System.out.println(songifyProxy.getAllSongs());
    }
}
