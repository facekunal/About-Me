package com.example.aboutme

import android.app.Activity
import android.opengl.Visibility
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    var myName: MyName = MyName("John Doe")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.myName = myName

        //findViewById<Button>(R.id.done_button).setOnClickListener(this::addNickname)
        binding.doneButton.setOnClickListener(this::addNickname)
    }

    fun addNickname(view: View) {
        //copy edit content to text view
        binding.apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()
            //hide edit and done
            nicknameEdit.visibility = View.GONE
            view.visibility = View.GONE
            //show text
            nicknameText.visibility = View.VISIBLE
        }

        val imm: InputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
