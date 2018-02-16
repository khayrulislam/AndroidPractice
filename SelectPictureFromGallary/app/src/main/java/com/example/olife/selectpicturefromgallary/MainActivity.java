package com.example.olife.selectpicturefromgallary;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button choose;
    private ImageView im;
    private int GALLARY_REQUEST = 1;
    private String TAG="tag";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        choose = findViewById(R.id.button);
        im = findViewById(R.id.imageView);
    }

    public void clickAction(View view){
        getGallary();
    }

    private void getGallary(){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        intent.setType("image/*");
        startActivityForResult(intent.createChooser(intent,"Select File"),GALLARY_REQUEST);
        //startActivityForResult(intent,GALLARY_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == Activity.RESULT_OK && requestCode == GALLARY_REQUEST){
            Uri selectUri = data.getData();
            im.setImageURI(selectUri);
        }
    }
}
