package team.d3struct.smartmat;

import java.util.InputMismatchException;

public class PatternRecognize { // only for pushups

    final int size = 2;
    private double[] newDataSet = new double[size];
    private double[] oldDataSet = new double[size];
    private int oldPosition;
    int times = 0;

    private double threshold = 0.4; // change this accordingly

    private boolean start = true;

    public boolean running = false;

    private int[][] pattern = {
            {1, 1}, {0, 0}, {1, 1}, {2, 2}
    };

    // 1 : normal pressure
    // 2 : higher than Normal
    // 0 : less than Normal

    public void newDataSet(double[] data) {
        if (running) {

            if (data.length != size) {
                throw new InputMismatchException("Pattern Recognistion dosen't work for this dataset");

            } else {
                find();
            }
        }
    }


    private void find() {
        //Check of the the new data has significant difference than the previous data
        if (!start) {
            double change_0 = mod(oldDataSet[0] - newDataSet[0]);
            double change_1 = mod(oldDataSet[1] - newDataSet[1]);


            int diff_0 = pattern[oldPosition][0] - pattern[oldPosition + 1][0];
            int diff_1 = pattern[oldPosition][1] - pattern[oldPosition + 1][1];

            if (diff_0 == change_0 && diff_1 == change_1) {
                oldPosition += 1;

            }

            if (oldPosition == 4) {
                times += 1;
                oldPosition = 0;
            }


        } else {

            start = false; // start is false now
        }
    }

    private double mod(double i) {
        if (i < -threshold) {
            return -1.0;
        } else if (i > threshold) {
            return 1.0;
        }
        return 0;
    }

}
