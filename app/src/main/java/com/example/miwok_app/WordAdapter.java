package com.example.miwok_app;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
public class WordAdapter extends ArrayAdapter<Word> {
    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    private int mColor;
    public WordAdapter(Activity context,ArrayList<Word> words,int color){
        super(context,0,words);
        mColor=color;

    }


    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        View listItemview=convertView;
        if(listItemview==null)
        {
            listItemview= LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }
        Word current=getItem(position);
        TextView txt=(TextView)listItemview.findViewById(R.id.englishWord);
        txt.setText(current.getEnglishTranslation());
        TextView txt1=(TextView)listItemview.findViewById(R.id.frenchWord);
        txt1.setText(current.getFrenchTranslation());
        ImageView imageView = (ImageView)listItemview.findViewById(R.id.photo);

        if(current.getImageResourseId()!=0)
            imageView.setImageResource(current.getImageResourseId());
        else
            imageView.setVisibility(View.GONE);

        View textContainer=listItemview.findViewById(R.id.text_container);
        int color= ContextCompat.getColor(getContext(),mColor);
        textContainer.setBackgroundColor(color);

        return listItemview;
    }
}
////