package com.wesleyreisz.quizapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;


public class QuizActivity extends Activity implements View.OnClickListener {
    private Question[] questions = QuestionUtil.loadQuestions();
    private int lastDisplayQuestion = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        showQuestion();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        String message = QuestionUtil.
                checkQuestion(questions[lastDisplayQuestion].getAnswer(),view.getId());
        Toast t = Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT);
        t.show();
        if(message.equalsIgnoreCase(QuestionUtil.CORRECT)){
             lastDisplayQuestion++;
            showQuestion();
        }
    }

    private void showQuestion() {
        if(lastDisplayQuestion<questions.length) {
            Question question = questions[lastDisplayQuestion];

            TextView questionText = (TextView) findViewById(R.id.txtQuestion);
            questionText.setText(question.getQuestion() + ":");

            TextView answerA = (TextView) findViewById(R.id.txtAnswerA);
            answerA.setText(question.getOptionMap().get("A"));
            answerA.setOnClickListener(this);

            TextView answerB = (TextView) findViewById(R.id.txtAnswerB);
            answerB.setText(question.getOptionMap().get("B"));
            answerB.setOnClickListener(this);

            TextView answerC = (TextView) findViewById(R.id.txtAnswerC);
            answerC.setText(question.getOptionMap().get("C"));
            answerC.setOnClickListener(this);

            TextView answerD = (TextView) findViewById(R.id.txtAnswerD);
            answerD.setText(question.getOptionMap().get("D"));
            answerD.setOnClickListener(this);

            TextView pageNumber = (TextView) findViewById(R.id.txtPage);
            pageNumber.setText("Question " + (lastDisplayQuestion+1) + " of " + (questions.length));
        }else{
            TextView questionText = (TextView) findViewById(R.id.txtQuestion);
            questionText.setText("Quiz Complete");
            TextView answerA = (TextView) findViewById(R.id.txtAnswerA);
            answerA.setText("");
            TextView answerB = (TextView) findViewById(R.id.txtAnswerB);
            answerB.setText("");
            TextView answerC = (TextView) findViewById(R.id.txtAnswerC);
            answerC.setText("");
            TextView answerD = (TextView) findViewById(R.id.txtAnswerD);
            answerD.setText("");
            TextView pageNumber = (TextView) findViewById(R.id.txtPage);
            pageNumber.setText("");
        }
    }
}
