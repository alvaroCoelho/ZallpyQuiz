package com.br.zallpyquiz.question;

import com.br.zallpyquiz.rest.RetrofitConfig;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuestionPresenter implements QuestionContract {

    List<Question> questions;
    QuestionContract.View view;

    public QuestionPresenter(QuestionContract.View view) {
        this.view = view;
    }

    public void loadQuestions() {

        questions = new ArrayList<>();
        Call<List<Question>> call = new RetrofitConfig().getQuestionService().getQuestions();
        call.enqueue(new Callback<List<Question>>() {
            @Override
            public void onResponse(Call<List<Question>> call, Response<List<Question>> response) {

                if(response.isSuccessful()) {
                    questions = response.body();
                    view.onSuccessfullLoadQuestions(questions);
                }else{
                    System.out.println(response.code());
                }

            }

            @Override
            public void onFailure(Call<List<Question>> call, Throwable t) {
                System.out.println(t.getMessage());
            }
        });

    }

   public double calculateScore(int score, int amount){
        return score * 100 / amount;
    }
}



