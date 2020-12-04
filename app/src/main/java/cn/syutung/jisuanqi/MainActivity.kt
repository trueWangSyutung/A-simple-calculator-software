package cn.syutung.jisuanqi


import android.R.attr.bitmap
import android.annotation.SuppressLint
import android.app.Service
import android.app.WallpaperManager
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.os.Vibrator
import android.view.View
import android.view.WindowManager
import android.widget.LinearLayout
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {
    protected var useThemestatusBarColor = false
    protected var useStatusBarColor = true


    fun shouToast(sss:String){
        Toast.makeText(this,sss,Toast.LENGTH_SHORT).show()
    }

    private fun copyToClipboard(info: String) {
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

    private fun layoutBackgroundBlur(context: Context?, i : Int){
        val layout : ConstraintLayout =findViewById<ConstraintLayout>(i)
        val wallpaperManager: WallpaperManager = WallpaperManager.getInstance(context)
        val wallpaperDrawable: Drawable = wallpaperManager.drawable
        val bd = wallpaperDrawable as BitmapDrawable
        val bm = bd.bitmap
        val drawable: Drawable =   BitmapDrawable(resources, Tools.blurBitmap(context, bm, 12F))
        layout.background = drawable
    }

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.KITKAT)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        layoutBackgroundBlur(this,R.id.mainlayout)

        if (Build.VERSION.SDK_INT>=21){
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }

        var numxiao1=0.0
        var numxiao2=0.0
        var have_xiaoshudian=false


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
            

        }
        number1.setOnClickListener {
            

            input.text=input.text.toString()+"1"
            
        }
        number2.setOnClickListener {


            input.text=input.text.toString()+"2"
            
        }
        number3.setOnClickListener {

            input.text=input.text.toString()+"3"
            
        }

        number4.setOnClickListener {

            input.text=input.text.toString()+"4"
            
        }
        number5.setOnClickListener {

            input.text=input.text.toString()+"5"
            

        }
        number6.setOnClickListener {

            input.text=input.text.toString()+"6"
            

        }
        number7.setOnClickListener {

            input.text=input.text.toString()+"7"
            

        }
        number8.setOnClickListener {

            input.text=input.text.toString()+"8"
            

        }
        number9.setOnClickListener {

            input.text=input.text.toString()+"9"
            

        }
        numberxJIA.setOnClickListener {
            fuhao1.text="+"
            if(input.text.toString()==""){
                

            }
            else {
                

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
                

            } else {
                

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
                

            } else {
                

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
                

            } else {
                

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
                

            } else {
                

                input.text = ((input.text.toString().toDouble()) / 100).toString()
                have_xiaoshudian = true

            }
        }
        numberc.setOnClickListener {
            if (input.text.toString() == "") {
                

            } else {
                

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
                
                Toast.makeText(this,"小数点已经存在，不可重复输入",Toast.LENGTH_SHORT).show()
            }
            else{
                if (input.text.toString() == "") {
                    

                } else {
                    

                    input.text = input.text.toString() + "."
                    have_xiaoshudian = true
                }
            }

        }
        numberdel.setOnClickListener {
            
            input.text=""
            gongshi.text=""
            numxiao1=0.0
            numxiao2=0.0


        }

        numberxdeng.setOnClickListener {
            if (input.text.toString() == "") {
                

            }
            else {
                

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

}
