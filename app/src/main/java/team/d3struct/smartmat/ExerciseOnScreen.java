package team.d3struct.smartmat;

import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Chronometer;

public class ExerciseOnScreen extends AppCompatActivity {
    private Chronometer chronometer;
    private boolean running;
    private long pauseoffset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_on_screen);

        chronometer=findViewById(R.id.chronometer);
    }

    public void startChronometer(View v){
        if(!running){
            chronometer.setBase(SystemClock.elapsedRealtime() - pauseoffset);
            chronometer.start();
            running = true;

        }

    }
    public void pauseChronometer(View v){
        if(running){
            chronometer.stop();
            pauseoffset = SystemClock.elapsedRealtime() - chronometer.getBase();
            running=false;
        }

    }
    public void resetChronometer(View v){

        chronometer.setBase(SystemClock.elapsedRealtime());
        pauseoffset = 0;

    }
}
