package com.example.android_resapi.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.android_resapi.R;

import java.net.URL;
import android.os.Message;

//import androidx.core.app.NotificationCompat;
//import androidx.core.app.NotificationManagerCompat;


public class MainActivity extends AppCompatActivity {
    final static String TAG = "AndroidAPITest";

    EditText listThingsURL, thingShadowURL, getLogsURL;
    private final Handler handler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message msg) {
            if (msg.what == 1) {
                showNotification(); // 1분 후에 알림 표시
            }
            return true;
        }
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // listThingsURL = findViewById(R.id.listThingsURL);
        // thingShadowURL = findViewById(R.id.thingShadowURL);
        // getLogsURL = findViewById(R.id.getLogsURL);

        Button listThingsBtn = findViewById(R.id.listThingsBtn);
        listThingsBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // String urlstr = listThingsURL.getText().toString();
                // Log.i(TAG, "listThingsURL=" + urlstr);
                Intent intent = new Intent(MainActivity.this, ListThingsActivity.class);
                // intent.putExtra("listThingsURL", listThingsURL.getText().toString());
                startActivity(intent);
                //  new GetThings(MainActivity.this).execute();
                //  new GetThingShadow(MainActivity.this, "MyMKRWiFi1010").execute();

            }
        });
        startCountdownTimer();
        Button thingShadowBtn = findViewById(R.id.thingShadowBtn);
        thingShadowBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // String urlstr = thingShadowURL.getText().toString();
                Intent intent = new Intent(MainActivity.this, DeviceActivity.class);
                // intent.putExtra("thingShadowURL", thingShadowURL.getText().toString());
                startActivity(intent);

            }
        });

        Button listLogsBtn = findViewById(R.id.listLogsBtn);
        listLogsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // String urlstr = getLogsURL.getText().toString();
                Intent intent = new Intent(MainActivity.this, LogActivity.class);
                // intent.putExtra("getLogsURL", getLogsURL.getText().toString());
                startActivity(intent);
            }
        });
    }

    private void startCountdownTimer() {
        handler.sendEmptyMessageDelayed(1, 3000); // 1분을 밀리초로 설정
    }

    private void showNotification() {
        // 알림 대신 Toast 메시지를 사용합니다.
        Toast.makeText(MainActivity.this, "1시간이 경과했습니다!", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 메모리 누수를 방지하기 위해 액티비티가 종료될 때 모든 메시지와 콜백을 제거합니다.
        handler.removeCallbacksAndMessages(null);
    }
}


