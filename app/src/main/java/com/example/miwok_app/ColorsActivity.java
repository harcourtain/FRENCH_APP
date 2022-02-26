package com.example.miwok_app;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    public MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("Red","rouge",R.drawable.color_red,R.raw.red));
        words.add(new Word("Yellow","jaune",R.drawable.color_mustard_yellow,R.raw.yellow));
//        words.add(new Word("Blue","bleu/bleue",R.drawable.color_white));
        words.add(new Word("Green","vert/verte",R.drawable.color_green,R.raw.green));
        words.add(new Word("Dusty Yellow","Jaune poussiéreux",
                R.drawable.color_dusty_yellow,R.raw.yellow));
        words.add(new Word("White","blanc/blanche",R.drawable.color_white,R.raw.white));
        words.add(new Word("Black","noir/noire",R.drawable.color_black,R.raw.black));
        words.add(new Word("Gray","gris/grise",R.drawable.color_gray,R.raw.gray));
        words.add(new Word("Brown","marron",R.drawable.color_brown,R.raw.brown));
//        words.add(new Word("Pink","rose",R.drawable.color_));
//        words.add(new Word("Vurple","violet/violette"));

        WordAdapter color=new WordAdapter(this,words,R.color.category_colors);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(color);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Word word=words.get(position);
                Toast.makeText(ColorsActivity.this,word.getEnglishTranslation()+" Is Clicked",Toast.LENGTH_SHORT).show();
                if(mediaPlayer!=null) mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioId());
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
//                 Save Memory and Battery For other tasks Using On Complete listener
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer(mediaPlayer);
                    }
                });
            }
        });
    }
    private void releaseMediaPlayer(MediaPlayer mediaPlayer) {
        // If the media player is not null, then it may be currently playing a sound.
        if (mediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mediaPlayer = null;
        }
    }
}