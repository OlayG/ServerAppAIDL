package com.example.admin.serverappaidl.retrofit;

import com.example.admin.serverappaidl.model.EventBriteCategory;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Admin on 9/9/2017.
 */

public class RetrofitHelper {
   // https://www.eventbriteapi.com/v3/events/search/?categories&token=JWRK43KE6JVXMOR3JCLF
    public static final String TOKEN = "JWRK43KE6JVXMOR3JCLF";
    public static final String BASE_URL = "https://www.eventbriteapi.com/v3/";
    public static final String EVENTS_PATH = "events/search/";

    public static Retrofit create(String baseUrl) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit;
    }

    public static Call<EventBriteCategory> callEventBriteCategory(){

        Retrofit retrofit = create(BASE_URL);
        EventBriteService eventBriteService = retrofit.create(EventBriteService.class);

        return eventBriteService.getEventsList("",TOKEN);
    }

    public interface EventBriteService {

        @GET(EVENTS_PATH)
        Call<EventBriteCategory> getEventsList(@Query("categories") String cat, @Query("token") String Token);

    }
}
