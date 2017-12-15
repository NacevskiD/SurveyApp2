package com.example.david.surveyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class SurveyActivity extends AppCompatActivity {

    Button mYesButton;
    Button mNoButton;
    Button mSurveyResults;
    Button mChangeQuestion;
    TextView mQuestion;

    int yesCount =0;
    int noCount =0;

    private static final String YES_KEY = "yes string";
    private static final String NO_KEY = "no string";
    static final String YES_COUNT = "yes count";
    static final String NO_COUNT = "no count";
    private static final int RESULTS_REQUEST_CODE = 0;
    private static final int CHANGE_QUESTION_REQUEST_CODE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey);

        if (savedInstanceState != null){
            yesCount = savedInstanceState.getInt(YES_KEY);
            noCount = savedInstanceState.getInt(NO_KEY);
        }

        mChangeQuestion = (Button) findViewById(R.id.setQuestion);
        mYesButton = (Button) findViewById(R.id.yesButton);
        mNoButton = (Button) findViewById(R.id.noButton);
        mSurveyResults = (Button) findViewById(R.id.surveyResults);
        mQuestion = (TextView) findViewById(R.id.question);





        mYesButton.setOnClickListener(new View.OnClickListener(){
          @Override
            public void onClick (View v){
              yesCount += 1;
              Toast.makeText(SurveyActivity.this,"Added vote",Toast.LENGTH_SHORT).show();

          }


        });

        mNoButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View v){
                noCount += 1;
                Toast.makeText(SurveyActivity.this,"Added vote",Toast.LENGTH_SHORT).show();

            }


        });

        mSurveyResults.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                /*noCount = 0;
                yesCount = 0;
                mYesCount.setText("Yes count: " + Integer.toString(yesCount));
                mNoCount.setText("No count: " + Integer.toString(noCount));*/
                Intent results = new Intent(SurveyActivity.this,ResultsActivity.class);
                results.putExtra(YES_COUNT,yesCount);
                results.putExtra(NO_COUNT,noCount);
                startActivityForResult(results,RESULTS_REQUEST_CODE);

            }

        });

        mChangeQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changeQuestion = new Intent(SurveyActivity.this,ChangeQuestion.class);
                startActivityForResult(changeQuestion,CHANGE_QUESTION_REQUEST_CODE);
            }
        });

    }
    @Override
    protected void onSaveInstanceState(Bundle outBundle){
        outBundle.putInt(YES_KEY,yesCount);
        outBundle.putInt(NO_KEY,noCount);
    }

    @Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        if (requestCode == RESULTS_REQUEST_CODE && resultCode == RESULT_OK){
            boolean isReset = data.getBooleanExtra(ResultsActivity.CLICKED_RESET,false);

            if (isReset){
                yesCount = 0;
                noCount = 0;
            }

        }
        if (requestCode == CHANGE_QUESTION_REQUEST_CODE && resultCode == RESULT_OK){
                String question = data.getStringExtra(ChangeQuestion.ENTERED_QUESTION);
                String answer1 = data.getStringExtra(ChangeQuestion.FIRST_ANSWER);
                String answer2 = data.getStringExtra(ChangeQuestion.SECOND_ANSWER);

            mQuestion.setText(question);
            mYesButton.setText(answer1);
            mNoButton.setText(answer2);
            Toast.makeText(SurveyActivity.this,"Question changed",Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(SurveyActivity.this,"You canceled the change,try again",Toast.LENGTH_SHORT).show();
        }

    }


}
