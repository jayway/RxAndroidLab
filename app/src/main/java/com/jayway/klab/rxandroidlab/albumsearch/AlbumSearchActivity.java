package com.jayway.klab.rxandroidlab.albumsearch;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import com.jayway.klab.rxandroidlab.R;

import butterknife.Bind;
import butterknife.ButterKnife;

public class AlbumSearchActivity extends AppCompatActivity {

    @Bind(R.id.query)
    EditText queryTextField;

    @Bind(R.id.list)
    ListView resultListView;

    private ArrayAdapter<String> albumNameAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_album_search);
        ButterKnife.bind(this);

        albumNameAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        resultListView.setAdapter(albumNameAdapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        setupSearch();
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Don't forget to unsubscribe here!
    }

    private void setupSearch() {
        /*
        LAB GOES HERE

        Start with creating an Observable from queryTextField, then subscribe and
        transform the event according to the requirements.

        The actual search can be done with JamendoApi.searchAlbums

        Make sure not to search too often and to do everything on the correct thread!
        */
    }

}
