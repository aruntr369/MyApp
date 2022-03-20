package com.arun.myapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CameraEx extends AppCompatActivity {

    private Button btn;
    private ImageView imageView;
    private static final int Image_Capture_Code=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera_ex);

        btn=(Button) findViewById(R.id.btnCamera);
        imageView=(ImageView) findViewById(R.id.imgCamera);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cInt=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cInt,Image_Capture_Code);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Image_Capture_Code){

            if(resultCode == RESULT_OK){
                Bitmap bitmap=(Bitmap) data.getExtras().get("data");
                imageView.setImageBitmap(bitmap);

            }else if(resultCode == RESULT_CANCELED){
                Toast.makeText(this, "Action Cancelled", Toast.LENGTH_SHORT).show();
            }
        }
    }
}