package com.br.zallpyquiz.base;

public interface BaseView<T extends BasePresenter> {
    void setPresenter(T presenter);
    void showProgress(boolean show);
    void initComponents();
    void setEventsComponetsView();
}
