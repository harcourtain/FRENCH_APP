package com.example.miwok_app;

public class Word {
    private String mEnglishTranslation;
    private String mFenchTranslation,mAdd;
    private int mImageResourceId;
    private int audioId;
    public Word(String englishWord,String frenchWord){
        mEnglishTranslation=englishWord;
        mFenchTranslation=frenchWord;
    }
    public Word(String englishWord,String frenchWord,int resourseId,int audioRef){
        mEnglishTranslation=englishWord;
        mFenchTranslation=frenchWord;
        mImageResourceId=resourseId;
        audioId=audioRef;
    }
    public int getAudioId() {
        return audioId;
    }
    public int getImageResourseId() {
        return mImageResourceId;
    }
    public String getEnglishTranslation() {
        return mEnglishTranslation;
    }

    public String getFrenchTranslation() {
        return mFenchTranslation;
    }
}
