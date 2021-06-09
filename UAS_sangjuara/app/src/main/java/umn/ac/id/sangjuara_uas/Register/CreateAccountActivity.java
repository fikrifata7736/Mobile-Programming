package umn.ac.id.sangjuara_uas.Register;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import umn.ac.id.sangjuara_uas.R;


public class CreateAccountActivity extends AppCompatActivity {
    public static final String TAG = "TAG";
    EditText FullName,Email,Username,Password,Phone;
    Button BtnCreateAccount;
    FirebaseAuth mAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);


        Email      = findViewById(R.id.email);
        Username   = findViewById(R.id.username);
        Password   = findViewById(R.id.password);
        BtnCreateAccount= findViewById(R.id.btnCreateAccount);



        mAuth = FirebaseAuth.getInstance();


        BtnCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createUser();
            }
        });


    }

    private void createUser() {

        String email = Email.getText().toString().trim();
        String password = Password.getText().toString().trim();


        if (!email.isEmpty()&& Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            if (!password.isEmpty()){
                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                Toast.makeText(CreateAccountActivity.this, "SignUp Success!", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(CreateAccountActivity.this, LoginActivity.class));
                                finish();
                            }
                        }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(CreateAccountActivity.this, "Can't Sign Up!", Toast.LENGTH_SHORT).show();
                    }
                });
            }else {
                Password.setError("Empty");
            }
        }else if(email.isEmpty()){
            Email.setError("Empty");
        }else {
            Email.setError("Filled with the correct Email");
        }
    }



}