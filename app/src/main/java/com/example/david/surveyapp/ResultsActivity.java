package com.example.david.surveyapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    private Button mResetButton;
    private Button mContinueButton;
    private TextView mYesCount;
    private TextView mNoCount;
    static final String CLICKED_RESET = "Clicked Reset";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        mResetButton = (Button) findViewById(R.id.resetButton);
        mContinueButton = (Button) findViewById(R.id.continueButton);
        mYesCount = (TextView) findViewById(R.id.yesCount);
        mNoCount = (TextView) findViewById(R.id.noCount);

        int yesCount = getIntent().getIntExtra(SurveyActivity.YES_COUNT,0);
        int noCount = getIntent().getIntExtra(SurveyActivity.NO_COUNT,0);

        mYesCount.setText("Yes count: " +yesCount);
        mNoCount.setText("No count: " + noCount);

        mResetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mYesCount.setText("Yes count: " + 0);
                mNoCount.setText("Yes count: " + 0);
                Toast.makeText(ResultsActivity.this,"Count reset",Toast.LENGTH_SHORT).show();
                Intent clickedReset = new Intent();
                clickedReset.putExtra(CLICKED_RESET,true);
                setResult(RESULT_OK,clickedReset);
            }
        });
        mContinueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
