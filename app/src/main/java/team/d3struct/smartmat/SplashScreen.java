package team.d3struct.smartmat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

public class SplashScreen extends AppCompatActivity {

    //BluetoothServ bluetoothServ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(1000);
                    //bluetoothServ.bluetooth();
                    Intent intent = new Intent(getApplicationContext(),SignUp.class);
                    startActivity(intent);
                    finish();
                } catch (InterruptedException e) {

                }
            }
        };
        myThread.start();
    }

}
