package com.binod.yoga;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.material.button.MaterialButton;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity {

    private static final long startTimeInMilliSecond=120000;

    private TextView textViewCountDown;
    private ProgressBar progressBar;
    private MaterialButton buttonstartPause,buttonReset;
    private ImageButton music;
    private CountDownTimer countDownTimer;
    private boolean timerRunning;
    private ProgressDialog progressDialog;
    private boolean playpauseMusic;
    private boolean initialStage=true;
    MediaPlayer mediaPlayer;
    private AdView mAdView;
    private Long timeLeftInMilliSecond=startTimeInMilliSecond;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_timer);

        textViewCountDown=findViewById(R.id.mytime);
        buttonstartPause=findViewById(R.id.startStop);
        buttonReset=findViewById(R.id.reset);
        music=findViewById(R.id.musicStartStop);
        progressBar=findViewById(R.id.progressBar);
        mediaPlayer=new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        progressDialog=new ProgressDialog(this);

        buttonstartPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (timerRunning)
                {
                    pauseTimer();
                }
                else
                {
                    startTimer();
                }

            }
        });

        music.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                checkInternetConnection();
            }
        });



        buttonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();

            }
        });

        updateCountDownText();

        MobileAds.initialize(TimerActivity.this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });
        mAdView = (AdView)findViewById(R.id.myads);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }



    private void startTimer()
    {

        countDownTimer=new CountDownTimer(timeLeftInMilliSecond,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeLeftInMilliSecond=millisUntilFinished;
                //progressBar.setProgress((int) (startTimeInMilliSecond));
                updateCountDownText();

            }

            @Override
            public void onFinish() {

                timerRunning=false;
                progressBar.setProgress(100);
                updateButtons();

            }
        }.start();
        timerRunning=true;
        updateButtons();
    }

    private void pauseTimer()
    {

        countDownTimer.cancel();
        timerRunning=false;
        updateButtons();
    }

    private void resetTimer()
    {

        timeLeftInMilliSecond=startTimeInMilliSecond;
        updateCountDownText();
        progressBar.setProgress(0);
        updateButtons();
    }

    private void updateCountDownText()
    {

        int minutes=(int) (timeLeftInMilliSecond/1000 ) /60;
        int seconds=(int) (timeLeftInMilliSecond/1000) % 60;
        progressBar.setProgress((int) (startTimeInMilliSecond-timeLeftInMilliSecond)/1200);

        String timeLeftFormated =String.format(Locale.getDefault(),"%02d:%02d",minutes,seconds);
        textViewCountDown.setText(timeLeftFormated);

    }

    private void updateButtons()
    {
        if (timerRunning)
        {
            buttonReset.setVisibility(View.INVISIBLE);
            buttonstartPause.setText("Pause");
        }
        else
        {
            buttonstartPause.setText("Start");
            if (timeLeftInMilliSecond<1000)
            {
                buttonstartPause.setVisibility(View.INVISIBLE);
            }else
            {
                buttonstartPause.setVisibility(View.VISIBLE);
            }
            if (timeLeftInMilliSecond<startTimeInMilliSecond)
            {
                buttonReset.setVisibility(View.VISIBLE);
            }
            else
            {
                buttonReset.setVisibility(View.INVISIBLE);
            }

        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putLong("millisLeft",timeLeftInMilliSecond);
        outState.putBoolean("timerRunning",timerRunning);


    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        timeLeftInMilliSecond=savedInstanceState.getLong("millisLeft");
        timerRunning=savedInstanceState.getBoolean("timerRunning");

        updateCountDownText();
        updateButtons();

        if (timerRunning)
        {
            startTimer();
        }
    }

    private void checkInternetConnection() {
        ConnectivityManager connMgr = (ConnectivityManager) getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (null != networkInfo) {

            if (networkInfo.getType() == connMgr.TYPE_WIFI) {


                Toast.makeText(TimerActivity.this, "Processing... ", Toast.LENGTH_SHORT).show();
                mediaPlayer();


            }
            if (networkInfo.getType() == connMgr.TYPE_MOBILE) {

                Toast.makeText(TimerActivity.this, "Processing...", Toast.LENGTH_SHORT).show();
                mediaPlayer();

            }
        } else {

            Toast.makeText(TimerActivity.this, "Oops !! No internet connection ", Toast.LENGTH_LONG).show();
        }

    }

    public void mediaPlayer()
    {

        if (! playpauseMusic)
        {
            music.setImageResource(R.drawable.ic_pause_black_24dp);
            if (initialStage)
            {
                new Player().execute("http://docs.google.com/uc?export=download&id=1BsRpB0Ofn9F6kskz5gOagFUh7qpfanAs");
            }else {
                if (!mediaPlayer.isPlaying())

                    mediaPlayer.start();

            }

                playpauseMusic=true;

        }
        else

        {
            music.setImageResource(R.drawable.ic_play_arrow_black_24dp);
            if (mediaPlayer.isPlaying())
            {
                mediaPlayer.pause();
            }

            playpauseMusic=false;
        }


    }

    @Override
    protected void onPause() {
        super.onPause();
        if (mediaPlayer!=null)
        {
            mediaPlayer.reset();
            mediaPlayer.release();
            mediaPlayer=null;
        }
    }

    class Player extends AsyncTask<String,Void,Boolean>
    {

        @Override
        protected Boolean doInBackground(String... strings) {
            Boolean prepared=false;

            try {
                mediaPlayer.setDataSource(strings[0]);
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        initialStage=true;
                        playpauseMusic=false;
                        music.setImageResource(R.drawable.ic_play_arrow_black_24dp);
                        mediaPlayer.stop();
                        mediaPlayer.reset();

                    }
                });

                mediaPlayer.prepare();
                prepared=true;

            }catch (Exception e)
            {
                e.printStackTrace();
                prepared=false;
            }


            return prepared;
        }

        @Override
        protected void onPostExecute(Boolean aBoolean) {
            super.onPostExecute(aBoolean);
            if (progressDialog.isShowing())
            {
                progressDialog.cancel();
            }

            mediaPlayer.start();
            initialStage=false;

        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            progressDialog.setMessage("Buffering...");
            progressDialog.show();
        }
    }
}
