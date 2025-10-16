package com.songifyfeignclient.songifyproxy;

import java.util.Map;

public record SongifyGetResponseDto(Map<Integer, Song> songs) {
}
