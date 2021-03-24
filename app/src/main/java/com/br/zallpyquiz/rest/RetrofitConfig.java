package com.br.zallpyquiz.rest;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class RetrofitConfig {
    public static final String BASE_URL = "http://yoda-api.agilepromoter.com/";

    private final Retrofit retrofit;

    public RetrofitConfig() {
        this.retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                              .addConverterFactory(JacksonConverterFactory.create())
                .client(new OkHttpClient()
                            .newBuilder()
                            .build())
                .build();

    }

    public QuestionService getQuestionService(){
        return this.retrofit.create(QuestionService.class);
    }

}
