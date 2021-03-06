package com.example.a109590001_hw10_2;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.loader.app.LoaderManager;
import androidx.loader.content.Loader;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<String>{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void fetchContent(View view) {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        Spinner protocalSpinner = findViewById(R.id.spinner);
        EditText urlText = findViewById(R.id.editTextTextPersonName);
        String spinnerText = protocalSpinner.getSelectedItem().toString();
        String url = spinnerText + urlText.getText().toString();
        Bundle qBundle = new Bundle();
        qBundle.putString("URL", url);
        getSupportLoaderManager().restartLoader(0, qBundle, this);
    }
    @NonNull
    @Override
    public Loader<String> onCreateLoader(int id, @Nullable Bundle args) {
        String URL = "";
        if (args != null) {
            URL = args.getString("URL");
        }
        return new URL_loader(MainActivity.this, URL);
    }
    @Override
    public void onLoadFinished(@NonNull Loader<String> loader, String data) {
        System.out.println(data);
        TextView textView = findViewById(R.id.textView2);
        textView.setText(data);
    }
    @Override
    public void onLoaderReset(@NonNull Loader<String> loader) { }
}