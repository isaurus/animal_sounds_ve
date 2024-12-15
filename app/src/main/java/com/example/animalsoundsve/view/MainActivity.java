package com.example.animalsoundsve.view;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.animalsoundsve.R;
import com.example.animalsoundsve.controller.DataManager;
import com.example.animalsoundsve.controller.MediaController;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageView imgBackground;
    private List<ImageView> animalList;
    private MediaController mediaController;
    private DataManager dtManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setSupportActionBar(findViewById(R.id.materialToolbar));

        initComponents();
    }

    public void initComponents(){
        dtManager = new DataManager();
        dtManager.loadData();

        mediaController = new MediaController();

        imgBackground = findViewById(R.id.imgBackground);

        animalList = new ArrayList<>();
        animalList.add(findViewById(R.id.img1));
        animalList.add(findViewById(R.id.img2));
        animalList.add(findViewById(R.id.img3));
        animalList.add(findViewById(R.id.img4));
        animalList.add(findViewById(R.id.img5));
        animalList.add(findViewById(R.id.img6));

        mediaController.setBackground(imgBackground, 1, this);
        mediaController.setImagesToAnimal(animalList, 1);
        mediaController.setSoundsToAnimal(animalList, 1, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = new MenuInflater(this);
        inflater.inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int itemId = item.getItemId();
        int scenario = 0;
        if(itemId == R.id.itemExit){
            showAlertDialog();
        } else if(itemId == R.id.itemWild){
            scenario = 2;
        } else if(itemId == R.id.itemFarm){
            scenario = 1;
        }
        mediaController.setBackground(imgBackground, scenario, this);
        mediaController.setImagesToAnimal(animalList, scenario);
        mediaController.setSoundsToAnimal(animalList, scenario, this);
        return super.onOptionsItemSelected(item);
    }

    public void showAlertDialog(){
        new AlertDialog.Builder(this)
                .setTitle(R.string.dialog_title)
                .setMessage(R.string.dialog_subtitle)
                .setNegativeButton(R.string.btn_no, null)
                .setPositiveButton(R.string.btn_yes, (dialog, which) -> finishAffinity())
                .create()
                .show();
    }
}