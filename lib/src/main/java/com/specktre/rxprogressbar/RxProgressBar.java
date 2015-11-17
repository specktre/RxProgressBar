package com.specktre.rxprogressbar;

import android.app.Activity;
import android.view.View;
import android.widget.ProgressBar;

public class RxProgressBar {
    public static ProgressDialogTransformer progressDialog(Activity activity) {
        return ProgressDialogTransformer.create(activity);
    }

    public static ProgressBarTransformer withAny(ProgressBar progressBar) {
        return ProgressBarTransformer.create(progressBar);
    }

    public static ViewTransformer withAny(View view) {
        return ViewTransformer.create(view);
    }
}
