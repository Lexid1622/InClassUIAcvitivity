package edu.temple.inclassuiacvitivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spinner = findViewById<Spinner>(R.id.spinner)
        val changeButton = findViewById<Button>(R.id.changeButton)
        val displayTextView = findViewById<TextView>(R.id.textDisplay)

        // Step 1: Populate array
        //val numberArray = IntArray(100)

        //set text size to a basic number
        var textNum = 14
        //change the array to set the values in the spinner
        val numberArray = (1 until 100).toList().toIntArray()

        for (item in numberArray) {
            spinner.adapter =
                ArrayAdapter(this, android.R.layout.simple_list_item_1, numberArray.asList())
        }

        // Step 2: Save selected text size
        spinner.onItemSelectedListener = object: AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                //get item at position from onItemSelected and cast as int
               textNum = parent!!.getItemAtPosition(position) as Int

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Step 3: Change TextView to saved text size
        changeButton.setOnClickListener {
            //looked online for .setTextSize function
            displayTextView.setTextSize(textNum.toFloat())
            //I had to cast to a float to fix a warning, not exactly sure why

        }

    }
}