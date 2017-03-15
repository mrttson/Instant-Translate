package com.feed2me.texttranslatewithcloud;

import android.os.AsyncTask;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.cloud.translate.Translate;
import com.google.cloud.translate.TranslateOptions;
import com.google.cloud.translate.Translation;

public class MainActivity extends AppCompatActivity {
    private static final String API_KEY = "AIzaSyCcNB0pTrLvwqPLtzwQXL99on-6fSQzCB0";
    private static final String LANG_VI = "vi";
    private static final String LANG_EN = "en";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText edtInput = (EditText) findViewById(R.id.edtInput);
        final TextView tvOutput = (TextView) findViewById(R.id.tvOutput);
        final Handler textViewHandler = new Handler();

        Button btnTranslate = (Button) findViewById(R.id.btnTranslate);
        btnTranslate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String input = edtInput.getText().toString();

                new AsyncTask<Void, Void, Void>() {
                    @Override
                    protected Void doInBackground(Void... params) {
                        TranslateOptions options = TranslateOptions.newBuilder()
                                .setApiKey(API_KEY)
                                .build();
                        Translate translate = options.getService();
                        final Translation translation =
                                translate.translate(input,
                                        Translate.TranslateOption.
                                                sourceLanguage(LANG_EN).
                                                targetLanguage(LANG_VI));
                        textViewHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                if (tvOutput != null) {
                                    tvOutput.setText(translation.getTranslatedText());
                                }
                            }
                        });
                        return null;
                    }
                }.execute();
            }
        });
    }
}
