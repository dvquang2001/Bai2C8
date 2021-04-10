package com.example.bai2c8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {
    ListView lvMsgList;
    ArrayAdapter<TinNhan> adapter;
    IntentFilter filter=new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
    BroadcastReceiver smsReceiver=new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            xuLyDocTinNhan(context,intent);
        }
    };

    private void xuLyDocTinNhan(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        Object[] arrMessage = (Object[]) bundle.get("pdus");

        for(int i =0;i<arrMessage.length;i++)
        {
            SmsMessage message = SmsMessage.createFromPdu((byte[]) arrMessage[i]);
            String noidung = message.getMessageBody();
            String phone = message.getDisplayOriginatingAddress();
            long time = message.getTimestampMillis();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss dd/MM/yyyy");
            Date date = new Date(time);
            String stime = sdf.format(date);
            adapter.add(new TinNhan(stime,phone,noidung));
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        addControls();
    }

    private void addControls() {
        lvMsgList = findViewById(R.id.lvMsgList);
        adapter = new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1);
        lvMsgList.setAdapter(adapter);
    }
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(smsReceiver,filter);
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(smsReceiver);
    }
}