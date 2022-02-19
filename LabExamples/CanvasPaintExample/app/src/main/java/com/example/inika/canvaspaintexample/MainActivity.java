package com.example.inika.canvaspaintexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils.TruncateAt;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;
import android.widget.Gallery.LayoutParams;

public class MainActivity extends AppCompatActivity {

    private ImageView reusableImageView;
    private TextView textView;
    //
    private int startx = 10;
    private int starty = 10;
    private int endx=300;
    private int endy=300;
    //
    private Paint paint;
    private Bitmap bitmap;
    private Canvas canvas;
    //
    //Handler mHandler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.canvas_layout);
        //create the paint for our drawings
        paint = new Paint();
        paint.setColor(Color.MAGENTA);
        //paint.setStrokeMiter((float)0.5);
        paint.setStrokeWidth(30);

        //creating a bitmap as content view for the image
        bitmap = Bitmap.createBitmap((int) getWindowManager()
                .getDefaultDisplay().getWidth(), (int) getWindowManager()
                .getDefaultDisplay().getHeight(), Bitmap.Config.ARGB_8888);
        //tell canvas about the content view
        canvas = new Canvas(bitmap);
        //set the background for your drawings
        canvas.drawColor(Color.CYAN); //background
        //setup the image view
        reusableImageView = (ImageView)findViewById(R.id.ImageViewForDrawing);
        //tell image view for the bitmap format/content
        reusableImageView.setImageBitmap(bitmap);
        reusableImageView.setVisibility(View.VISIBLE);
        textView = (TextView) findViewById(R.id.textView1);
        textView.setText(getResources().getString(R.string.help));
        //
        //reusableImageView.setImageResource(R.drawable.green_rect);


    }// end of onCreate

    public void clearCanvas(View v)
    {
        canvas.drawColor(Color.CYAN);
        startx = 10;
        starty = 10;
        endx = 300;
        endy = 300;
        textView.setText(getResources().getString(R.string.help));

    }
    public void startDrawing(View v)
    {
        canvas.drawPoint(15,15,paint);

    }
    public void drawLine(Canvas canvas)
    {
        textView.setText(String.valueOf(endy));
        //canvas.drawLine(100,100,300,300,paint);
        canvas.drawLine(startx, starty, endx, endy, paint);
        startx=endx;
        starty=endy;

    }
    //Activate the DPAD on emulator:
    //change the settings in config.ini file in .android folder
    //hw.dPad=yes
    //hw.mainKeys=yes
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        switch(keyCode)
        {
            case KeyEvent.KEYCODE_DPAD_DOWN:
                //reusableImageView.setVisibility(View.VISIBLE);
                //reusableImageView.setFocusable(true);
                //reusableImageView.requestFocus();
                endy=endy+5;
                drawLine( canvas);
                //moveRect(canvas);
                //reusableImageView.invalidate();

                return true;

            case KeyEvent.KEYCODE_DPAD_RIGHT:
                //reusableImageView.setVisibility(View.VISIBLE);
                reusableImageView.setFocusable(true);
                reusableImageView.requestFocus();
                endx=endx+5;
                drawLine( canvas);
                //moveRect(canvas);
                reusableImageView.invalidate();

                return true;
        }
        return false;
    }
}
