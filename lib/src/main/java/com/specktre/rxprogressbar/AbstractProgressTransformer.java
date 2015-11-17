package com.specktre.rxprogressbar;

import rx.Observable;
import rx.functions.Action0;

public abstract class AbstractProgressTransformer<T> implements Observable.Transformer<T, T> {

    @Override
    public Observable<T> call(Observable<T> tObservable) {
        return tObservable.doOnSubscribe(new Action0() {
            @Override
            public void call() {
                show();
            }
        }).finallyDo(new Action0() {
            @Override
            public void call() {
                hide();
            }
        });
    }

    protected abstract void hide();

    protected abstract void show();
}
