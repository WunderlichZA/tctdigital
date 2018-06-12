package rest;
import model.Image;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Headers;

/**
 * Created by jonat on 6/29/2017.
 */

public interface ImgurService {

    String URL = "https://api.imgur.com/3/gallery/hot/viral/0.json";

    @Headers({
            "Authorization: Client-ID 81ec752d0a85fe5",
            "User-Agent: 205254be2b1e517e3d379e895b7c6490432e69d6"
    })
    @GET("/")
    void getAllImages(Callback<Image> cb);
}
