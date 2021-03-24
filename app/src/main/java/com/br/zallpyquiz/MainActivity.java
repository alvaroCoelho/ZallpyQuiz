package com.br.zallpyquiz;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.br.zallpyquiz.base.BasePresenter;
import com.br.zallpyquiz.question.ListQuestionsAdapter;
import com.br.zallpyquiz.question.Question;
import com.br.zallpyquiz.question.QuestionContract;
import com.br.zallpyquiz.question.QuestionPresenter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ActivityCompat.OnRequestPermissionsResultCallback,
        QuestionContract.View {

   private QuestionPresenter questionPresenter;
   private RecyclerView recyclerView;
   private Button buttonResult;
   private  ListQuestionsAdapter questionsAdapter;
   private int countScore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
        setEventsComponetsView();

        questionPresenter = new QuestionPresenter(this);
        questionPresenter.loadQuestions();

    }


    @Override
    public void onSuccessfullLoadQuestions(List<Question> questions) {
        if(questions!= null && !questions.isEmpty()){
            questionsAdapter = new ListQuestionsAdapter(questions,this);
            recyclerView.setAdapter(questionsAdapter);



        }

    }

    @Override
    public void addScore() {
        countScore++;
    }

    @Override
    public void decreaseScore() {
        countScore--;
    }

    @Override
    public void setPresenter(BasePresenter presenter) {

    }

    @Override
    public void showProgress(boolean show) {

    }

    @Override
    public void initComponents() {
        recyclerView = findViewById(R.id.recyclerView);
        buttonResult = findViewById(R.id.buttonResult);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setNestedScrollingEnabled(true);


    }

    @Override
    public void setEventsComponetsView() {

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                questionsAdapter.notifyDataSetChanged();

                int t = questionsAdapter.getItemCount();
                String message;
                if(countScore != 0) {
                                    message = v.getResources().getString(R.string.you_are_right)+" "+
                                            questionPresenter.calculateScore(countScore,questionsAdapter.getItemCount()) +" %";

                }else{
                    message =v.getResources().getString(R.string.you_are_right) +" "+ 0 +" %";
                }

                    AlertDialog.Builder builder = new AlertDialog.Builder(v.getContext());
                    builder.setMessage(message);
                    builder.setPositiveButton(R.string.remake, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            questionPresenter.loadQuestions();
                            countScore = 0;
                        }
                    });

                    AlertDialog dialog = builder.create();
                    dialog.show();
                }


        });


    }
}