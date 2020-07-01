package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_jin_zhi.*

class JinZhi : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jin_zhi)
        qingkong.setOnClickListener {
            shijinzhi.setText("")
            bajinzhi.setText("")
            erjinzhi.setText("")
            shiliujinzhi.setText("")
        }
        quren.setOnClickListener {
            val bajinzhi1 = bajinzhi.text.toString()
            val erjinzhi1 = erjinzhi.text.toString()
            val shiliujinzhi1 =shiliujinzhi.text.toString()
            val shijinzhi1 =shijinzhi.text.toString()
            if (shijinzhi.text.toString()!="" && bajinzhi1 =="" && shiliujinzhi1==""  &&erjinzhi1==""){
                val shi =shijinzhi.text.toString().toInt()
                bajinzhi.setText(toEight(shi))
                erjinzhi.setText(toEr(shi))
                shiliujinzhi.setText(toShiLiu(shi))
            }
            else if(bajinzhi.text.toString()!="" && shijinzhi1=="" && erjinzhi1=="" && shiliujinzhi1==""){
                val shi = ba_to_10(bajinzhi.text.toString().toInt()).toInt()
                shijinzhi.setText(shi.toString())
                erjinzhi.setText(toEr(shi))
                shiliujinzhi.setText(toShiLiu(shi))
            }
            else if(erjinzhi.text.toString()!="" && shijinzhi1=="" && bajinzhi1=="" && shiliujinzhi1==""){
                val shi = er_to_10(erjinzhi.text.toString().toInt()).toInt()
                shijinzhi.setText(shi.toString())
                bajinzhi.setText(toEight(shi))
                shiliujinzhi.setText(toShiLiu(shi))
            }
            else if(shiliujinzhi.text.toString()!="" && shijinzhi1=="" && erjinzhi1=="" && erjinzhi1=="" ){
                val shi = shiliu_to_10(shiliujinzhi.text.toString()).toInt()
                shijinzhi.setText(shi.toString())
                bajinzhi.setText(toEight(shi))
                erjinzhi.setText(toEr(shi))
            }
            else{
                Toast.makeText(this,"输入错误" +
                        "", Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun toEight(num:Int): String {
        var l=num
        var m= ""
        var p=""
        while (l != 0) {
            var k = l % 8
            m = m + k.toString()
            l = l / 8
        }
        for (i in 0 until m.length){
            p=p+m[m.length-1-i]
        }
        return p

    }
    fun toEr(num:Int): String {
        var l=num
        var m= ""
        var p =""
        while (l != 0) {
            var k = l % 2
            m = m + k.toString()
            l = l / 2
        }
        for (i in 0 until m.length){
            p=p+m[m.length-1-i]
        }
        return p

    }
    fun toShiLiu(num:Int): String {
        val lm = arrayOf("0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F")
        var l=num
        var m =""
        var p=""
        while (l != 0) {
            var k = l % 16
            m = m + lm[k]
            l = l / 16
        }
        for (i in 0 until m.length){
            p=p+m[m.length-1-i]
        }
        return p
    }

    fun er_to_10(num:Int):String{
        var t=num
        var s=0
        var long =  t.toString().length
        for (i in 0 until long){
            if (i==0){
                s+=(t%10)
                t=t/10
            }
            else{
                s+=(t%10)*cifang(2,i)
                t=t/10
            }
        }
        return s.toString()
    }

    fun ba_to_10(num:Int):String{
        var t=num
        var s=0
        var long =  t.toString().length
        for (i in 0 until long){
            if (i==0){
                s+=(t%10)
                t=t/10
            }
            else{
                s+=(t%10)*cifang(8,i)
                t=t/10
            }
        }
        return s.toString()
    }

    fun shiliu_to_10(num:String):String{

        return num.toInt(16).toString()
    }

    fun cifang(num:Int,a: Int) :Int {
       return Math.pow(num.toDouble(), a.toDouble()).toInt()
    }

}
