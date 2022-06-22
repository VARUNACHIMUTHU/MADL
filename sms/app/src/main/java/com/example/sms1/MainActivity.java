package com.example.sms1;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat; import android.app.NotificationChannel; import android.app.NotificationManager;


import android.app.PendingIntent; import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsManager; import android.view.View;
import android.widget.Button; import android.widget.EditText;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity { EditText txtphoneNo, txtMessage;
    Button sendSMS;
    String phoneNo, message; @Override
    protected void onCreate(Bundle savedInstanceState) { super.onCreate(savedInstanceState); setContentView(R.layout.activity_main);
        sendSMS = (Button) findViewById(R.id.btnSendSMS); txtphoneNo = (EditText) findViewById(R.id.editText); txtMessage = (EditText) findViewById(R.id.editText2); sendSMS.setOnClickListener(new View.OnClickListener() { @RequiresApi(api = Build.VERSION_CODES.O)
        @Override
        public void onClick(View view) {
            phoneNo = txtphoneNo.getText().toString(); message = txtMessage.getText().toString(); try {
                SmsManager smsManager = SmsManager.getDefault(); smsManager.sendTextMessage(phoneNo, null, message, null, null); Toast.makeText(getApplicationContext(), "SMS sent.", Toast.LENGTH_LONG).show();
                Intent smsIntent = new Intent(MainActivity.this, SmsReceiver.class); smsIntent.putExtra("address", phoneNo); smsIntent.putExtra("sms_body", message);
//startActivity(smsIntent);
                NotificationManager smsnm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
                final String CHANNEL_ID = "my_channel_01"; CharSequence name = "my_notification";
                NotificationChannel smsnc = new NotificationChannel(CHANNEL_ID, name, NotificationManager.IMPORTANCE_DEFAULT); smsnc.setDescription("New Notification"); smsnm.createNotificationChannel(smsnc);
                PendingIntent pi = PendingIntent.getActivity(MainActivity.this, 0, smsIntent, PendingIntent.FLAG_UPDATE_CURRENT); smsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                NotificationCompat.Builder builder=new NotificationCompat.Builder(MainActivity.this,CHANNEL_ID)
                        .setContentTitle("New Message from "+phoneNo)
                        .setContentText(message)

.setSmallIcon(R.mipmap.ic_launcher)
                        .setContentIntent(pi)
                        .setAutoCancel(true); smsnm.notify(1,builder.build());
            } catch (Exception e) { Toast.makeText(getApplicationContext(), "Sending SMS failed.", Toast.LENGTH_LONG).show(); e.printStackTrace();
            }
        }
        });
    }
}
