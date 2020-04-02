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

private const val TAG = "MainActivity"


class MainActivity : AppCompatActivity() {


    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var nextButton: Button
    private lateinit var previousButton: ImageButton
    private lateinit var questionTextView: TextView

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, false),
        Question(R.string.question_africa, false),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true))



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
            currentIndex = (currentIndex + 1) % questionBank.size


            updateQuestion()
            //   val questionTextResId = questionBank[currentIndex].textResId
            //   questionTextView.setText(questionTextResId)

        }

        previousButton.setOnClickListener {

            println("currentIndex: ")
            println(currentIndex)

            println("questionBank.size: ");
            println(questionBank.size);

            if(currentIndex != 0){
                currentIndex = (currentIndex - 1) % questionBank.size
            }
            else{
                currentIndex = questionBank.size - 1
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
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }

    private fun checkAnswer(userAnswer: Boolean) {
        println("userAnswer _______________________: ");
        println(userAnswer);

        val correctAnswer = questionBank[currentIndex].answer
        println("correctAnswer:____________________ ");
        println(correctAnswer);

        val messageResId = if (userAnswer == correctAnswer) {
            R.string.correct_toast
        } else {
            R.string.incorrect_toast
        }

        val myToast = Toast.makeText(this, messageResId, Toast.LENGTH_SHORT)

        myToast.setGravity(Gravity.TOP,0,200)
        myToast.show()
        //  .show()
    }



}
