package com.example.david.surveyapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ChangeQuestion extends AppCompatActivity {

    EditText mQuestion;
    EditText mAnswer1;
    EditText mAnswer2;
    Button mSubmit;

    static final String ENTERED_QUESTION = "Entered Question";
    static final String FIRST_ANSWER = "first answer";
    static final String SECOND_ANSWER = "second answer";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_question);

        mQuestion = (EditText) findViewById(R.id.questionEntry);
        mAnswer1 = (EditText) findViewById(R.id.answer1);
        mAnswer2 = (EditText) findViewById(R.id.answer2);
        mSubmit = (Button) findViewById(R.id.submit);

        mSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String question = mQuestion.getText().toString();
                String answer1 = mAnswer1.getText().toString();
                String answer2 = mAnswer2.getText().toString();

                if (question.isEmpty()){
                    Toast.makeText(ChangeQuestion.this,"Please enter your question",Toast.LENGTH_SHORT).show();
                }
                else if(answer1.isEmpty()){
                    Toast.makeText(ChangeQuestion.this,"Please enter your first answer",Toast.LENGTH_SHORT).show();
                }
                else if (answer2.isEmpty()){
                    Toast.makeText(ChangeQuestion.this,"Please enter your second answer",Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent result = new Intent();
                    result.putExtra(ENTERED_QUESTION,question);
                    result.putExtra(FIRST_ANSWER,answer1);
                    result.putExtra(SECOND_ANSWER,answer2);
                    setResult(RESULT_OK,result);
                    finish();
                }
            }
        });
    }
}
