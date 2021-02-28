package com.example.myhomework31;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class SecondActivity extends AppCompatActivity {

    Button btn3;
    ImageView imageView2;
    EditText editText2;
    Uri imageUri;
    String text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        btn3 = findViewById(R.id.btn3);
        imageView2 = findViewById(R.id.image2);
        editText2 = findViewById(R.id.edit);
        imageView2.setOnClickListener(view -> {
            openGallery();
        });
        btn3.setOnClickListener(view -> {
            closeActivity();
        });
    }

    private void closeActivity() {
        Intent intent = new Intent();
        intent.putExtra("text", editText2.getText().toString());
        intent.putExtra("image", imageUri);
        setResult(RESULT_OK, intent);
        finish();
    }

    private void openGallery() {
        Intent i = new Intent();
        i.setAction(Intent.ACTION_GET_CONTENT);
        i.setType("image/*");
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityForResult(i, 1);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 200 && data != null) {
            imageUri = data.getData();
            imageView2.setImageURI(imageUri);
        }
    }
}
