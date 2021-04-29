package com.spreys.colormyviews

import android.content.res.ColorStateList
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.databinding.DataBindingUtil
import com.spreys.colormyviews.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.apply {
            arrayOf<View>(
                boxOneText, boxTwoText, boxThreeText, boxFourText, boxFiveText, rootElement,
                greenButton, redButton, yellowButton
            ).forEach { view ->
                view.setOnClickListener { handleClick(it) }
            }
        }
    }

    private fun handleClick(view: View) {
        binding.apply {
            when (view) {
                boxOneText -> view.setBackgroundColor(Color.DKGRAY)
                boxTwoText -> view.setBackgroundColor(Color.GRAY)
                boxThreeText -> view.setBackgroundResource(android.R.color.holo_green_light)
                boxFourText -> view.setBackgroundResource(android.R.color.holo_green_dark)
                boxFiveText -> view.setBackgroundResource(android.R.color.holo_green_light)
                greenButton -> setBackgroundColor(view, R.color.my_green)
                yellowButton -> setBackgroundColor(view, R.color.my_yellow)
                redButton -> setBackgroundColor(view, R.color.my_red)
                else -> view.setBackgroundColor(Color.LTGRAY)
            }
        }
    }

    private fun setBackgroundColor(button: View, colorResourceId: Int) {
        val color = ContextCompat.getColor(this@MainActivity, colorResourceId)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            button.backgroundTintList = ColorStateList.valueOf(color)
        } else {
            ViewCompat.setBackgroundTintList(button, ColorStateList.valueOf(color));
        }
    }
}
