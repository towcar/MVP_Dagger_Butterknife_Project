package com.carsonskjerdal.feedme.data.retro;

import com.carsonskjerdal.feedme.data.retro.model.RecipeList;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Carson on 6/28/2018.
 * <p>
 * Feel free to use code just give credit please :)
 */
public interface GetDataService {

    //@Headers({})
    @GET("random.php")
    Observable<RecipeList> getRecipe();

    /*@Headers({
            "Accept: application/json",
            "User-Agent: My Library (https://github.com/towcar)"})
    @GET("/search")
    Call<Recipe> searchJoke();

*/
}
