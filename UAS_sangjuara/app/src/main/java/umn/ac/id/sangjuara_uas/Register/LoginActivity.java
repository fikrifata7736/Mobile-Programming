package umn.ac.id.sangjuara_uas.Register;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import umn.ac.id.sangjuara_uas.R;
import umn.ac.id.sangjuara_uas.TampilanMenu.TampilanPertamaActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText Email,Password;
    private Button BtnLogin ;
    private ImageView setCreateAccount;
    private VideoView mVideoView;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mVideoView = (VideoView) findViewById(R.id.videoView);
        Email = findViewById(R.id.email);
        Password = findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        BtnLogin = findViewById(R.id.btnLogin);
        setCreateAccount = findViewById(R.id.setCreateAccount);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video1);
        mVideoView.setVideoURI(uri);
        mVideoView.start();

        mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mediaPlayer) {
                mediaPlayer.setLooping(true);
            }
        });
        //  BtnTesting = findViewById(R.id.btnTesting);

        //   BtnTesting.setOnClickListener(new View.OnClickListener(){
        //    @Override
        //    public void onClick(View view){
        // testinglogin();
        //  }

        // });


        BtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                loginUser();
            }

            private void loginUser() {
                String email = Email.getText().toString();
                String password = Password.getText().toString();

                if (!email.isEmpty()&& Patterns.EMAIL_ADDRESS.matcher(email).matches()){
                    if (!password.isEmpty()){
                        mAuth.signInWithEmailAndPassword(email, password)
                                .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                    @Override
                                    public void onSuccess(AuthResult authResult) {
                                        Toast.makeText(LoginActivity.this, "Sign in success!", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(LoginActivity.this, TampilanPertamaActivity.class));
                                        finish();
                                    }
                                }).addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Toast.makeText(LoginActivity.this, "Sign in failed", Toast.LENGTH_SHORT).show();
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
        });






        setCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.setCreateAccount:
                        startActivity(new Intent(LoginActivity.this, CreateAccountActivity.class));
                        overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
                        break;
                }
            }
        });



    }

    private void testinglogin() {
        String email = Email.getText().toString();
        String password = Password.getText().toString();

        if (!email.isEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            if (!password.isEmpty()) {
                mAuth.signInWithEmailAndPassword(email, password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(AuthResult authResult) {
                        Toast.makeText(LoginActivity.this, "Sign in Success!", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginActivity.this, TampilanPertamaActivity.class));
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(LoginActivity.this, "Sign in Failed", Toast.LENGTH_SHORT).show();
                    }
                });
            } else {
                Password.setError("Password Kosong");
            }
        }else if (email.isEmpty()) {
            Email.setError("Email Kosong");
        } else {
            Email.setError("Isi dengan Email yang benar");
        }
    }



} //LoginActivity

