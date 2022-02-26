package com.example.miwok_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);
        ArrayList<Word> words=new ArrayList<Word>();
        words.add(new Word("Hello","Bonjour"));
        words.add(new Word("Thank you","Merci"));
        words.add(new Word("Please","S’il vous plaît"));
        words.add(new Word("How are you?","Comment allez-vous ?"));
        words.add(new Word("My name is...","Je m’appelle..."));
        words.add(new Word("I don't understand","Je ne comprends pas"));
        words.add(new Word("I don't know","Je ne sais pas"));
        words.add(new Word("What does ___ mean?","Que veut dire ___ ? "));
        words.add(new Word("Where is ...?","Où est … ?"));
        words.add(new Word("Can you help me?","Pouvez-vous m’aider?"));
        words.add(new Word("I would like...","Je voudrais... "));

        WordAdapter phrases=new WordAdapter(this,words,R.color.category_phrases);
        ListView listView=(ListView)findViewById(R.id.list);
        listView.setAdapter(phrases);

    }
}