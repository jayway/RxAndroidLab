package com.jayway.klab.rxandroidlab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.jayway.klab.rxandroidlab.albumsearch.AlbumSearchActivity;
import com.jayway.klab.rxandroidlab.signup.SignUpActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.register_button)
    public void launchRegisterActivity(View view) {
        startActivity(new Intent(this, SignUpActivity.class));
    }

    @OnClick(R.id.searchlab_button)
    public void launchAlbumSearchActivity(View view) {
        startActivity(new Intent(this, AlbumSearchActivity.class));
    }
}
