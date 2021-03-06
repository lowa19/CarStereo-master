package cs371.carstereo;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private ToggleButton powerButton;
    private TextView songName;
    //private ImageView picture;
    private SeekBar volumeControl;
    private TextView vDown;
    private TextView vUp;
    private Button tuner;
    private Button amFm;
    private Button set1;
    private Button set2;
    private Button set3;
    private Button set4;
    private Button set5;
    private Button set6;

    public boolean isOff = false;
    public boolean freqency = false;
    public int AMstation = 530;
    public double FMstation = 88.1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Widgets
        powerButton = (ToggleButton) findViewById(R.id.powerButton);
        songName = (TextView) findViewById(R.id.songName);
        volumeControl = (SeekBar) findViewById(R.id.volume);
        vDown = (TextView) findViewById(R.id.volumeDown);
        vUp = (TextView) findViewById(R.id.volumeUp);
        tuner = (Button) findViewById(R.id.tune);
        amFm = (Button) findViewById(R.id.radio);
        //radio presets
        set1 = (Button) findViewById(R.id.preset1);
        set2 = (Button) findViewById(R.id.preset2);
        set3 = (Button) findViewById(R.id.preset3);
        set4 = (Button) findViewById(R.id.preset4);
        set5 = (Button) findViewById(R.id.preset5);
        set6 = (Button) findViewById(R.id.preset6);
        //button and toggle listeners
        powerButton.setOnClickListener(new ToggleListener());
        tuner.setOnClickListener(new ButtonListener());
        amFm.setOnClickListener(new ButtonListener());
        set1.setOnClickListener(new ButtonListener());
        set2.setOnClickListener(new ButtonListener());
        set3.setOnClickListener(new ButtonListener());
        set4.setOnClickListener(new ButtonListener());
        set5.setOnClickListener(new ButtonListener());
        set6.setOnClickListener(new ButtonListener());
        //long click listeners
        set1.setOnLongClickListener(new longClickListener());
        set2.setOnLongClickListener(new longClickListener());
        set3.setOnLongClickListener(new longClickListener());
        set4.setOnLongClickListener(new longClickListener());
        set5.setOnLongClickListener(new longClickListener());
        set6.setOnLongClickListener(new longClickListener());
    }

    public class longClickListener implements View.OnLongClickListener
    {
        @Override
        public boolean onLongClick(View v)
        {
            int buttonChoice = v.getId();

















        }
    }

    public class ButtonListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v)
        {
            int buttonChoice = v.getId();
            if(buttonChoice == R.id.preset1)
            {
                if(freqency == true)
                {
                    AMstation = 550;
                    songName.setText(AMstation + " kHz AM");
                }
                else
                {
                    FMstation = 90.9;
                    songName.setText(FMstation + " MHz FM");
                }
            }
            if(buttonChoice == R.id.preset2)
            {
                if(freqency == true)
                {
                    AMstation = 600;
                    songName.setText(AMstation + " kHz AM");
                }
                else
                {
                    FMstation = 92.9;
                    songName.setText(FMstation + " MHz FM");
                }
            }
            if(buttonChoice == R.id.preset3)
            {
                if(freqency == true)
                {
                    AMstation = 650;
                    songName.setText(AMstation + " kHz AM");
                }
                else
                {
                    FMstation = 94.9;
                    songName.setText(FMstation + " MHz FM");
                }
            }
            if(buttonChoice == R.id.preset4)
            {
                if(freqency == true)
                {
                    AMstation = 700;
                    songName.setText(AMstation + " kHz AM");
                }
                else
                {
                    FMstation = 96.9;
                    songName.setText(FMstation + " MHz FM");
                }
            }
            if(buttonChoice == R.id.preset5)
            {
                if(freqency == true)
                {
                    AMstation = 750;
                    songName.setText(AMstation + " kHz AM");
                }
                else
                {
                    FMstation = 98.9;
                    songName.setText(FMstation + " MHz FM");
                }
            }
            if(buttonChoice == R.id.preset6)
            {
                if(freqency == true)
                {
                    AMstation = 800;
                    songName.setText(AMstation + " kHz AM");
                }
                else
                {
                    FMstation = 100.9;
                    songName.setText(FMstation + " MHz FM");
                }
            }
            if(buttonChoice == R.id.tune && isOff == false)
            {
                if(freqency == true) {
                    if (AMstation == 1700) //max
                    {
                        AMstation = 530; //set back to 530
                        songName.setText(AMstation + " kHz AM");
                    }
                    else
                    {
                        AMstation = AMstation + 10;
                        songName.setText(AMstation + " kHzAM");
                    }
                }
                else
                {
                    if(FMstation == 107.9)
                    {
                        FMstation = 88.1;
                        songName.setText(FMstation + " MHz FM");
                    }
                    else
                    {
                        FMstation = FMstation + .2;
                        FMstation = FMstation * 10;
                        FMstation = Math.round(FMstation);
                        FMstation = FMstation/10;
                        songName.setText(FMstation + " MHz FM");
                    }
                }
            }
            else if(buttonChoice == R.id.radio && isOff == false)
            {
                if(freqency == false)
                {
                    songName.setText(AMstation + " kHz AM");
                    freqency = true; //set to AM
                }
                else
                {
                    songName.setText(FMstation + " MHz FM");
                    freqency = false; //set to FM
                }
            }
        }
    }
    public class ToggleListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {

            if(isOff == false) {
                volumeControl.setBackgroundColor(0xDD101010);
                //picture.setBackgroundColor(0xDD101010);
                powerButton.setBackgroundColor(0xDD101010);
                songName.setBackgroundColor(0xDD101010);
                songName.setTextColor(0xDD101010);
                vUp.setBackgroundColor(0xDD101010);
                vDown.setBackgroundColor(0xDD101010);
                isOff = true;
            }
            else
            {
                volumeControl.setBackgroundColor(0xFF0000FF);
                //picture.setBackgroundColor(0xFF0000FF);
                powerButton.setBackgroundColor(0xFF0000FF);
                songName.setBackgroundColor(0xFF0000FF);
                songName.setTextColor(Color.BLACK);
                vUp.setBackgroundColor(0xFF0000FF);
                vDown.setBackgroundColor(0xFF0000FF);
                isOff = false;
            }
        }
    }

}
