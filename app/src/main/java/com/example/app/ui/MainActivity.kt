package com.example.app.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mgsoftware.gradientimageview.widget.GradientImageView
import com.example.app.R
import com.example.app.ui.main.MainFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        GradientImageView.debug = true

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fm = supportFragmentManager
        val fragment = fm.findFragmentById(R.id.my_content)
        if(fragment == null) {
            val ft = fm.beginTransaction()
            ft.replace(R.id.my_content, MainFragment.newInstance(), MainFragment::class.java.name)
            ft.commit()
        }
    }
}
