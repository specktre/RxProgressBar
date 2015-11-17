package com.specktre.rxprogressbar.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.specktre.rxprogressbar.RxProgressBar;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

public class SomeViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.some_view_activity);

        Observable.interval(1, TimeUnit.SECONDS).take(4)
                  .compose(RxProgressBar.withAny(findViewById(R.id.view)))
                  .observeOn(AndroidSchedulers.mainThread())
                  .subscribe(new Action1<Long>() {
                      @Override
                      public void call(Long aLong) {
                          Toast.makeText(SomeViewActivity.this, "Value " + aLong, Toast.LENGTH_SHORT).show();
                          Log.i("tag", "emited value " + aLong);
                      }
                  }, new Action1<Throwable>() {
                      @Override
                      public void call(Throwable throwable) {
                          Log.e("tag", "error ", throwable);
                      }
                  });
    }
}
