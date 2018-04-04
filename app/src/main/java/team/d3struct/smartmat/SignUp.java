package team.d3struct.smartmat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SignUp extends AppCompatActivity{
    //Authentication
    private FirebaseAuth mAuth;

    //Database
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;

    private EditText txt_username;
    private EditText txt_email;
    private EditText txt_password;
    private EditText txt_weight;
    private EditText txt_age;
    private RadioGroup RadioGroup01;
    private Button btn_signup;
    private CheckBox checkBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mAuth = FirebaseAuth.getInstance();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        txt_username=(EditText)findViewById(R.id.txt_signup_username);
        txt_email=(EditText)findViewById(R.id.txt_signup_email);
        txt_password=(EditText)findViewById(R.id.txt_signup_password);
        txt_weight=(EditText)findViewById(R.id.txt_signup_weight);
        txt_age=(EditText)findViewById(R.id.txt_signup_age);
        RadioGroup01 = (RadioGroup) findViewById(R.id.RadioGroup01);
        btn_signup= findViewById(R.id.btn_signup);
        checkBox=(CheckBox)findViewById(R.id.checkBox);


        btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createAccount();
            }
        });

    }

    @Override
    public void onStart() {
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    private void updateUI(FirebaseUser currentUser) {

        if (currentUser == null) {

        } else {
            Intent intent = new Intent(this, Home.class);
            this.startActivity ( intent );
        }
    }
    public void createAccount (){
        final String email = txt_email.getText().toString();
        String password= txt_password.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information

                            myRef = database.getReference(email+"/username");
                            myRef.setValue(txt_username.getText().toString());
                            myRef = database.getReference(email+"/age");
                            myRef.setValue(txt_username.getText().toString());
                            myRef = database.getReference(email+"/username");
                            myRef.setValue(txt_username.getText().toString());
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);


                        } else {

                            // If sign in fails, display a message to the user.

                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                    }
                });
    }


}
