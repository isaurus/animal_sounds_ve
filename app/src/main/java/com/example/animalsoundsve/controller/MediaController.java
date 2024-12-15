package com.example.animalsoundsve.controller;

import android.content.Context;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.view.View;
import android.widget.ImageView;

import com.example.animalsoundsve.R;

import java.util.List;

public class MediaController {

    private final DataManager dtManager;
    private MediaPlayer mp;
    private final SoundPool sp = new SoundPool.Builder().setMaxStreams(12).build();
    private final int[] soundIdList = new int[12];

    public MediaController(){
        dtManager = new DataManager();
    }

    public void setBackground(ImageView imageView, int scenario, Context ctx){
        switch (scenario){
            case 1:
                imageView.setImageResource(R.drawable.farm_background);
                mp = MediaPlayer.create(ctx, R.raw.farm_sound);
                break;
            case 2:
                imageView.setImageResource(R.drawable.wild_background);
                mp = MediaPlayer.create(ctx, R.raw.wild_sound);
                break;
        }
        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        imageView.setAlpha(0.5f);

        if(mp.isPlaying()){
            mp.stop();
            mp.release();
        }else if(!mp.isPlaying()){
            mp.setVolume(0.2f, 0.2f);
            mp.setLooping(true);
            mp.start();
        }

    }

    public void setImagesToAnimal(List<ImageView> animalList, int scenario){
        if(scenario == 1){
            for(int i = 0; i < animalList.size(); i++){
                animalList.get(i).setImageResource(dtManager.getFarmAnimals().get(i).getDrawableResource());
                animalList.get(i).setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        } else if(scenario == 2){
            for(int i = 0; i < animalList.size(); i++){
                animalList.get(i).setImageResource(dtManager.getWildAnimals().get(i).getDrawableResource());
                animalList.get(i).setScaleType(ImageView.ScaleType.CENTER_CROP);
            }
        }
    }

    public void setSoundsToAnimal(List<ImageView> animalList, int scenario, Context ctx){
        int currentRawRes;
        if(scenario == 1){
            for (int i = 0; i < animalList.size(); i++){
                final int a = i;
                currentRawRes = dtManager.getFarmAnimals().get(i).getRawResource();
                soundIdList[i] = sp.load(ctx, currentRawRes, 1);
                animalList.get(i).setOnClickListener(v -> playAnimalSound(ctx, soundIdList[a]));
            }
        } else if (scenario == 2) {
            for (int i = 0, j = 6; i < animalList.size(); i++, j++){
                final int a = i;
                final int b = j;
                currentRawRes = dtManager.getWildAnimals().get(i).getRawResource();
                soundIdList[j] = sp.load(ctx, currentRawRes, 1);
                sp.load(ctx, currentRawRes, 1);
                animalList.get(i).setOnClickListener(v -> playAnimalSound(ctx, soundIdList[b]));
            }
        }
    }

    private void playAnimalSound(Context ctx, int rawResource) {
        sp.play(rawResource, 1, 1, 1, 0, 1);
    }


}
