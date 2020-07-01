package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_more.*

class More : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)

        jinzhi.setOnClickListener {
            val intant = Intent(this,JinZhi::class.java)
            startActivity(intant)
        }


        jqqd.setOnClickListener {
            Toast.makeText(this,"敬请期待",Toast.LENGTH_SHORT).show()
        }
    }
}
