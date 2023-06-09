package movietest.movie2.controller;

import java.util.Arrays;
import java.util.Map;
import movietest.movie2.entity.Movie;
import movietest.movie2.service.TmdbApiClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Controller
public class MovieController {

    @Autowired // 스프링 컨테이너에 등록되어있는 @Service 것을 들고와야 한다. DI 활용해야 다른 어노테이션들이 작동한다.
    TmdbApiClient tmdbApiClient; // autowired 해서 생성하지 않고 new 로 생성하면 @Value 어노테이션이 작동이 되지 않는다.


    @GetMapping("/")
    public String getMovieName(Model model) {
        Map<String, String> movieAndPoster = tmdbApiClient.getMovieAndPoster();
        System.out.println("hi");
        model.addAttribute("movieInfo", movieAndPoster);
        return "hi";
    }
}
