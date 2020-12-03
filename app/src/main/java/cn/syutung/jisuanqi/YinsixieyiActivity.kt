package cn.syutung.jisuanqi

import android.app.WallpaperManager
import android.content.Intent
import android.content.res.Configuration
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_yinsixieyi.more3

class YinsixieyiActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_yinsixieyi)
        val layout : RelativeLayout = findViewById(R.id.yinsi)
        val wallpaperManager: WallpaperManager = WallpaperManager.getInstance(this)

        val wallpaperDrawable: Drawable = wallpaperManager.drawable
        val bd = wallpaperDrawable as BitmapDrawable
        val bm = bd.bitmap
        val drawable:Drawable =  BitmapDrawable(resources,Tools.blurBitmap(this,bm,12F))
        layout.background = drawable


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
