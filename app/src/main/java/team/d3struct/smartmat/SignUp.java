package team.d3struct.smartmat;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUp extends AppCompatActivity{
    private FirebaseAuth mAuth;

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

        txt_username=(EditText)findViewById(R.id.txt_email);
        txt_email=(EditText)findViewById(R.id.txt_password);
        txt_password=(EditText)findViewById(R.id.txt_password);
        txt_weight=(EditText)findViewById(R.id.txt_age);
        txt_age=(EditText)findViewById(R.id.txt_age);
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
        // Check if user is signed in (non-null) and update UI accordingly.
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
        String email = txt_email.getText().toString();
        String password= txt_email.getText().toString();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);


                        } else {

                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(SignUp.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            updateUI(null);
                        }

                    }
                });
    }


}
