package com.f2m.texttranslate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.f2m.translateapi.web_api_translate.GoogleTranslator;
import com.f2m.translateapi.web_api_translate.type.Language;
import com.f2m.translateapi.web_api_translate.type.TranslateError;

public class MainActivity extends AppCompatActivity {

    Button btnExec;
    Button btnTranslateWithFromTo;
    EditText edtInput;
    String API_KEY = "AIzaSyCcNB0pTrLvwqPLtzwQXL99on-6fSQzCB0";
    TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtInput = (EditText) findViewById(R.id.edtInput);
        tvOutput = (TextView) findViewById(R.id.tvOutput);
        btnExec = (Button) findViewById(R.id.btnExec);
        btnExec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                GoogleTranslator.getInstance().execute(edtInput.getText().toString(), Language.VIETNAMESE, API_KEY, new GoogleTranslator.Callback() {

                    @Override
                    public void onSuccess(Language detected_lang, String translated_text) {
                        Log.d("TTS", "detected_lang" + detected_lang);
                        tvOutput.setText(translated_text);
                    }

                    @Override
                    public void onFailed(TranslateError e) {
                        Log.d("TTS", "onFailed");
                    }
                });
            }
        });

//        btnTranslateWithFromTo = (Button)findViewById(R.id.btnTranslateWithFromTo);
//        btnTranslateWithFromTo.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // TODO Auto-generated method stub
//                String InputString;
//                String OutputString = null;
//                InputString = edtInput.getText().toString();
//
//                try {
//                    com.google.api.translate.Translate.setHttpReferrer("http://android-er.blogspot.com/");
//                    OutputString = com.google.api.translate.Translate.execute(InputString,
//                            com.google.api.translate.ENGLISH, com.google.api.translate.VIETNAMESE);
//                } catch (Exception ex) {
//                    ex.printStackTrace();
//                    OutputString = "Error";
//                }
//
//                tvOutput.setText(OutputString);
//
//            }
//        });
    }



}
