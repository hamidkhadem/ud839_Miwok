package com.example.android.miwok;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    //Create media Player
    MediaPlayer mediaPlayer;
    //Create Audio manger
    AudioManager audioManager;

    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };


    private void releaseMediaPlayer() {
        if(mediaPlayer != null){
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        //Creat ArrayAapter
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "takaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "topoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "weṭeṭṭi", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        //Create specific adapter for lis
        WordAdapter wordAdapter = new WordAdapter(this,words, R.color.category_colors);
        //Create listview and add adapter to it
        ListView listView = findViewById(R.id.list);
        listView.setAdapter(wordAdapter);

        //click listener to play audio
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                //release media player
                releaseMediaPlayer();

                //find the word that click
                Word word = words.get(position);
                //prepare mediaPlayer
                mediaPlayer = MediaPlayer.create(ColorsActivity.this , word.getmAudioResourceId());
                //play audio
                mediaPlayer.start();

                //set on completion
                mediaPlayer.setOnCompletionListener(mCompletionListener);

            }
        });

    }


}
