package com.arefinsultan.android.geoquiz

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.Toast


class MainActivity : AppCompatActivity() {


    private lateinit var trueButton: Button
    private lateinit var falseButton: Button


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

        trueButton.setOnClickListener{view: View ->
            Toast.makeText(
                this,
                R.string.correct_toast,
                Toast.LENGTH_SHORT).show()



        }

        falseButton.setOnClickListener{view: View ->
            val myToast = Toast.makeText(
                this,
                R.string.incorrect_toast,
                Toast.LENGTH_SHORT)

//            val myToast = Toast.makeText(applicationContext,"toast message with gravity",Toast.LENGTH_SHORT)
            myToast.setGravity(Gravity.TOP,0,200)
            myToast.show()

//            Toast.makeText(
//                this,
//                R.string.incorrect_toast,
//                Toast.LENGTH_SHORT).setGravity(10,10,10)

        }
    }


}
