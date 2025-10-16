package com.songifyfeignclient;

import com.songifyfeignclient.service.SongifyClientService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
@EnableFeignClients
@SpringBootApplication
public class SongifyFeignClientApplication {

    SongifyClientService songifyClientService;

    SongifyFeignClientApplication(SongifyClientService songifyClientService) {
        this.songifyClientService = songifyClientService;
    }

    public static void main(String[] args) {
        SpringApplication.run(SongifyFeignClientApplication.class, args);
    }


    @EventListener(ApplicationStartedEvent.class)
    public void run() {

        songifyClientService.makeGetAllSongsRequest();

    }
}
