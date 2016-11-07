package etl.com.bd.animatedsplash;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {
    MediaPlayer sound;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
        sound = MediaPlayer.create(SplashActivity.this,R.raw.sound);
        sound.start();
        Animation anim = AnimationUtils.loadAnimation(this,R.anim.move_up);
        imageView.setAnimation(anim);

        if(!isNetworkAvailable()){
            AlertDialog.Builder Checkbuilder = new AlertDialog.Builder(this);
            Checkbuilder.setIcon(R.drawable.erroricon);
            Checkbuilder.setTitle("Error!");
            Checkbuilder.setMessage("Check your internet connection");
            Checkbuilder.setPositiveButton("Retry", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Intent intent=getIntent();
                    finish();
                    startActivity(intent);
                }
            });

            Checkbuilder.setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });

            AlertDialog alertDialog = Checkbuilder.create();
            alertDialog.show();

        }

        else{
            if(isNetworkAvailable()){
                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(SplashActivity.this,LoginActivity.class));
                        finish();
                    }
                },2000);
            }
        }


    }

    private boolean isNetworkAvailable(){
        ConnectivityManager connectivityManager=(ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();

        return activeNetworkInfo != null;
    }

    @Override
    protected void onPause() {
        super.onPause();
        sound.release();
    }
}
