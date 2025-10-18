package com.songifyfeignclient;

import com.songifyfeignclient.service.SongifyClientService;
import com.songifyfeignclient.domain.Song;
import feign.FeignException;
import feign.RetryableException;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.event.EventListener;
@EnableFeignClients
@SpringBootApplication
@Log4j2
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

        try {
            songifyClientService.makeGetAllSongsRequest();
            songifyClientService.makeGetSongByIdRequest();
            songifyClientService.makeCreateSongRequest(new Song("Classic song", "Chopin"));
            songifyClientService.makeGetAllSongsRequest();
            songifyClientService.makeDeleteSongByIdRequest(1);
            songifyClientService.makeGetAllSongsRequest();
            songifyClientService.makeUpdateSongRequest(5, new Song("Random song", "Random artist"));
            songifyClientService.makeGetAllSongsRequest();
            // songifyClientService.makePartiallyUpdateSongRequest(6, new Song(null, "Fryderyk"));
        } catch (FeignException.FeignClientException feignClientException) {
            log.error("Client error: {}",feignClientException.getMessage());
        } catch (FeignException.FeignServerException feignServerException) {
            log.error("Server error: {}", feignServerException.getMessage());
        } catch (RetryableException retryableException) {
            log.error("Connection error: {} {}", retryableException.status(),
                    retryableException.getMessage());
        } catch (FeignException feignException) {
            log.error("Something went wrong: {} {}", feignException.status(),
                    feignException.getMessage());
        }
    }
}
