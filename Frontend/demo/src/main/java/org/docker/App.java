package org.docker;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" + Arrays.toString(args));
        System.out.println("get() = " + get());
    }

    public static User get() {
        String serverPort = System.getenv("SERVER_PORT");
        String serverHost = System.getenv("SERVER_HOST");
        WebClient webClient = WebClient.builder()
                .baseUrl("http://"+serverHost+":"+serverPort)
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();

        Mono<User> userMono = webClient.get()
                .uri("/userJson")
                .retrieve()
                .bodyToMono(User.class);
        return userMono.block();
    }
}
