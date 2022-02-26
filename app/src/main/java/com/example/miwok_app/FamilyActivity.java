package com.example.miwok_app;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        final ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("Brother","un frère",R.drawable.family_younger_brother,R.raw.brother));
        words.add(new Word("Sister","une sœur",R.drawable.family_younger_sister,R.raw.sister));
        words.add(new Word("Father","un père",R.drawable.family_father,R.raw.father));
        words.add(new Word("Mother","une mère",R.drawable.family_mother,R.raw.mother));
        words.add(new Word("Son","un fils",R.drawable.family_son,R.raw.son));
        words.add(new Word("Daughter","une fille",R.drawable.family_daughter,R.raw.daughter));
        words.add(new Word("Wife","une femme",R.drawable.family_mother,R.raw.wife));
        words.add(new Word("Husband","un mari",R.drawable.family_father,R.raw.husband));
        words.add(new Word("Spouse","un époux",R.drawable.family_older_sister,R.raw.wife));
        words.add(new Word("Uncle","gris/grise",R.drawable.family_older_brother,R.raw.aunt));
        words.add(new Word("Aunt","une nièce",R.drawable.family_older_sister,R.raw.aunt));
        words.add(new Word("Cousin – male","un cousin",R.drawable.family_older_brother,R.raw.cousim));
        words.add(new Word("Cousin – female","une cousine",R.drawable.family_older_sister,R.raw.cousim));
        words.add(new Word("Grandfather","un grand-père",R.drawable.family_grandfather,R.raw.grandfather));
        words.add(new Word("Great grandmother","arrière-grand-mère",R.drawable.family_grandmother,R.raw.grandmother));

        WordAdapter family=new WordAdapter(this,words,R.color.category_family);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(family);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override

            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Word word=words.get(position);
                Toast.makeText(FamilyActivity.this,word.getEnglishTranslation()+" Is Clicked",Toast.LENGTH_SHORT).show();
                if(mediaPlayer!=null) mediaPlayer.stop();  // if already playing previous
                mediaPlayer = MediaPlayer.create(FamilyActivity.this, word.getAudioId());
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                // Save Memory and Battery For other tasks Using On Complete listener
//                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
//                    @Override
//                    public void onCompletion(MediaPlayer mediaPlayer) {
//                        releaseMediaPlayer(mediaPlayer);
//                    }
//                });
            }
        });
    }
    @Override
    //When User Press Home Button the audio file stops playing
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    private void releaseMediaPlayer() {
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