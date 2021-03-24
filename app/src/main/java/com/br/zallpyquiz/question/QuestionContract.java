package com.br.zallpyquiz.question;

import com.br.zallpyquiz.base.BasePresenter;
import com.br.zallpyquiz.base.BaseView;

import java.util.List;

public interface QuestionContract {

interface View extends BaseView<BasePresenter>{

    void onSuccessfullLoadQuestions(List<Question> questions);
    void addScore();
    void decreaseScore();

}

interface Presenter extends BasePresenter<BaseView>{

    void loadQuestions();
}

}
