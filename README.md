## Tmdb API 사용해서 영화 포스터 제목 긁어오기.


**아직 정한 영화에 대해서 크롤링 해오는 것에 대해서는 공부를 해야해서 일단 한 사이트에 존재하는 최상단 영화 30개만 크롤링**


- 📌 Controller
    - "/" -> 바로 로컬로 서버 열어서 메인 홈으로 가면 service 코드가 실행됩니다.

- 📌 Service
    -  private final String BASE_URL ="https://api.themoviedb.org/3/discover/movie?api_key="
        -  해당 속성을 보아 알겠지만 뒤에 API-KEY가 들어가야 합니다. 
        - tmdb에서 api key를 받고 본인의 키를 `src/main/resources/application.properties`에 값을 넣어줘야 합니다.
        - 그 이후 @Value("${application.properties에서 선언한 변수}") 를 넣어주면 코드가 정상적으로 실행됩니다.
        - 

### application.properties
```java
ttkey=본인이 발급받은 api key
```

- 추가 확인 사항
    - `application.properties` 에 꼭 key를 받아서 넣어야 합니다! 반드시! 아니면 권한 허용이 안되서 데이터를 끌어오지 못합니다.
    - [tmdb api key 생성하기](https://velog.io/@green9930/tmdb-API-key-%EB%B0%9C%EA%B8%89%EB%B0%9B%EA%B8%B0)
    - 문제시 바로 물어봐주세요!

