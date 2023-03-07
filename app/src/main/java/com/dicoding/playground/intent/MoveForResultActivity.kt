package com.dicoding.playground.intent

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioGroup

class MoveForResultActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var btnChoose: Button
    private lateinit var rgNumber: RadioGroup
    companion object {
        const val EXTRA_SELECTED_VALUE = "extra_selected_value"
        const val RESULT_CODE = 110
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_for_result)

        btnChoose = findViewById(R.id.btn_choose)
        rgNumber = findViewById(R.id.rg_number)

        btnChoose.setOnClickListener(this)
    }

    override fun onClick(view: View?) {
        if (view?.id == R.id.btn_choose) {
            if (rgNumber.checkedRadioButtonId > 0) {
                val value = when (rgNumber.checkedRadioButtonId) {
                    R.id.rb_50 -> 50
                    R.id.rb_100 -> 100
                    R.id.rb_150 -> 150
                    R.id.rb_200 -> 200
                    else -> 0
                }

                Intent().apply {
                    putExtra(EXTRA_SELECTED_VALUE, value)
                    setResult(RESULT_CODE, this)
                    finish()
                }
            }
        }
    }

}