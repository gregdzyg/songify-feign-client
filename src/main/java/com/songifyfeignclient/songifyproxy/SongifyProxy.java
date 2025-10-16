package com.songifyfeignclient.songifyproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Component
@FeignClient(name = "songify", url = "http://localhost:8080")
public interface SongifyProxy {

    @GetMapping("songs")
    SongifyGetResponseDto getAllSongs();
}
