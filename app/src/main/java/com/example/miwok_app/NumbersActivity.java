package com.example.miwok_app;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        final ArrayList<Word> words=new ArrayList<Word>();

        words.add(new Word("Zero","zero",R.drawable.color_white,R.raw.zero));
        words.add(new Word("One","un",R.drawable.number_one,R.raw.one));
        words.add(new Word("Two","duex",R.drawable.number_two,R.raw.two));
        words.add(new Word("Three","trois",R.drawable.number_three,R.raw.three));
        words.add(new Word("Four","quatre",R.drawable.number_four,R.raw.four));
        words.add(new Word("Five","cinq",R.drawable.number_five,R.raw.five));
        words.add(new Word("Six","six",R.drawable.number_six,R.raw.six));
        words.add(new Word("Seven","sept",R.drawable.number_seven,R.raw.seven));
        words.add(new Word("Eight","huit",R.drawable.number_eight,R.raw.eight));
        words.add(new Word("Nine","neuf",R.drawable.number_nine,R.raw.nine));
        words.add(new Word("Ten","dix",R.drawable.number_ten,R.raw.ten));

//        LinearLayout rootView=(LinearLayout)findViewById(R.id.rootView);
//        for(int i=0;i<words.size();i++){
//        TextView wordView=new TextView(this);
//        wordView.setText(words.get(i));
//        rootView.addView(wordView);
//        }
        WordAdapter itemsAdapter = new WordAdapter(this,words,R.color.category_numbers);
//        listView.setAdapter(itemsAdapter);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent,View view,int position,long id){

                Word word=words.get(position);
                Toast.makeText(NumbersActivity.this,word.getEnglishTranslation()+" Is Clicked",Toast.LENGTH_SHORT).show();
//                releaseing preExisting mediaPlayer If Exist
                releaseMediaPlayer();

                if(mediaPlayer!=null) mediaPlayer.stop();  // if already playing previous
                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getAudioId());
                mediaPlayer.start(); // no need to call prepare(); create() does that for you
                // Save Memory and Battery For other tasks Using On Complete listener
                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {

                        releaseMediaPlayer();
                    }
                });

            }
        });
    }

    @Override
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




