package examples.view.com.navgridrec.Api;


import examples.view.com.navgridrec.TopRatedMovies.TopMovie;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by user on 08-Oct-17.
 */

public interface Service {


    @GET("movie/top_rated")
    Call<TopMovie> getmovies(@Query("api_key") String api);

    @GET("movie/popular")
    Call<TopMovie> getpopularmovies(@Query("api_key") String api);

    @GET("movie/upcoming")
    Call<TopMovie> getupcomingmovies(@Query("api_key") String api);
}
