package com.example.digiq;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import static com.example.digiq.DigiQ.NOTIFICATION_ID;

public class QueuePage extends AppCompatActivity {

    TextView tvQueueWelcome, tvName, tvAppNum, tvWaitTimeText, tvWaitTime;
    Button btnLeaveQueue, btnRefresh;
    private NotificationManagerCompat notificationManager;

    FirebaseDatabase ref;
    DatabaseReference child;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.queue_page);

        tvQueueWelcome = findViewById(R.id.tvQueueWelcome);
        tvName = findViewById(R.id.tvName);
        tvAppNum = findViewById(R.id.tvAppNum);
        tvWaitTimeText = findViewById(R.id.tvWaitTimeText);
        tvWaitTime = findViewById(R.id.tvWaitTime);
        btnLeaveQueue = findViewById(R.id.btnLeaveQueue);
        btnRefresh = findViewById(R.id.btnRefresh);
        notificationManager = NotificationManagerCompat.from(this);

        String name = getIntent().getStringExtra("Name");
        String app_no = getIntent().getStringExtra("ApplicationNumber");
        String token = getIntent().getStringExtra("token");


        ref = FirebaseDatabase.getInstance();
        if (token != null) {
            child = ref.getReference().child("names").child(token);
        }

        tvName.setText(getString(R.string.name_show) + " " + name);
        tvAppNum.setText(getString(R.string.app_num) + " " + app_no);
        child.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String time = snapshot.child("time_rem").getValue().toString();
                if(time.equals("")){
                    tvWaitTime.setText("25 minutes");
                }
                else{
                    tvWaitTime.setText(time + " minutes");
                }

                if(tvWaitTime.getText().toString().trim().equals("5 minutes") ) {
                    Notification notification = new NotificationCompat.Builder(QueuePage.this, NOTIFICATION_ID)
                            .setSmallIcon(R.drawable.ic_launcher_foreground)
                            .setContentTitle("Get Ready")
                            .setContentText("Your Turn will come in 5 Minutes!")
                            .setPriority(NotificationCompat.PRIORITY_HIGH)
                            .build();
                    notificationManager.notify(1, notification);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        btnLeaveQueue.setOnClickListener(v -> {
            final AlertDialog.Builder builder = new AlertDialog.Builder(QueuePage.this,R.style.CustomAlertDialog);
            ViewGroup viewGroup = findViewById(android.R.id.content);
            View dialogView = LayoutInflater.from(v.getContext()).inflate(R.layout.confirm_exit, viewGroup, false);
            Button btnCancel=dialogView.findViewById(R.id.btnCancel);
            Button btnLeaveQueue = dialogView.findViewById(R.id.btnLeaveQueue);
            builder.setView(dialogView);
            final AlertDialog alertDialog = builder.create();
            btnCancel.setOnClickListener(v1 -> alertDialog.dismiss());
            btnLeaveQueue.setOnClickListener(v1 -> {
                Intent intent = new Intent(QueuePage.this, MainActivity.class);
                startActivity(intent);
            });
            alertDialog.show();
        });

        btnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                startActivity(getIntent());
            }
        });
    }
}
