package com.songifyfeignclient.songifyproxy;

import com.songifyfeignclient.songifyproxy.dto.request.SongifyCreateSongRequestDto;
import com.songifyfeignclient.songifyproxy.dto.request.SongifyPartiallyUpdateSongRequestDto;
import com.songifyfeignclient.songifyproxy.dto.request.SongifyUpdateSongRequestDto;
import com.songifyfeignclient.songifyproxy.dto.response.*;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient(name = "songify", url = "${songify.base-url}")
public interface SongifyProxy {

    @GetMapping("songs")
    SongifyGetResponseDto getAllSongs();

    @GetMapping("songs/{id}")
    SongifySingleSongResponseDto getSongById(@PathVariable Integer id);

    @PostMapping("songs")
    SongifyCreateSongResponseDto createSong(@RequestBody SongifyCreateSongRequestDto body);

    @DeleteMapping("songs/{id}")
    SongifyDeleteSongResponseDto deleteSong(@PathVariable Integer id);

    @PutMapping("songs/{id}")
    SongifyUpdateSongResponseDto updateSongById(@PathVariable Integer id,
                                                @RequestBody SongifyUpdateSongRequestDto body);

    @PatchMapping("songs/{id}")
    SongifyPartiallyUpdateSongResponse partiallyUpdateSongById(@PathVariable Integer id,
                                                @RequestBody SongifyPartiallyUpdateSongRequestDto body);
}
