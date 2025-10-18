package com.songifyfeignclient.songifyproxy.dto.response;

import com.songifyfeignclient.domain.Song;

import java.util.Map;

public record SongifyGetResponseDto(Map<Integer, Song> songs) {
}
