package cn.syutung.jisuanqi


import android.app.Service
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    protected var useThemestatusBarColor = false
    protected var useStatusBarColor = true
    fun copyToClipboard(info: String) {
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText(info,info)
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(this,"已复制结果哦到剪贴板",Toast.LENGTH_SHORT).show()
    }

    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig)
        val mySysTheme =
            newConfig.uiMode and Configuration.UI_MODE_NIGHT_MASK
        when(mySysTheme){
            Configuration.UI_MODE_NIGHT_YES ->{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
            }
            Configuration.UI_MODE_NIGHT_NO ->{
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
            }
        }
        recreate()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        setStatusBar()
        var numxiao1=0.0
        var numxiao2=0.0
        var have_xiaoshudian=false
        val vibrator = getSystemService(Service.VIBRATOR_SERVICE) as Vibrator
        val madas = longArrayOf(10,30)

        about3.setOnClickListener {
            val intant = Intent(this, About::class.java)
            startActivity(intant)
        }
        more3.setOnClickListener {
            val intant = Intent(this, More::class.java)
            startActivity(intant)
        }
        gongshi.setOnClickListener {
            copyToClipboard(gongshi.text.toString())
        }
        number0.setOnClickListener {
            input.text=input.text.toString()+"0"
            vibrator.vibrate(madas, -1)

        }
        number1.setOnClickListener {
            

            input.text=input.text.toString()+"1"
            vibrator.vibrate(madas, -1)
        }
        number2.setOnClickListener {


            input.text=input.text.toString()+"2"
            vibrator.vibrate(madas, -1)
        }
        number3.setOnClickListener {

            input.text=input.text.toString()+"3"
            vibrator.vibrate(madas, -1)
        }

        number4.setOnClickListener {

            input.text=input.text.toString()+"4"
            vibrator.vibrate(madas, -1)
        }
        number5.setOnClickListener {

            input.text=input.text.toString()+"5"
            vibrator.vibrate(madas, -1)

        }
        number6.setOnClickListener {

            input.text=input.text.toString()+"6"
            vibrator.vibrate(madas, -1)

        }
        number7.setOnClickListener {

            input.text=input.text.toString()+"7"
            vibrator.vibrate(madas, -1)

        }
        number8.setOnClickListener {

            input.text=input.text.toString()+"8"
            vibrator.vibrate(madas, -1)

        }
        number9.setOnClickListener {

            input.text=input.text.toString()+"9"
            vibrator.vibrate(madas, -1)

        }
        numberxJIA.setOnClickListener {
            fuhao1.text="+"
            if(input.text.toString()==""){
                vibrator.vibrate(madas, -1)

            }
            else {
                vibrator.vibrate(madas, -1)

                if (have_xiaoshudian == true) {
                    if (numxiao1 == 0.0) {
                        numxiao1 = input.text.toString().toDouble()
                        gongshi.text = input.text.toString()

                    } else if (numxiao1 != 0.0) {
                        numxiao2 = input.text.toString().toDouble()
                        gongshi.text=gongshi.text.toString()+numxiao2.toString()
                        gongshi.text = (numxiao1 + numxiao2).toString()
                        numxiao1= gongshi.text.toString().toDouble()
                        numxiao2= 0.0

                    }
                }
                else {
                    if (numxiao1 == 0.0) {
                        numxiao1 = input.text.toString().toDouble()
                        gongshi.text = input.text.toString()
                    } else if (numxiao1 != 0.0) {
                        numxiao2 = input.text.toString().toDouble()
                        gongshi.text=gongshi.text.toString()+numxiao2.toString()

                        gongshi.text = (numxiao1 + numxiao2).toString()
                        numxiao1=gongshi.text.toString().toDouble()

                        numxiao2=0.0

                    }


        }
                input.text=""
                have_xiaoshudian = false

            }
        }

        numberxJIAN.setOnClickListener {
            fuhao1.text = "-"
            if (input.text.toString() == "") {
                vibrator.vibrate(madas, -1)

            } else {
                vibrator.vibrate(madas, -1)

                if (have_xiaoshudian == true) {
                    if (numxiao1 == 0.0) {
                        numxiao1 = input.text.toString().toDouble()
                        gongshi.text = input.text.toString()

                    } else if (numxiao1 != 0.0) {
                        numxiao2 = input.text.toString().toDouble()
                        gongshi.text = gongshi.text.toString() + numxiao2.toString()
                        gongshi.text = (numxiao1 - numxiao2).toString()
                        numxiao1 = gongshi.text.toString().toDouble()
                        numxiao2 = 0.0

                    }
                } else {
                    if (numxiao1 == 0.0) {
                        numxiao1 = input.text.toString().toDouble()
                        gongshi.text = input.text.toString()
                    } else if (numxiao1 != 0.0) {
                        numxiao2 = input.text.toString().toDouble()
                        gongshi.text = gongshi.text.toString() + numxiao2.toString()

                        gongshi.text = (numxiao1 - numxiao2).toString().toString()
                        numxiao1 = gongshi.text.toString().toDouble()

                        numxiao2 = 0.0

                    }


                    input.text = ""
                    have_xiaoshudian = false


                }
            }
        }
        numberx.setOnClickListener {
            fuhao1.text = "×"
            if (input.text.toString() == "") {
                vibrator.vibrate(madas, -1)

            } else {
                vibrator.vibrate(madas, -1)

                if (have_xiaoshudian == true) {
                    if (numxiao1 == 0.0) {
                        numxiao1 = input.text.toString().toDouble()
                        gongshi.text = input.text.toString()

                    } else if (numxiao1 != 0.0) {
                        numxiao2 = input.text.toString().toDouble()
                        gongshi.text = gongshi.text.toString() + numxiao2.toString()
                        gongshi.text = (numxiao1 * numxiao2).toString()
                        numxiao1 = gongshi.text.toString().toDouble()
                        numxiao2 = 0.0

                    }
                } else {
                    if (numxiao1 == 0.0) {
                        numxiao1 = input.text.toString().toDouble()
                        gongshi.text = input.text.toString()
                    } else if (numxiao1 != 0.0) {
                        numxiao2 = input.text.toString().toDouble()
                        gongshi.text = gongshi.text.toString() + numxiao2.toString()

                        gongshi.text = (numxiao1 * numxiao2).toString().toString()
                        numxiao1 = gongshi.text.toString().toDouble()

                        numxiao2 = 0.0

                    }

                }




                input.text = ""
                have_xiaoshudian = false


            }
        }

        numberxchu.setOnClickListener {
            fuhao1.text = "÷"
            if (input.text.toString() == "") {
                vibrator.vibrate(madas, -1)

            } else {
                vibrator.vibrate(madas, -1)

                if (have_xiaoshudian == true) {
                    if (numxiao1 == 0.0) {
                        numxiao1 = input.text.toString().toDouble()
                        gongshi.text = input.text.toString()

                    } else if (numxiao1 != 0.0) {
                        numxiao2 = input.text.toString().toDouble()
                        gongshi.text = gongshi.text.toString() + numxiao2.toString()
                        gongshi.text = (numxiao1 / numxiao2).toString()
                        numxiao1 = gongshi.text.toString().toDouble()
                        numxiao2 = 0.0

                    }
                } else {
                    if (numxiao1 == 0.0) {
                        numxiao1 = input.text.toString().toDouble()
                        gongshi.text = input.text.toString()
                    } else if (numxiao1 != 0.0) {
                        numxiao2 = input.text.toString().toDouble()
                        gongshi.text = gongshi.text.toString() + numxiao2.toString()

                        gongshi.text = (numxiao1 / numxiao2).toString()
                        numxiao1 = gongshi.text.toString().toDouble()

                        numxiao2 = 0.0

                    }
                    input.text = ""
                    have_xiaoshudian = false

                }




            }
        }
        numberbaifen.setOnClickListener {
            if (input.text.toString() == "") {
                vibrator.vibrate(madas, -1)

            } else {
                vibrator.vibrate(madas, -1)

                input.text = ((input.text.toString().toDouble()) / 100).toString()
                have_xiaoshudian = true

            }
        }
        numberc.setOnClickListener {
            if (input.text.toString() == "") {
                vibrator.vibrate(madas, -1)

            } else {
                vibrator.vibrate(madas, -1)

                if (input.text.toString() == "") {

                } else {
                    var m = input.text.toString()
                    val char1 = m.last()
                    if (char1 == '.' || have_xiaoshudian == true) {
                        have_xiaoshudian = false
                    }

                    input.text = m.substring(0,m.length-1)
                }


            }
        }
        numberdian.setOnClickListener {
            if (have_xiaoshudian==true){
                vibrator.vibrate(madas, -1)
                Toast.makeText(this,"小数点已经存在，不可重复输入",Toast.LENGTH_SHORT).show()
            }
            else{
                if (input.text.toString() == "") {
                    vibrator.vibrate(madas, -1)

                } else {
                    vibrator.vibrate(madas, -1)

                    input.text = input.text.toString() + "."
                    have_xiaoshudian = true
                }
            }

        }
        numberdel.setOnClickListener {
            vibrator.vibrate(madas, -1)
            input.text=""
            gongshi.text=""
            numxiao1=0.0
            numxiao2=0.0


        }

        numberxdeng.setOnClickListener {
            if (input.text.toString() == "") {
                vibrator.vibrate(madas, -1)

            }
            else {
                vibrator.vibrate(madas, -1)

                val t = input.text.toString()
                gongshi.text = gongshi.text.toString() +fuhao1.text+ t

                if (fuhao1.text == "+") {
                    if (have_xiaoshudian == true) {
                        if (numxiao1 == 0.0) {
                            numxiao1 = input.text.toString().toDouble()
                        } else if (numxiao1 != 0.0) {
                            numxiao2 = input.text.toString().toDouble()
                        }
                    } else {
                        if (numxiao1 == 0.0) {
                            numxiao1 = input.text.toString().toDouble()
                        } else if (numxiao1 != 0.0) {
                            numxiao2 = input.text.toString().toDouble()
                        }
                    }
                    if (have_xiaoshudian == true) {

                        gongshi.text = (numxiao1 + numxiao2).toString()
                    } else {
                        gongshi.text = (numxiao1 + numxiao2).toLong().toString()
                    }
                } else if (fuhao1.text== "-") {
                    if (have_xiaoshudian == true) {
                        if (numxiao1 == 0.0) {
                            numxiao1 = input.text.toString().toDouble()
                        } else if (numxiao1 != 0.0) {
                            numxiao2 = input.text.toString().toDouble()
                        }
                    } else {
                        if (numxiao1 == 0.0) {
                            numxiao1 = input.text.toString().toDouble()
                        } else if (numxiao1 != 0.0) {
                            numxiao2 = input.text.toString().toDouble()
                        }
                    }
                    if (have_xiaoshudian == true) {
                        gongshi.text = (numxiao1 - numxiao2).toString()
                    } else {
                        gongshi.text = (numxiao1 - numxiao2).toLong().toString()
                    }
                } else if (fuhao1.text== "×") {
                    if (have_xiaoshudian == true) {
                        if (numxiao1 == 0.0) {
                            numxiao1 = input.text.toString().toDouble()
                        } else if (numxiao1 != 0.0) {
                            numxiao2 = input.text.toString().toDouble()
                        }
                    } else {
                        if (numxiao1 == 0.0) {
                            numxiao1 = input.text.toString().toDouble()
                        } else if (numxiao1 != 0.0) {
                            numxiao2 = input.text.toString().toDouble()
                        }
                    }
                    if (have_xiaoshudian == true) {
                        gongshi.text = (numxiao1 * numxiao2).toString()
                    } else {
                        gongshi.text = (numxiao1 * numxiao2).toString().toString()
                    }
                } else {
                    if (have_xiaoshudian == true) {
                        if (numxiao1 == 0.0) {
                            numxiao1 = input.text.toString().toDouble()
                        } else if (numxiao1 != 0.0) {
                            numxiao2 = input.text.toString().toDouble()
                        }
                    } else {
                        if (numxiao1 == 0.0) {
                            numxiao1 = input.text.toString().toDouble()
                        } else if (numxiao1 != 0.0) {
                            numxiao2 = input.text.toString().toDouble()
                        }
                    }
                    if (have_xiaoshudian == true) {
                        gongshi.text = (numxiao1 / numxiao2).toString()
                    } else {
                        gongshi.text= (numxiao1 / numxiao2).toString()
                    }
                }
                input.text=""
                have_xiaoshudian = false
                if (have_xiaoshudian == true) {
                    numxiao1 = gongshi.text.toString().toDouble()
                    numxiao2 = 0.0
                } else {
                    numxiao1 = gongshi.text.toString().toDouble()
                    numxiao2 = 0.0


                }
            }
        }
    }

    protected fun setStatusBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) { //5.0及以上
            val decorView: View = window.decorView
            val option: Int = (View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    or View.SYSTEM_UI_FLAG_LAYOUT_STABLE)
            decorView.setSystemUiVisibility(option)
            //根据上面设置是否对状态栏单独设置颜色
            if (useThemestatusBarColor) {
                window.statusBarColor = resources.getColor(R.color.background_light) //设置状态栏背景色
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
}
