package movietest.movie2.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TmdbApiClient {
    @Value("${ttkey}")
    public String API_KEY;



    private final String BASE_URL =
        "https://api.themoviedb.org/3/discover/movie?api_key=";


    public Map<String, String> getMovieAndPoster() {
        //여기 참고 https://developers.themoviedb.org/3/movies/get-movie-images

        System.out.println(BASE_URL+API_KEY);
        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        Map<String, List<Map<String, Object>>> res = restTemplate.getForObject(BASE_URL+API_KEY, Map.class);

        //System.out.println(res);
        //ystem.out.println("============");
        Object totalPages = res.get("total_pages");
        System.out.println("totalpages= " + totalPages);
        Map<String, String> titleAndPoster = new HashMap<>();
        for (int i = 1; i < 400; i++) {
            String url = "https://api.themoviedb.org/3/discover/movie" + "?api_key=" + API_KEY
                + "&with_watch_providers=337&watch_region=KR&language=ko&page=" + i;

            Map<String, List<Map<String, Object>>> res1 = restTemplate.getForObject(url, Map.class);
            //System.out.println(res1);

            List<Map<String, Object>> results1 = res1.get("results");

            for (Map<String, Object> stringObjectMap : results1) {
                Object originalTitle = stringObjectMap.get("original_title");
                Object posterPath = stringObjectMap.get("poster_path");

                posterPath = "https://www.themoviedb.org/t/p/original/" + posterPath;
                titleAndPoster.put((String) originalTitle, (String) posterPath);
            }

        }

        return titleAndPoster;
    }

}




