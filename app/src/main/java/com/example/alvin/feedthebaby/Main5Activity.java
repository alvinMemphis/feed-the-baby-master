package com.example.alvin.feedthebaby;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {
    private EditText name,age;
    SQLiteHelper DB;
    //for database
    private Button ok;

    //for camera
    ImageButton done;
    ImageView img;
    static final int REQUEST_IMAGE_CAPTURE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        //database
        DB = new SQLiteHelper(Main5Activity.this);
        //camera button and image view
        done = (ImageButton) findViewById(R.id.user_profile_photo);
        img = (ImageView) findViewById(R.id.imageView3);
        //camera button off and on
        if(!hasCamera()){
            done.setEnabled(false);
        }
        //database input widgets
        ok =(Button)findViewById(R.id.ok);
        name =(EditText) findViewById(R.id.name);
        age =(EditText) findViewById(R.id.age);

        //method to enter data
        dataEnter();
    }


    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);}

    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);}

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            img.setImageBitmap(photo);}}

    public void dataEnter(){
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //validate data
                if(name.getText().toString().equals("") || age.getText().toString().equals("")){
                    Toast.makeText(Main5Activity.this, "fill in the missing fields", Toast.LENGTH_SHORT).show();
                    name.setText("");
                    age.setText("");}
                //enter the data
                else{
                    boolean y  =DB.insertRecord(new Baby(name.getText().toString(),age.getText().toString()));
                    if(y == true){
                        Toast.makeText(Main5Activity.this, "information stored", Toast.LENGTH_SHORT).show();
                        name.setText("");
                        age.setText("");
                        ok.setEnabled(false);}
                    else {
                        Toast.makeText(Main5Activity.this, "information corrupted", Toast.LENGTH_SHORT).show();}}
            }
        });
    }
}
