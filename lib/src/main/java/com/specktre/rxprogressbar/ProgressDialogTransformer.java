package com.specktre.rxprogressbar;

import android.app.Activity;
import android.app.ProgressDialog;

public class ProgressDialogTransformer<T> extends AbstractProgressTransformer {

    private final ProgressDialog dialog;

    public static ProgressDialogTransformer create(Activity activity) {
        return new ProgressDialogTransformer(activity, "", "");
    }

    public static ProgressDialogTransformer create(Activity activity, String title) {
        return new ProgressDialogTransformer(activity, title, "");
    }

    public static ProgressDialogTransformer create(Activity activity, String title, String message) {
        return new ProgressDialogTransformer(activity, title, message);
    }

    private ProgressDialogTransformer(Activity activity, String title, String message) {
        dialog = new ProgressDialog(activity);
        dialog.setTitle(title);
    }

    @Override
    protected void hide() {
        if(dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    @Override
    protected void show() {
        dialog.show();
    }
}
