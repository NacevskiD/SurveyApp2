package com.example.david.surveyapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SurveyActivity extends AppCompatActivity {

    Button mYesButton;
    Button mNoButton;
    TextView mYesCount;
    TextView mNoCount;
    Button mResetButton;

    int yesCount =0;
    int noCount =0;

    private static final String YES_KEY = "yes string";
    private static final String NO_KEY = "no string";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        if (savedInstanceState != null){
            yesCount = savedInstanceState.getInt(YES_KEY);
            noCount = savedInstanceState.getInt(NO_KEY);
        }

        mYesButton = (Button) findViewById(R.id.yesButton);
        mNoButton = (Button) findViewById(R.id.noButton);
        mYesCount = (TextView) findViewById(R.id.yesVotes);
        mNoCount= (TextView) findViewById(R.id.noVotes);
        mResetButton = (Button) findViewById(R.id.resetButton);

        mYesCount.setText("Yes count: " + Integer.toString(yesCount));
        mNoCount.setText("No count: " + Integer.toString(noCount));

        mYesButton.setOnClickListener(new View.OnClickListener(){
          @Override
            public void onClick (View v){
              yesCount += 1;
              mYesCount.setText("Yes count: " + Integer.toString(yesCount));
          }


        });

        mNoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                noCount += 1;
                mNoCount.setText("No count: " + Integer.toString(noCount));
            }


        });

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                noCount = 0;
                yesCount = 0;
                mYesCount.setText("Yes count: " + Integer.toString(yesCount));
                mNoCount.setText("No count: " + Integer.toString(noCount));

            }

        });

    }
    @Override
    protected void onSaveInstanceState(Bundle outBundle){
        outBundle.putInt(YES_KEY,yesCount);
        outBundle.putInt(NO_KEY,noCount);
    }
}
