package com.specktre.rxprogressbar;

import android.view.View;

public class ViewTransformer extends AbstractProgressTransformer {

    private View view;

    public static ViewTransformer create(View view) {
        return new ViewTransformer(view);
    }

    private ViewTransformer(View view) {
        this.view = view;
    }

    @Override
    protected void hide() {
        view.post(new Runnable() {
            @Override
            public void run() {
                view.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void show() {
        view.post(new Runnable() {
            @Override
            public void run() {
                view.setVisibility(View.VISIBLE);
            }
        });
    }
}
