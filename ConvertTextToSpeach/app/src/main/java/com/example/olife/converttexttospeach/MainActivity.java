package com.example.olife.converttexttospeach;

import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private EditText etText;

    private TextToSpeech tts;

    private  int result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeSpeech();
    }

    private  void  initializeSpeech(){
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
        @Override
        public void onInit(int i) {
            if(i==TextToSpeech.SUCCESS){
                result = tts.setLanguage(Locale.ENGLISH);
            }
            else {
                Toast.makeText(getApplicationContext(),"this feature is not supported",Toast.LENGTH_LONG).show();
            }
        }
        });
    }


    public void clickAction(View view){
        etText = findViewById(R.id.etText);
        String text = etText.getText().toString();

        if(result == TextToSpeech.LANG_NOT_SUPPORTED || result == TextToSpeech.LANG_MISSING_DATA){
            Toast.makeText(getApplicationContext(),"this feature is not supported",Toast.LENGTH_LONG).show();
        }
        else{
            tts.speak(text,TextToSpeech.QUEUE_FLUSH,null);
        }
    }

    @Override
    protected void onDestroy() {
        if(tts!=null){
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }

    @Override
    protected void onPause() {
        if(tts!=null){
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }
}
