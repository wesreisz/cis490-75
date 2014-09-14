package com.wesleyreisz.quizapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by wesleyreisz on 9/14/14.
 */
public class QuestionUtil {
    public static final String CORRECT = "Correct!!!";
    public static final String INCORRECT = "I'm sorry that's not correct";
    public static Question[] loadQuestions(){
        List<Question>questions = new ArrayList<Question>();
        String questionText;
        String answer;
        Map<String,String> options;
        Question question;

        //question 1
        questionText = "Duke is the mascot for";
        answer = "A";
        options = new HashMap<String, String>();
        options.put("A", "Java");
        options.put("B", "Git");
        options.put("C", "GitHub");
        options.put("D", "Android");

        question = new Question(questionText, answer, options);
        questions.add(question);

        //question 2
        questionText = "Android's default runtime Virtual Machine is";
        answer = "B";
        options = new HashMap<String, String>();
        options.put("A", "Java");
        options.put("B", "Dalvik");
        options.put("C", "ART");
        options.put("D", "CLR");

        question = new Question(questionText, answer, options);
        questions.add(question);

        //question 3
        questionText = "Why was Dalvik created?";
        answer = "D";
        options = new HashMap<String, String>();
        options.put("A", "It's Cool");
        options.put("B", "Because it runs with Java");
        options.put("C", "Because the creator was from Iceland");
        options.put("D", "Licensing Issues with the Java Runtime Environment");

        question = new Question(questionText, answer, options);
        questions.add(question);


        //question 4
        questionText = "Where do vendor extensions go (such as HTC's Sense UI)?";
        answer = "A";
        options = new HashMap<String, String>();
        options.put("A", "Add-on Directory");
        options.put("B", "plugins Directory");
        options.put("C", "System Images");
        options.put("D", "it's part of Android core");

        question = new Question(questionText, answer, options);
        questions.add(question);

        //question 5
        questionText = "What is an activity?";
        answer = "A";
        options = new HashMap<String, String>();
        options.put("A", "represents a single screen with a user interface");
        options.put("B", "a component that runs in the background to perform long-running operations or to perform work for remote processes");
        options.put("C", "a component that responds to system-wide broadcast announcements");
        options.put("D", "manages a shared set of app data");

        question = new Question(questionText, answer, options);
        questions.add(question);

        //question 6
        questionText = "What is the Manifest File?";
        answer = "C";
        options = new HashMap<String, String>();
        options.put("A", "an interface in the View class that contains a single callback method. These methods will be called by the Android framework when the View to which the listener has been registered is triggered by user interaction with the item in the UI");
        options.put("B", "represents a single screen with a user interface");
        options.put("C", "provides android configuration information such as security settings");
        options.put("D", "manages users strings");

        question = new Question(questionText, answer, options);
        questions.add(question);

        //question 7
        questionText = "What is an implicit intent?";
        answer = "D";
        options = new HashMap<String, String>();
        options.put("A", "File is not needed. It's just cruft");
        options.put("B", "a component that runs in the background to perform long-running operations or to perform work for remote processes");
        options.put("C", "provides android configuration information such as security settings");
        options.put("D", "simply describes the type of action to perform (and, optionally, the data upon which you’d like to perform the action) and allows the system to find a component on the device that can perform the action and start it. If there are multiple components that can perform the action described by the intent, then the user selects which one to use.");

        question = new Question(questionText, answer, options);
        questions.add(question);

        //question 8
        questionText = "Explain the purpose of the onCreate() method?";
        answer = "B";
        options = new HashMap<String, String>();
        options.put("A", "Optional method called when creating an activity");
        options.put("B", "Required method called when creating an activity");
        options.put("C", "Required method called when destroying an activity");
        options.put("D", "invalid method");

        question = new Question(questionText, answer, options);
        questions.add(question);

        //question 8
        questionText = "Which of the following is NOT a valid layout?";
        answer = "C";
        options = new HashMap<String, String>();
        options.put("A", "LinearLayout");
        options.put("B", "RelativeLayout");
        options.put("C", "TableViewLayout");
        options.put("D", "WebView");

        question = new Question(questionText, answer, options);
        questions.add(question);

        //question 8
        questionText = "Which of the following is NOT a valid Activity Lifecycle Stage?";
        answer = "C";
        options = new HashMap<String, String>();
        options.put("A", "onPause()");
        options.put("B", "onStop()");
        options.put("C", "onApplicationCreation()");
        options.put("D", "onDestroy()");

        question = new Question(questionText, answer, options);
        questions.add(question);

        //question 9
        questionText = "What is an Event Listener?";
        answer = "D";
        options = new HashMap<String, String>();
        options.put("A", "Optional method called when creating an activity");
        options.put("B", "a component that runs in the background to perform long-running operations or to perform work for remote processes");
        options.put("C", "simply describes the type of action to perform (and, optionally, the data upon which you’d like to perform the action) and allows the system to find a component on the device that can perform the action and start it");
        options.put("D", "is an interface in the View class that contains a single callback method. These methods will be called by the Android framework when the View to which the listener has been registered is triggered by user interaction with the item in the UI");

        question = new Question(questionText, answer, options);
        questions.add(question);

        //question 10
        questionText = "What is a toast?";
        answer = "B";
        options = new HashMap<String, String>();
        options.put("A", "Optional method called when creating an activity");
        options.put("B", "provides simple feedback about an operation in a small popup");
        options.put("C", "a component that runs in the background to perform long-running operations or to perform work for remote processes");
        options.put("D", "burnt bread");

        question = new Question(questionText, answer, options);
        questions.add(question);

        //return array
        Question[] questionArray = new Question[questions.size()];
        return questions.toArray(questionArray);
    }
    public static String checkQuestion(String answer, int textItemClicked){
        if("A".equalsIgnoreCase(answer) && textItemClicked==R.id.txtAnswerA){
            return CORRECT;
        }else if("B".equalsIgnoreCase(answer) && textItemClicked==R.id.txtAnswerB){
            return CORRECT;
        }else if("C".equalsIgnoreCase(answer) && textItemClicked==R.id.txtAnswerC){
            return CORRECT;
        }else if("D".equalsIgnoreCase(answer) && textItemClicked==R.id.txtAnswerD){
            return CORRECT;
        }else{
            return INCORRECT;
        }
    }
}
