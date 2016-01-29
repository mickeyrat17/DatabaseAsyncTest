package com.blank.databaseasynctest;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageUploadActivity extends AppCompatActivity implements View.OnClickListener {

    private Button uploadBtn, saveBtn, galleryBtn;
    private ImageView uploadedImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload);
        init();
    }

    public void init() {
        uploadBtn = (Button)findViewById(R.id.uploadBtn);
        saveBtn = (Button)findViewById(R.id.saveBtn);
        galleryBtn = (Button)findViewById(R.id.galleryBtn);
        uploadedImage = (ImageView)findViewById(R.id.uploadedImage);

        uploadBtn.setOnClickListener(this);
        saveBtn.setOnClickListener(this);
        galleryBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        //Methods created to handle button action should be seperate classes
        switch(v.getId()) {
            case R.id.uploadBtn:
                uploadButtonLogic();
                break;
            case R.id.saveBtn:
                saveButtonLogic();
                break;
            case R.id.galleryBtn:
                galleryButtonLogic();
                break;
        }
    }

    public void uploadButtonLogic() {

    }

    public void saveButtonLogic() {

    }

    public void galleryButtonLogic() {

    }
}
