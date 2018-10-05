package com.example.jdalv.numbershapes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // create number class
    class Number {
        int number; // initialize integer type variable

        // method that determines if number is triangular
        public boolean isTriangular() {
            int x = 1; // initialize and declare counter variable
            int triangularNumber = 1; // initialize and declare triangular number

            // loop that executes until index counter variable x is less than input number value
            while (triangularNumber < number) {
                x++; // increment counter

                triangularNumber = triangularNumber + x; // add triangular number and counter to create sequence of triangular numbers
            }

            // execute when triangular number has same value as input number
            if (triangularNumber == number) {
                return true; // return true to indicate number is a triangular number
                // execute when triangular number does not have same value as input number
            } else {
                return false; // return false to indicate number is not triangular
            }
        }

        // method that determines if number is square
        public boolean isSquare() {
            double squareRoot = Math.sqrt(number); // initialize and declare square root value of input number

            // execute when squareRoot variable value is a whole number (int)
            if (squareRoot == Math.floor(squareRoot)) {
                return true; // return true to indicate the number is a square number
            } else {
                return false; // return false to indicate the number is not a square number
            }
        }
    }

    public void testNumber(View view) {

        Log.i("Info", "Button pressed!"); // log button click to the Logcat

        EditText editText = (EditText) findViewById(R.id.editText); // initialize and declare input field component

        String message; // initialize string variable that will contain custom message displayed to user

        if (editText.getText().toString().isEmpty()) {
            message = "Please enter a number!";
        } else {
            Number myNumber = new Number(); // construct that creates object-type of number

            myNumber.number = Integer.parseInt(editText.getText().toString()); // set integer for number object

            message = editText.getText().toString(); // set custom message to begin with number inputted by user

            if (myNumber.isSquare() && myNumber.isTriangular()) {
                message += " is square and triangular!";
            } else if (myNumber.isSquare()) {
                message += " is square but not triangular.";
            } else if (myNumber.isTriangular()) {
                message += " is triangular but not square.";
            } else {
                message += " is neither triangular nor square.";
            }
        }

        Toast.makeText(this, message, Toast.LENGTH_LONG).show(); // display toast with custom message

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
