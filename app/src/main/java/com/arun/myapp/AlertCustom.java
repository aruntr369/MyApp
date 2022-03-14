package com.arun.myapp;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class AlertCustom extends AppCompatActivity {
    private static final String TAG = "AlertCustom";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_custom);
    }

    public void simpleAlert(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("tittle");
        builder.setMessage("massage");
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertCustom.this, "ok clicked", Toast.LENGTH_SHORT).show();

            }
        });
        builder.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertCustom.this, android.R.string.no, Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        builder.show();
    }

    public void withItems(View view) {
        final String[] items={"aa","bb","cc","dd"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("List Of Items").setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertCustom.this, items[i]+" is clicked", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setPositiveButton("ok",null);
        //builder.setPositiveButtonIcon(getResources().getDrawable(R.drawable.orangeicon));
        builder.setPositiveButtonIcon(getResources().getDrawable(android.R.drawable.btn_star,getTheme()));
        builder.setIcon(getResources().getDrawable(android.R.drawable.ic_dialog_map,getTheme()));
        builder.setNegativeButton("no",null);

        AlertDialog alertDialog=builder.create();
        alertDialog.show();

        Button button=alertDialog.getButton(DialogInterface.BUTTON_POSITIVE);
        button.setBackgroundColor(Color.GREEN);
        button.setPadding(0,0,5,3);
        button.setTextColor(Color.YELLOW);


    }

    public void withMultiChoiceItems(View view) {
        final String[] items={"aa","bb","cc","dd"};
        final ArrayList<Integer> selectedList =new ArrayList<>();

        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setTitle("choose any");
        builder.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if(b){
                    Log.d(TAG, "onClick: " +i);
                    selectedList.add(i);
                }else if(selectedList.contains(i)){
                    selectedList.remove(Integer.valueOf(i));

                }
            }
        });
        builder.setPositiveButton("Done", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                ArrayList<String> selectedString =new ArrayList<>();
                for (int j=0;j<selectedList.size();j++){
                    selectedString.add(items[selectedList.get(j)]);
                }
                Toast.makeText(AlertCustom.this, "Items selected are: " + Arrays.toString(selectedString.toArray()), Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void withEditText(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("With Edit Text");

        final EditText input = new EditText(AlertCustom.this);
        LinearLayout.LayoutParams lp=new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        input.setLayoutParams(lp);
        builder.setView(input);
        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertCustom.this, "Text Entered "+input.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void withImageView(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogLayoutt=inflater.inflate(R.layout.alert_view_with_img,null);
        builder.setView(dialogLayoutt);
        builder.setPositiveButton("ok",null);
        builder.show();
    }

    public void withSeekBar(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("With SeekBar");
        final SeekBar seekBar = new SeekBar(AlertCustom.this);
        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT);
        seekBar.setLayoutParams(lp);
        builder.setView(seekBar);
        builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                Toast.makeText(getApplicationContext(), "Alert Dialog is dismissed", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Progress is " + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    public void withRatingBar(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        builder.setTitle("With RatingBar");
        View dialogLayout = inflater.inflate(R.layout.alert_dialog_with_ratingbar, null);
        final RatingBar ratingBar = dialogLayout.findViewById(R.id.ratingBar2);
        builder.setView(dialogLayout);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), "Rating is " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }
}