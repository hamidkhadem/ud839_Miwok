package com.example.android.miwok;

public class Word<NO_IMAGE_PROVIDED> {
    private String mDefaultTranslation;
    private String mMiwokTranslation;
    private int mImageResourceId = 0;
    private static final int NO_IMAGE_PROVIDED = -1;
    //Add variable for source id of audio word
    private int mIdOfAudio;

    public Word(String defaultTranslation, String miwokTranslation){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResourceId;
    }


    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }


}
