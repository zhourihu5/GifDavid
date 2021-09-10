package com.example.david.gifdavid;

import android.graphics.Bitmap;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

public class MainActivity extends AppCompatActivity {
    ImageView imageView;
    Bitmap bitmap;
    GifHandler gifHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageView= (ImageView) findViewById(R.id.image);
    }
    public void ndkLoadGif(View view) {
        File file=new File(Environment.getExternalStorageDirectory(),"demo2.gif");
        gifHandler=new GifHandler(file.getAbsolutePath());
        bitmap = Bitmap.createBitmap(gifHandler.getWidth(), gifHandler.getHeight(), Bitmap.Config.ARGB_8888);
        int delay= gifHandler.updateFrame(bitmap);
        handler.sendEmptyMessageDelayed(1, delay);
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            int dealy = gifHandler.updateFrame(bitmap);
            imageView.setImageBitmap(bitmap);
            handler.sendEmptyMessageDelayed(1, dealy);
        }
    };
}
