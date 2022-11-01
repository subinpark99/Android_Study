package com.example.android.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.android.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding  //바인딩 변수 정의

    private val myName: MyName = MyName("Aleks Haecky")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        binding.doneButton.setOnClickListener {
            addNickname(it)
        }
    }

    private fun addNickname(view: View) {

        binding. apply {
            myName?.nickname = nicknameEdit.text.toString()
            invalidateAll()  //업데이트된 바인딩 개체의 값으로 새로 고쳐지도록 설정
            nicknameEdit.visibility = View.GONE
            doneButton.visibility = View.GONE
            nicknameText.visibility = View.VISIBLE
        }

//        binding.nicknameText.text = binding.nicknameEdit.text.toString()
//        binding.nicknameEdit.visibility = View.GONE
//        binding.doneButton.visibility = View.GONE
//        binding.nicknameText.visibility = View.VISIBLE

       val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
