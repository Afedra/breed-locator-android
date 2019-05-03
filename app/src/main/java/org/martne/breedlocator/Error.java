package org.martne.breedlocator;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class Error extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.error);
    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(Error.this, WebViewActivity.class);
        startActivity(i);
    }

}
