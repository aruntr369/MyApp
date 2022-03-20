package connectionss;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.arun.myapp.R;

public class SMSactivity extends AppCompatActivity {

    EditText phonenumber,message;
    Button send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smsactivity);

        send=findViewById(R.id.btnSend);
        phonenumber=findViewById(R.id.eTNo);
        message=findViewById(R.id.eTMessage);

        send.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                String number =phonenumber.getText().toString();
                String msg=message.getText().toString();
                try {
                    if (Build.VERSION.SDK_INT > 22) {

                        if (ActivityCompat.checkSelfPermission(SMSactivity.this, Manifest.permission.SEND_SMS) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(SMSactivity.this, new String[]{Manifest.permission.SEND_SMS}, 122);
                            return;
                        }
                    }


                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(number, null, msg, null, null);
                    Toast.makeText(SMSactivity.this, "Message Sent", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(SMSactivity.this, "some fields are EMPTY", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}