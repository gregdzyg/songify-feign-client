package com.songifyfeignclient.songifyproxy.dto.request;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record SongifyPartiallyUpdateSongRequestDto(String name, String artist) {
}
