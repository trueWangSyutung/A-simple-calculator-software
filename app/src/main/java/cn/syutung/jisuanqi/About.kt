package cn.syutung.jisuanqi

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import com.example.myapplication.R
import kotlinx.android.synthetic.main.activity_about.*

class About : AppCompatActivity() {
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
        setContentView(R.layout.activity_about)
        setStatusBar()
        kaiyuan.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW)
            intent.data = Uri.parse("https://github.com/Syutung2/A-simple-calculator-software")
            startActivity(intent);

        }

        yinsi.setOnClickListener {
            val intent = Intent(this,YinsixieyiActivity::class.java)
            startActivity(intent)
        }


    }
}
