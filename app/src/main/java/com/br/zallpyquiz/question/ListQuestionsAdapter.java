package com.br.zallpyquiz.question;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.br.zallpyquiz.R;

import java.util.List;

public class ListQuestionsAdapter extends RecyclerView.Adapter<ListQuestionsAdapter.ListQuestionsViewHolder> {


    private List<Question> questionsList;
    private QuestionContract.View view;


    public ListQuestionsAdapter(List<Question> questionsList,QuestionContract.View view) {
        this.questionsList = questionsList;
        this.view = view;
    }

    @NonNull
    @Override
    public ListQuestionsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list_question, viewGroup, false);
        return new ListQuestionsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ListQuestionsViewHolder listReposViewHolder, int position) {
        listReposViewHolder.textViewQuestion.setText(questionsList.get(position).getMessage());
        listReposViewHolder.questions = questionsList;





    }

    @Override
    public int getItemCount() {
        return questionsList.size();
    }




    public class ListQuestionsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewQuestion;
        private CheckBox checkBoxEngland, checkBoxUSA, checkBoxGermany, checkBoxJapan;
        private List<Question> questions;
        private int countScore;


        public ListQuestionsViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewQuestion = itemView.findViewById(R.id.question);
            checkBoxEngland = itemView.findViewById(R.id.checkBoxEngland);
            checkBoxUSA = itemView.findViewById(R.id.checkBoxUSA);
            checkBoxGermany = itemView.findViewById(R.id.checkBoxGermany);
            checkBoxJapan = itemView.findViewById(R.id.checkBoxJapan);

            checkBoxEngland.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    if(checkBoxEngland.isChecked()){
                        checkBoxUSA.setChecked(false);
                        checkBoxGermany.setChecked(false);
                        checkBoxJapan.setChecked(false);

                        if(textViewQuestion.getText().toString().equalsIgnoreCase( "Mini")
                                || textViewQuestion.getText().toString().equalsIgnoreCase( "Rolls-Royce")){
                            view.addScore();
                        }

                    }else if (!checkBoxEngland.isChecked() && textViewQuestion.getText().toString().equalsIgnoreCase( "Mini")
                            || (!checkBoxEngland.isChecked() && textViewQuestion.getText().toString().equalsIgnoreCase( "Rolls-Royce"))){
                        view.decreaseScore();
                    }


                    }

            });


            checkBoxUSA.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {


                    if(checkBoxUSA.isChecked()){
                        checkBoxEngland.setChecked(false);
                        checkBoxGermany.setChecked(false);
                        checkBoxJapan.setChecked(false);

                        if(textViewQuestion.getText().toString().equalsIgnoreCase( "General Motors")){
                            view.addScore();
                        }

                    }else if (!checkBoxUSA.isChecked() && textViewQuestion.getText().toString().equalsIgnoreCase( "General Motors")){
                        view.decreaseScore();
                    }


                }
            });



            checkBoxGermany.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(checkBoxGermany.isChecked()){
                        checkBoxEngland.setChecked(false);
                        checkBoxUSA.setChecked(false);
                        checkBoxJapan.setChecked(false);

                        if(textViewQuestion.getText().toString().equalsIgnoreCase( "BMW")){
                            view.addScore();
                        }

                    }else if (!checkBoxGermany.isChecked() && textViewQuestion.getText().toString().equalsIgnoreCase( "BMW")){
                        view.decreaseScore();
                    }
                }
            });

            checkBoxJapan.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if(checkBoxJapan.isChecked()){
                        checkBoxEngland.setChecked(false);
                        checkBoxUSA.setChecked(false);
                        checkBoxGermany.setChecked(false);

                        if(textViewQuestion.getText().toString().equalsIgnoreCase( "Toyota")){
                            view.addScore();
                        }

                    }else if (!checkBoxGermany.isChecked() && textViewQuestion.getText().toString().equalsIgnoreCase( "Toyota")){
                        view.decreaseScore();
                    }
                }
            });

        }


    }
}
