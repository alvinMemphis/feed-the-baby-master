package com.example.alvin.feedthebaby;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
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
    //for database
    DatabaseHelper DB;
    Button ok;
    EditText editText;

    //for camera
    ImageButton done;
    ImageView img;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);
        ok = (Button) findViewById(R.id.ok);
        editText = (EditText) findViewById(R.id.editText);
        done = (ImageButton) findViewById(R.id.user_profile_photo);
        img = (ImageView) findViewById(R.id.imageView3);
        if(!hasCamera()){
            done.setEnabled(false);
        }

        //for database
        DB = new DatabaseHelper(this);
        addData();
    }
    private boolean hasCamera(){
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }

    public void launchCamera(View view){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent,REQUEST_IMAGE_CAPTURE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode==REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap) extras.get("data");
            img.setImageBitmap(photo);
        }
    }

    //////////////for database
    public void addData(){
        ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Boolean isInserted = DB.insertData(editText.getText().toString());
                if(isInserted == true){
                    Intent intent = new Intent(getApplicationContext(),Main6Activity.class);
                    intent.putExtra("com.example.alvin.feedthebaby.SOMETHING",viewALL());
                    startActivity(intent);
                }
                else
                    Toast.makeText(Main5Activity.this,"Enter Baby Name !!!",Toast.LENGTH_LONG).show();
            }
        });
    }

        /*
                Cursor res = DB.getALLDATA();
                if(res.getCount()==0){
                    Toast.makeText(getActivity().getApplicationContext(),"ERRor",Toast.LENGTH_LONG).show();
                    return;}
                else
                    Toast.makeText(getActivity().getApplicationContext(),res.getString(0),Toast.LENGTH_LONG).show();


                    while (res.moveToNext()){
                        buffer.append("IdD :"+ res.getString(0)+"\n");
                        buffer.append("Name :"+ res.getString(1)+"\n");
                        buffer.append("Surname :"+ res.getString(2)+"\n");
                        buffer.append("Marks :"+ res.getString(3)+"\n\n");
                    }



            }
        });

    }*/
        public String viewALL(){
            Cursor res = DB.getALLDATA();
            res.moveToNext();
            return res.getString(1);
        }

}
