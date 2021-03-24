package com.br.zallpyquiz.rest;

import com.br.zallpyquiz.question.Question;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface QuestionService {

    @GET("v1/support/questions")
    Call<List<Question>> getQuestions();

}
