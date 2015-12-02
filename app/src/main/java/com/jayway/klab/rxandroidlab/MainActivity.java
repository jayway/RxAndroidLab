package com.jayway.klab.rxandroidlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jakewharton.rxbinding.view.RxView;
import com.jayway.klab.rxandroidlab.albumsearch.AlbumSearchActivity;
import com.jayway.klab.rxandroidlab.signup.SignUpActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RxView.clicks(findViewById(R.id.searchlab_button))
                .subscribe(aVoid -> startActivity(new Intent(this, AlbumSearchActivity.class)));

        RxView.clicks(findViewById(R.id.register_button))
                .subscribe(aVoid -> startActivity(new Intent(this, SignUpActivity.class)));
    }
}
