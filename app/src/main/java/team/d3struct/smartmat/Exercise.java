package team.d3struct.smartmat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;

public class Exercise extends AppCompatActivity {

    Button btn_main;
    TextView txt_timer,txt_reps;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        btn_main = findViewById(R.id.btn_exercise_main);
        txt_timer = findViewById(R.id.txt_exercise_timer);
        txt_reps = findViewById(R.id.txt_exercise_reps);

        btn_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

    private void startTimer(){
        Timer timer = new Timer();
    }
}
