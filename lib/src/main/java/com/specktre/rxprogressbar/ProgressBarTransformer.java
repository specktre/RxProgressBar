package com.specktre.rxprogressbar;

import android.view.View;
import android.widget.ProgressBar;

public class ProgressBarTransformer extends AbstractProgressTransformer {

    private ProgressBar progressBar;

    public static ProgressBarTransformer create(ProgressBar progressBar) {
        return new ProgressBarTransformer(progressBar);
    }

    private ProgressBarTransformer(ProgressBar progressBar) {
        this.progressBar = progressBar;
    }

    @Override
    protected void hide() {
        progressBar.post(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
            }
        });
    }

    @Override
    protected void show() {
        progressBar.post(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }
}
