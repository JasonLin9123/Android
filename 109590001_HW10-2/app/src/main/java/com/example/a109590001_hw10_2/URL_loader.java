package com.example.a109590001_hw10_2;

import android.content.Context;
import androidx.loader.content.AsyncTaskLoader;
import org.jsoup.Jsoup;
import java.io.IOException;

public class URL_loader extends AsyncTaskLoader<String> {
    private final String urlString;
    public URL_loader(Context context, String url) {
        super(context);
        this.urlString = url;
    }
    @Override
    protected void onStartLoading() {
        super.onStartLoading();
        forceLoad();
    }
    @Override
    public String loadInBackground() {
        String data = "Error";
        try {
            data = Jsoup.connect(urlString).get().html();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        return data;
    }
}
