package com.example.generatorpassword;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Generate extends AppCompatActivity {
    String chaine = "";
    CheckBox box1;
    CheckBox box2;
    CheckBox box3;
    CheckBox box4;
    SeekBar bar;
    Button btn;
    TextView textview;
    boolean b1;
    ClipboardManager myClipboard;
    TextView view;


    public void copy(View copy) {
        myClipboard = (ClipboardManager) getSystemService(CLIPBOARD_SERVICE);
        String text;
        text = textview.getText().toString();

        myClipboard.setPrimaryClip(ClipData.newPlainText("text", text));

        Toast.makeText(getApplicationContext(), "Text Copied", Toast.LENGTH_SHORT).show();


    }

    public void onCheckboxClicked(View onCheckboxClicked) {
        // Is the view now checked?
        boolean checked = ((CheckBox) onCheckboxClicked).isChecked();

        // Check which checkbox was clickedonCheckboxClicked
        switch (onCheckboxClicked.getId()) {
            case R.id.box1:
                if (checked) {

                }
                chaine += "1234567890";


                break;
            case R.id.box2:
                if (checked) {
                    chaine += "ABCDEFGHIJKLMNOPQRSTWXYZ";
                }


                break;
            case R.id.box3:
                if (checked) {
                    chaine += "abcdefghijklmnopqrstwxyz";
                }


                break;
            case R.id.box4:
                if (checked) {
                    chaine += ">^|[{#&(-_)=+<µ%¨£/.§#~";
                }
                break;


        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generate);
        getSupportActionBar().setTitle("Generate password");
        box1 = (CheckBox) (findViewById(R.id.box1));
        box2 = (CheckBox) (findViewById(R.id.box2));
        box3 = (CheckBox) (findViewById(R.id.box3));
        box4 = (CheckBox) (findViewById(R.id.box4));
        bar = (findViewById(R.id.seekBar2));
        btn = (findViewById(R.id.generate));
        textview = (findViewById(R.id.view));
        view = (findViewById(R.id.view1));

        //   textview2=(findViewById(R.id.view2));
        //  textview2=(findViewById(R.id.view2));

        final int[] pval = {0};
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pval[0] = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //write custom code to on start progress
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                view.setText("Length " + pval[0]);


            }
        });


        btn.setOnClickListener(new View.OnClickListener() {
            @Override


            public void onClick(View v) {

                //  textview2.setText(pval[0]);
                char[] ch = chaine.toCharArray();
                Random rand = new Random();
                StringBuilder string = new StringBuilder();
                for (int i = 0; i < pval[0]; i++) {
                    char cha = ch[rand.nextInt(ch.length)];

                    string.append(cha);
                }

                // String a=""+box1.isChecked();
                textview.setText(string.toString());


            }
        });


    }

}




