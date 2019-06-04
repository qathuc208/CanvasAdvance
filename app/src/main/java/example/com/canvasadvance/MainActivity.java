package example.com.canvasadvance;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static int DELTA_VALUE = 5;
    private TextView textView;
    private Button buttonDecrease;
    private Button buttonIncrease;
    SeekBar seekBar;
    int progress11 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final CustomProgressBar customProgressBar;
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        textView = (TextView) findViewById(R.id.textView);
        this.buttonDecrease= (Button) findViewById(R.id.button_decrease);
        this.buttonIncrease= (Button) findViewById(R.id.button_increase);
        customProgressBar = (CustomProgressBar) findViewById(R.id.tessst);



        this.textView.setText("Progress: " + seekBar.getProgress() + "/" + seekBar.getMax());
        customProgressBar.setProgress(seekBar.getProgress());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                progress11 = progress;
                textView.setText("Progress: " + progress + "/" + seekBar.getMax());
                customProgressBar.setProgress(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                textView.setText("Progress: " + progress11 + "/" + seekBar.getMax());
                customProgressBar.setProgress(progress11);

            }
        });
        buttonDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decreateProgress();
            }
        });
        buttonIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                increateProgress();
            }
        });
    }

    private void decreateProgress()  {
        int progress= this.seekBar.getProgress();
        if(progress - DELTA_VALUE < 0)  {
            this.seekBar.setProgress(0);
        }else  {
            this.seekBar.setProgress(progress - DELTA_VALUE);
        }

    }

    private void increateProgress()  {
        int progress= this.seekBar.getProgress();
        if(progress + DELTA_VALUE > this.seekBar.getMax())  {
            this.seekBar.setProgress(0);
        }else {
            this.seekBar.setProgress(progress + DELTA_VALUE);
        }

    }
}
