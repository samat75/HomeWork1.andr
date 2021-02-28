package com.example.myhomework31;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Intent.ACTION_PICK;

public class MainActivity extends AppCompatActivity {
    Button button1;
    Button button2;
    ImageView imageView1;
    TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = findViewById(R.id.btn1);
        button2 = findViewById(R.id.btn2);
        imageView1 = findViewById(R.id.image);
        textView1 = findViewById(R.id.text);
        button1.setOnClickListener(view -> openActivity());
        button2.setOnClickListener(view -> {
            Intent intent = new Intent(ACTION_PICK);
            intent.putExtra("gmail_text", textView1.getText());
            startActivity(intent);
        });
    }

    public void openActivity() {
        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
        startActivityForResult(intent, 200);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == 1 && data != null) {
            textView1.setText(data.getStringExtra("text"));
            imageView1.setImageURI(data.getData());
        }
    }
}