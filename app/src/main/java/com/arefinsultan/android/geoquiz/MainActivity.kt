package com.arefinsultan.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders

private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {


    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var previousButton: ImageButton
    private lateinit var questionTextView: TextView

    private var correctAnswerCount =0;
    //    private val questionBank = listOf(

    private val AnsweredAll = Question(R.string.completed,
        true,
        true);
    private var questionBank = listOf(
        Question(R.string.question_australia,
            true,
            false),
        Question(R.string.question_oceans,
            true,
            false),
        Question(R.string.question_mideast,
            false,
            false),
        Question(R.string.question_africa,
            false,
            false),
        Question(R.string.question_americas,
            true,
            false),
        Question(R.string.question_asia,
            true,
            false
        ))



    private var currentIndex = 0

    override fun onStart() {
        super.onStart()
        Log.d(TAG, "onStart() called")
    }

    override fun onResume() {
        super.onResume()
        Log.d(TAG, "onResume() called")
    }

    override fun onPause() {
        super.onPause()
        Log.d(TAG, "onPause() called")
    }

    override fun onStop() {
        super.onStop()
        Log.d(TAG, "onStop() called")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy() called")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        Log.w("MainActivity", "from onCreate Activity method")

        println("hello from onCreate Activity method: ");
        println("R.layout.activity_main: ");
        println(R.layout.activity_main);
        // System.out.println("Hello, World!")
//        setTitle(R.string.app_name)
        setContentView(R.layout.activity_main)


        val provider: ViewModelProvider = ViewModelProviders.of(this)
        val quizViewModel = provider.get(QuizViewModel::class.java)
        Log.d(TAG, "Got a QuizViewModel: $quizViewModel")

        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)

        nextButton = findViewById(R.id.next_button)
        previousButton = findViewById(R.id.previous_button)
        questionTextView = findViewById(R.id.question_text_view)



        trueButton.setOnClickListener{view: View ->
            //   Toast.makeText(
            //       this,
            //       R.string.correct_toast,
            //       Toast.LENGTH_SHORT).show()

            checkAnswer(true)

        }

        falseButton.setOnClickListener{view: View ->
            //            val myToast = Toast.makeText(
            //                this,
            //                R.string.incorrect_toast,
            //                Toast.LENGTH_SHORT)

            checkAnswer(false)

            //  val myToast = Toast.makeText(applicationContext,"toast message with gravity",Toast.LENGTH_SHORT)

            //     Toast.makeText(
            //         this,
            //         R.string.incorrect_toast,
            //         Toast.LENGTH_SHORT).setGravity(10,10,10)

        }

        nextButton.setOnClickListener {

            //            if(questionBank[currentIndex+1].answered != true){

            var fullcheck= 0;
            do{
                fullcheck= fullcheck+ 1;
                currentIndex = (currentIndex + 1) % questionBank.size
                Log.i(TAG, "currentIndex: $currentIndex");
                Log.i(TAG,"questionBank[currentIndex].answered: ${questionBank[currentIndex].answered}");
                Log.i(TAG, "fullCheck: $fullcheck");
            }while ((questionBank[currentIndex].answered == true) && (fullcheck<6))
//        }while (questionBank[currentIndex].answered == true)
//            equivalent
//        }while (questionBank[currentIndex].answered)
            //            from (!questionBank[currentIndex].answered)

            Log.i(TAG,"currentIndex before updateQuestion invoked: $currentIndex");
            Log.i(TAG,"questionBank[currentIndex].answered: ${questionBank[currentIndex].answered}");


            // questionBank[currentIndex].answered !=true
//            if(){
//                currentIndex = (currentIndex + 1) % questionBank.size
//            }

            updateQuestion()
            //   val questionTextResId = questionBank[currentIndex].textResId
            //   questionTextView.setText(questionTextResId)

        }

        previousButton.setOnClickListener {

            println("currentIndex: ")
            println(currentIndex)

            println("questionBank.size: ");
            println(questionBank.size);

            if(currentIndex != 0) {
                var fullcheck = 0;
                do {
                    fullcheck = fullcheck + 1;
//                currentIndex = (currentIndex + 1) % questionBank.size
                    currentIndex = currentIndex - 1;
                    if(currentIndex==0){
                        currentIndex = questionBank.size - 1
                    }
                    Log.i(TAG, "currentIndex: $currentIndex");
                    Log.i(
                        TAG,
                        "questionBank[currentIndex].answered: ${questionBank[currentIndex].answered}"
                    );
                    Log.i(TAG, "fullCheck: $fullcheck");
                } while ((questionBank[currentIndex].answered == true) && (fullcheck < 6))
            }

//            if(currentIndex != 0){
//                do{
//                    currentIndex = (currentIndex - 1) % questionBank.size
//                }while (questionBank[currentIndex].answered != true)
//                //    currentIndex = (currentIndex - 1) % questionBank.size
//            }
            else{

                currentIndex = questionBank.size - 1
                var fullcheck = 0;
                do {
                    fullcheck = fullcheck + 1;
//                currentIndex = (currentIndex + 1) % questionBank.size
                    currentIndex = (currentIndex - 1) % questionBank.size
                    Log.i(TAG, "currentIndex: $currentIndex");
                    Log.i(
                        TAG,
                        "questionBank[currentIndex].answered: ${questionBank[currentIndex].answered}"
                    );
                    Log.i(TAG, "fullCheck: $fullcheck");
                } while ((questionBank[currentIndex].answered == true) && (fullcheck < 6))

//                do{
//                    currentIndex = currentIndex
//                }while (!questionBank[currentIndex].answered)

//                currentIndex = questionBank.size - 1
            }
            println("currentIndex: ")
            println(currentIndex)

            updateQuestion()
        }

        updateQuestion()
        //   val questionTextResId = questionBank[currentIndex].textResId
        //   questionTextView.setText(questionTextResId)
    }

    private fun updateQuestion() {

        var questionTextResId: Int;
        var attemptedAll: Int = 0;
        if(questionBank[currentIndex].answered){

            Log.i(TAG,"questionBank[currentIndex].answered: ${questionBank[currentIndex].answered}");
            questionTextResId = AnsweredAll.textResId

            Log.i(TAG,"correctAnswerCount: $correctAnswerCount")
            attemptedAll = 1;
        }
        else{

            Log.i(TAG,"!questionBank[currentIndex].answered: ");

            questionTextResId = questionBank[currentIndex].textResId
        }

        var stringResponse: String = getString(questionTextResId)

        if (attemptedAll==1){
            stringResponse = stringResponse + "result: " + correctAnswerCount +"/${questionBank.size}"
            questionTextView.setText(stringResponse)

        }else{
            questionTextView.setText(stringResponse)
        }


    }

    private fun checkAnswer(userAnswer: Boolean) {
        println("userAnswer _______________________: ");
        println(userAnswer);

        val correctAnswer = questionBank[currentIndex].answer
        println("correctAnswer:____________________ ");
        println(correctAnswer);

//        if(userAnswer == correctAnswer){
//            correctAnswerCount = correctAnswerCount+1;
//        }
        val messageResId = if (userAnswer == correctAnswer) {
            correctAnswerCount = ++correctAnswerCount;
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        questionBank[currentIndex].answered = true;

        val myToast = Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)

        myToast.setGravity(Gravity.TOP,0,200)
        myToast.show()
        //  .show()
    }
}
