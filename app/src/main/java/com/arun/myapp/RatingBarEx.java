package com.arun.myapp;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

public class RatingBarEx extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating_bar_ex);

        RatingBar ra=(RatingBar) findViewById(R.id.ratingBar);
        Button bu=(Button) findViewById(R.id.subBtn);
        TextView tv=(TextView) findViewById(R.id.tvRating);

        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int noOfStars=ra.getNumStars();
                float rating =ra.getRating();
                tv.setText("Rating: "+rating+"/"+noOfStars);
            }
        });


    }
}