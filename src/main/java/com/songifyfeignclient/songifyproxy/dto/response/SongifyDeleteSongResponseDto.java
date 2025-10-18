package com.songifyfeignclient.songifyproxy.dto.response;

import org.springframework.http.HttpStatus;

public record SongifyDeleteSongResponseDto(String message, HttpStatus status) {
}
