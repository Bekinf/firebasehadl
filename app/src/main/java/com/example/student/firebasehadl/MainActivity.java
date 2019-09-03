package com.example.student.firebasehadl;

import android.os.FileObserver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApiNotAvailableException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    EditText txt_id,txt_name,txt_address,txt_contactnumber;
    Button btn_save,btn_show,btn_update,btn_delete;
    Student student;
    DatabaseReference dbRef;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt_id = findViewById(R.id.txtid);
        txt_name = findViewById(R.id.txtname);
        txt_address = findViewById(R.id.txtaddress);
        txt_contactnumber = findViewById(R.id.txtcontactnumber);

        btn_save = findViewById(R.id.btnsave);
        btn_show = findViewById(R.id.btnshow);
        btn_update = findViewById(R.id.btnupdate);
        btn_delete = findViewById(R.id.btndelete);

        student = new Student();

        student = new Student();

        btn_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dbRef = FirebaseDatabase.getInstance().getReference().child("Student");

                student.setId(txt_id.getText().toString().trim());
                student.setAddress(txt_address.getText().toString().trim());
                student.setName(txt_name.getText().toString().trim());
                student.setContactNum(Integer.parseInt(txt_contactnumber.getText().toString().trim()));

                dbRef.push().setValue(student);

                Toast.makeText(getApplicationContext(),"Success",Toast.LENGTH_LONG).show();



            }
        });


    }
    public void  cleardata(){

        txt_id.setText("");
        txt_name.setText("");
        txt_address.setText("");
        txt_contactnumber.setText("");
    }
}
