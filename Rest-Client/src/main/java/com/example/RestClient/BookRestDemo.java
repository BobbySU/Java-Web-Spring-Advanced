package com.example.RestClient;

import com.example.RestClient.models.dto.BookDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BookRestDemo implements CommandLineRunner {

    private static final String API_URL="http://localhost:8080/books";
    private static final Logger LOGGER=LoggerFactory.getLogger(BookRestDemo.API_URL);
    private final RestTemplate restTemplate;

    public BookRestDemo(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        ResponseEntity<BookDTO[]> allBookResponse =
        restTemplate.getForEntity(API_URL,BookDTO[].class);

        if(allBookResponse.hasBody()){
            BookDTO[] books = allBookResponse.getBody();
            for (BookDTO aBook: books){
                LOGGER.info("All Books: {}", aBook);
            }
        }
    }
}