//
//                words.add("Eleven");
//                words.add("Twelve");
//                words.add("Thirteen");
//                words.add("Fourteen");
//                words.add("Fivteen");
//                words.add("Sixteen");
//                words.add("Seventeen");
//                words.add("Eighteen");
//                words.add("Nineteen");
//                words.add("Twenty");
//                words.add("Twenty One");
//                words.add("Twenty Two");
//                words.add("Twenty Three");
//                words.add("Twenty Four");
//                words.add("Twenty Five");
//                words.add("Twenty Six");
//                words.add("Twenty Seven");
//                words.add("Twenty Eight");
//                words.add("Twenty Nine");
//                words.add("Thirty ");
//                words.add("Thirty One");
//                words.add("Thirty Two");
//                words.add("Thirty Three");
//                words.add("Thirty Four");
//                words.add("Thirty Five");
//                words.add("Thirty Six");
//                words.add("Thirty Seven");
//                words.add("Thirty Eight");
//                words.add("Thirty Nine");
//                words.add("Fourty ");
//                words.add("Fourty One");
//                words.add("Fourty Two");
//                words.add("Fourty Three");
//                words.add("Fourty Four");
//                words.add("Fourty Five");
//                words.add("Fourty Six");
//                words.add("Fourty Seven");
//                words.add("Fourty Eight");
//                words.add("Fourty Nine");
//                words.add("Fifty ");
//                words.add("Fifty One");
//                words.add("Fifty Two");
//                words.add("Fifty Three");
//                words.add("Fifty Four");
//                words.add("Fifty Five");
//                words.add("Fifty Six");
//                words.add("Fifty Seven");
//                words.add("Fifty Eight");
//                words.add("Fifty Nine");
//                words.add("Sixty ");
//                words.add("Sixty One");
//                words.add("Sixty Two");
//                words.add("Sixty Three");
//                words.add("Sixty Four");
//                words.add("Sixty Five");
//                words.add("Sixty Six");
//                words.add("Sixty Seven");
//                words.add("Sixty Eight");
//                words.add("Sixty Nine");
//                words.add("Seventy ");
//                words.add("Seventy One");
//                words.add("Seventy Two");
//                words.add("Seventy Three");
//                words.add("Seventy Four");
//                words.add("Seventy Five");
//                words.add("Seventy Six");
//                words.add("Seventy Seven");
//                words.add("Seventy Eight");
//                words.add("Seventy Nine");
//                words.add("Eighty ");
//                words.add("Eighty One");
//                words.add("Eighty Two");
//                words.add("Eighty Three");
//                words.add("Eighty Four");
//                words.add("Eighty Five");
//                words.add("Eighty Six");
//                words.add("Eighty Seven");
//                words.add("Eighty Eight");
//                words.add("Eighty Nine");
//                words.add("Ninety ");
//                words.add("Ninety One");
//                words.add("Ninety Two");
//                words.add("Ninety Three");
//                words.add("Ninety Four");
//                words.add("Ninety Five");
//                words.add("Ninety Six");
//                words.add("Ninety Seven");
//                words.add("Ninety Eight");
//                words.add("Ninety Nine");
//                words.add("Hundred");
//                words.add("One Hundred One");
//                words.add("One Hundred Two");
//                words.add("One Hundred Three");
//                words.add("One Hundred Four");
//                words.add("One Hundred Five");
//                words.add("One Hundred Six");
//                words.add("One Hundred Seven");
//                words.add("One Hundred Eight");
//                words.add("One Hundred Nine");
//                words.add("One Hundred Ten");
//                words.add("One Hundred Eleven");
//                words.add("One Hundred Twelve");
//                words.add("One Hundred Thirteen");
//                words.add("One Hundred Fourteen");
//                words.add("One Hundred Fivteen");
//                words.add("One Hundred Sixteen");
//                words.add("One Hundred Seventeen");
//                words.add("One Hundred Eighteen");
//                words.add("One Hundred Nineteen");
//                words.add("One Hundred Twenty");
//                words.add("One Hundred Twenty One");
//                words.add("One Hundred Twenty Two");
//                words.add("One Hundred Twenty Three");
//                words.add("One Hundred Twenty Four");
//                words.add("One Hundred Twenty Five");
//                words.add("One Hundred Twenty Six");
//                words.add("One Hundred Twenty Seven");
//                words.add("One Hundred Twenty Eight");
//                words.add("One Hundred Twenty Nine");
//                words.add("One Hundred Thirty ");
//                words.add("One Hundred Thirty One");
//                words.add("One Hundred Thirty Two");
//                words.add("One Hundred Thirty Three");
//                words.add("One Hundred Thirty Four");
//                words.add("One Hundred Thirty Five");
//                words.add("One Hundred Thirty Six");
//                words.add("One Hundred Thirty Seven");
//                words.add("One Hundred Thirty Eight");
//                words.add("One Hundred Thirty Nine");
//                words.add("One Hundred Fourty ");
//                words.add("One Hundred Fourty One");
//                words.add("One Hundred Fourty Two");
//                words.add("One Hundred Fourty Three");
//                words.add("One Hundred Fourty Four");
//                words.add("One Hundred Fourty Five");
//                words.add("One Hundred Fourty Six");
//                words.add("One Hundred Fourty Seven");
//                words.add("One Hundred Fourty Eight");
//                words.add("One Hundred Fourty Nine");
//                words.add("One Hundred Fifty ");
//                words.add("One Hundred Fifty One");
//                words.add("One Hundred Fifty Two");
//                words.add("One Hundred Fifty Three");
//                words.add("One Hundred Fifty Four");
//                words.add("One Hundred Fifty Five");
//                words.add("One Hundred Fifty Six");
//                words.add("One Hundred Fifty Seven");
//                words.add("One Hundred Fifty Eight");
//                words.add("One Hundred Fifty Nine");
//                words.add("One Hundred Sixty ");
//                words.add("One Hundred Sixty One");
//                words.add("One Hundred Sixty Two");
//                words.add("One Hundred Sixty Three");
//                words.add("One Hundred Sixty Four");
//                words.add("One Hundred Sixty Five");
//                words.add("One Hundred Sixty Six");
//                words.add("One Hundred Sixty Seven");
//                words.add("One Hundred Sixty Eight");
//                words.add("One Hundred Sixty Nine");
//                words.add("One Hundred Seventy ");
//                words.add("One Hundred Seventy One");
//                words.add("One Hundred Seventy Two");
//                words.add("One Hundred Seventy Three");
//                words.add("One Hundred Seventy Four");
//                words.add("One Hundred Seventy Five");
//                words.add("One Hundred Seventy Six");
//                words.add("One Hundred Seventy Seven");
//                words.add("One Hundred Seventy Eight");
//                words.add("One Hundred Seventy Nine");
//                words.add("One Hundred Eighty ");
//                words.add("One Hundred Eighty One");
//                words.add("One Hundred Eighty Two");
//                words.add("One Hundred Eighty Three");
//                words.add("One Hundred Eighty Four");
//                words.add("One Hundred Eighty Five");
//                words.add("One Hundred Eighty Six");
//                words.add("One Hundred Eighty Seven");
//                words.add("One Hundred Eighty Eight");
//                words.add("One Hundred Eighty Nine");
//                words.add("One Hundred Ninety ");
//                words.add("One Hundred Ninety One");
//                words.add("One Hundred Ninety Two");
//                words.add("One Hundred Ninety Three");
//                words.add("One Hundred Ninety Four");
//                words.add("One Hundred Ninety Five");
//                words.add("One Hundred Ninety Six");
//                words.add("One Hundred Ninety Seven");
//                words.add("One Hundred Ninety Eight");
//                words.add("One Hundred Ninety Nine");
//                words.add("Two Hundred");