package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent in = getIntent();
        int position = in.getIntExtra("com.example.myapplication.POS", -1);

        if (position >-1 ){
            int pic = getPIC(position);
            ImageView img = (ImageView) findViewById(R.id.animateToEnd);
            sI(img, pic);
        }
    }

    private int getPIC(int pos) {
        switch (pos) {
            case 0: return R.drawable.afryka;
            case 1: return R.drawable.amerykapol;
            case 2: return R.drawable.amerykapolnocna;
            case 3: return R.drawable.antarktyda;
            case 4: return R.drawable.australia;
            case 5: return R.drawable.europa;
            case 6: return R.drawable.azja;
            default:return -1;

        }
    }

    private void sI(ImageView img, int pic){
        Display ekran = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options= new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), pic, options);
        int imgszer = options.outWidth;
        int ekranszer = ekran.getWidth();

        if (imgszer > ekranszer){
            int rat = Math.round( (float)imgszer / (float)ekranszer);
            options.inSampleSize = rat;
        }
        options.inJustDecodeBounds = false;
        Bitmap scai = BitmapFactory.decodeResource(getResources(), pic,options);
        img.setImageBitmap(scai);

    }
}
