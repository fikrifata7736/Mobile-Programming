package umn.ac.id.week11_32482;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolder {


    public interface JsonPlaceholderApi {

            @GET("posts")
            Call<List<Post>> getPosts();
    }
}
