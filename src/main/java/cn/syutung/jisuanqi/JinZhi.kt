package cn.syutung.jisuanqi

import android.app.Service
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Vibrator
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_jin_zhi.*



class JinZhi : AppCompatActivity() {
    protected var useThemestatusBarColor = false
    protected var useStatusBarColor = true
    protected fun setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { //5.0及以上
            val decorView: View = window.decorView
            val option: Int = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            decorView.setSystemUiVisibility(option)
            //根据上面设置是否对状态栏单独设置颜色
            if (useThemestatusBarColor) {
                window.statusBarColor = resources.getColor(android.R.color.background_light) //设置状态栏背景色
            } else {
                window.statusBarColor = Color.TRANSPARENT //透明
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) { //4.4到5.0
            val localLayoutParams = window.attributes
            localLayoutParams.flags =
                WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS or localLayoutParams.flags
        } else {
            Toast.makeText(this, "低于4.4的android系统版本不存在沉浸式状态栏", Toast.LENGTH_SHORT).show()
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M && useStatusBarColor) { //android6.0以后可以对状态栏文字颜色和图标进行修改
            window.decorView.systemUiVisibility =
                View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN or View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_jin_zhi)


        setStatusBar()
        val vibrator = getSystemService(Service.VIBRATOR_SERVICE) as Vibrator
        val madas = longArrayOf(10,30)
        qingkong.setOnClickListener {
            vibrator.vibrate(madas, -1)

            shijinzhi.setText("")
            bajinzhi.setText("")
            erjinzhi.setText("")
            shiliujinzhi.setText("")
            bajinzhi.setEnabled(true)
            erjinzhi.setEnabled(true)
            shijinzhi.setEnabled(true)
            shiliujinzhi.setEnabled(true)
        }

        shiliujinzhi.addTextChangedListener(  object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                bajinzhi.setEnabled(false)
                erjinzhi.setEnabled(false)
                shijinzhi.setEnabled(false)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
        bajinzhi.addTextChangedListener(  object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                shiliujinzhi.setEnabled(false)
                erjinzhi.setEnabled(false)
                shijinzhi.setEnabled(false)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
        erjinzhi.addTextChangedListener(  object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                bajinzhi.setEnabled(false)
                shiliujinzhi.setEnabled(false)
                shijinzhi.setEnabled(false)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })
        shijinzhi.addTextChangedListener(  object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                bajinzhi.setEnabled(false)
                erjinzhi.setEnabled(false)
                shiliujinzhi.setEnabled(false)
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

        })

        quren.setOnClickListener {
            vibrator.vibrate(madas, -1)

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
                val numinput  = bajinzhi.text.toString()
                var s = 0
                for (i in 0 until  numinput.length){
                        if (numinput[i] in  '0'..'7' ){
                            s+=0
                        }
                        else{
                            s+=1
                        }


                }

                if (s == 0){
                    val shi = ba_to_10(numinput.toInt()).toInt()
                    shijinzhi.setText(shi.toString())
                    erjinzhi.setText(toEr(shi))
                    shiliujinzhi.setText(toShiLiu(shi))
                }
                else{
                    Toast.makeText(this,"您的八进制数输入错误" +
                            "", Toast.LENGTH_SHORT).show()
                }


            }
            else if(erjinzhi.text.toString()!="" && shijinzhi1=="" && bajinzhi1=="" && shiliujinzhi1==""){
                val numinput  = erjinzhi.text.toString()
                var s = 0
                for (i in 0 until  numinput.length){
                    if (numinput[i] in '0'..'1' ){
                        s+=0
                    }
                    else{
                        s+=1
                    }
                }
                if (s != 0){
                    Toast.makeText(this,"您的二进制数输入错误" +
                            "", Toast.LENGTH_SHORT).show()
                }
                else{
                    val shi = er_to_10(numinput.toInt())
                    shijinzhi.setText(shi.toString())
                    bajinzhi.setText(toEight(shi.toInt()))
                    shiliujinzhi.setText(toShiLiu(shi.toInt()))
                }


            }
            else if(shiliujinzhi.text.toString()!="" && shijinzhi1=="" && erjinzhi1=="" && erjinzhi1=="" ){
                val numinput  = shiliujinzhi.text.toString()
                var s = 0
                for (i in 0 until  numinput.length){
                    if (numinput[i] in '0'..'9' || numinput[i] in 'A'..'F' ){
                        s+=0
                    }
                    else{
                        s+=1
                    }
                }
                if (s != 0){
                    Toast.makeText(this,"您的十六进制数输入错误" +
                            "", Toast.LENGTH_SHORT).show()
                }
                else{
                    val shi = shiliu_to_10(numinput).toInt()
                    shijinzhi.setText(shi.toString())
                    bajinzhi.setText(toEight(shi))
                    erjinzhi.setText(toEr(shi))
                }




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
    fun toShiLiu(num: Int): String {
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

    fun er_to_10(num: Int):String{
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



