package com.example.mymusik;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    //Deklarasi Variable
    Button play, stop, pause;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Inisialisasi Button
        play = findViewById(R.id.btnplay);
        stop = findViewById(R.id.btnstop);
        pause = findViewById(R.id.btnpause);

        play.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.yoi);

                play.setEnabled(false);
                stop.setEnabled(true);
                pause.setEnabled(true);



                try {
                    mediaPlayer.prepare();
                }catch (IllegalStateException e) {
                    e.printStackTrace();
                }catch (IOException e) {
                    e.printStackTrace();
                }mediaPlayer.start();

            }
        });

        stop.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                play.setEnabled(true);
                pause.setEnabled(false);
                stop.setEnabled(false);

                mediaPlayer.stop();
                try {
                    //Menyetel audio ke status awal
                    mediaPlayer.prepare();
                    mediaPlayer.seekTo(0);
                }catch (Throwable t){
                    t.printStackTrace();
                }

            }
        });
        pause.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mediaPlayer.isPlaying()){
                    if(mediaPlayer != null){
                        mediaPlayer.pause();
                        //pouse.setText("Lanjutkan");
                    }
                }else {

                    //Jika audio sedang di pause, maka audio dapat dilanjutkan kembali
                    if(mediaPlayer != null){
                        mediaPlayer.start();
                        //pouse.setText("Pause");
                    }
                }

            }
        });


    }

}
