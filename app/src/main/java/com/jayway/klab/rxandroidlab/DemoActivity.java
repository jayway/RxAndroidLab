package com.jayway.klab.rxandroidlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;

import com.jakewharton.rxbinding.view.RxView;
import com.jakewharton.rxbinding.widget.RxTextView;
import com.jakewharton.rxbinding.widget.TextViewAfterTextChangeEvent;
import com.jayway.klab.rxandroidlab.jamendo.JamendoApi;

import java.util.concurrent.TimeUnit;

import butterknife.Bind;
import butterknife.ButterKnife;
import rx.Observable;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.functions.Func2;
import rx.schedulers.Schedulers;

public class DemoActivity extends AppCompatActivity {

    @Bind(R.id.button)
    Button button;

    @Bind(R.id.first_name)
    EditText firstNameInput;

    @Bind(R.id.last_name)
    EditText lastNameInput;

    private Subscription subscription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);
        setup();
    }

    @Override
    protected void onPause() {
        super.onPause();
        subscription.unsubscribe();
    }

    private void setup() {
        subscription = RxTextView.afterTextChangeEvents(firstNameInput)
                .map(event -> event.editable().toString())
                .filter(s -> { if (true) throw new RuntimeException(); return true; })
                .subscribeOn(Schedulers.io())
                .throttleLast(1, TimeUnit.SECONDS)
                .map(s -> JamendoApi.searchAlbums(s))
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(msg -> System.out.println("event " + msg));
    }
}
