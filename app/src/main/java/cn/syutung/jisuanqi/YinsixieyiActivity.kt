package cn.syutung.jisuanqi

import android.annotation.SuppressLint
import android.app.PendingIntent.getActivity
import android.app.WallpaperManager
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.content.res.Resources
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.DisplayMetrics
import android.view.WindowManager
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_yinsixieyi.*
import java.security.AccessController.getContext
import java.util.*

class YinsixieyiActivity : AppCompatActivity() {
    private fun layoutBackgroundBlur(context: Context?, i : Int){
        val layout : RelativeLayout =findViewById<RelativeLayout>(i)
        val wallpaperManager: WallpaperManager = WallpaperManager.getInstance(context)
        val wallpaperDrawable: Drawable = wallpaperManager.drawable
        val bd = wallpaperDrawable as BitmapDrawable
        val bm = bd.bitmap
        val drawable: Drawable =   BitmapDrawable(resources, Tools.blurBitmap(context, bm, 12F))
        layout.background = drawable
    }
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_yinsixieyi)
        layoutBackgroundBlur(this,R.id.yinsi)
        if (Build.VERSION.SDK_INT>=21){
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }

        en.setOnClickListener {
            val resources : Resources = this.resources;
            val dm : DisplayMetrics= resources.displayMetrics;
            val config :Configuration = resources.configuration;
            // 应用用户选择语言
            config.locale = Locale.ENGLISH;
            resources.updateConfiguration(config, dm);
            val ioo  =  Intent(this, YinsixieyiActivity::class.java)
            ioo.flags = Intent.FLAG_ACTIVITY_NEW_TASK + Intent.FLAG_ACTIVITY_CLEAR_TASK
            this.startActivity(intent);
        }

        cn.setOnClickListener {
            val resources : Resources = this.resources;
            val dm : DisplayMetrics= resources.displayMetrics;
            val config :Configuration = resources.configuration;
            // 应用用户选择语言
            config.locale = Locale.CHINESE;
            resources.updateConfiguration(config, dm);
            val ioo  =  Intent(this, YinsixieyiActivity::class.java)
            ioo.flags = Intent.FLAG_ACTIVITY_NEW_TASK + Intent.FLAG_ACTIVITY_CLEAR_TASK
            this.startActivity(intent);
        }


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

}
