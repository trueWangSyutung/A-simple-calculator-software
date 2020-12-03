package cn.syutung.jisuanqi

import android.app.WallpaperManager
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_main.*

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val layout : RelativeLayout = findViewById(R.id.aboutlay)
        val wallpaperManager: WallpaperManager = WallpaperManager.getInstance(this)

        val wallpaperDrawable: Drawable = wallpaperManager.drawable
        val bd = wallpaperDrawable as BitmapDrawable
        val bm = bd.bitmap
        val drawable: Drawable =  BitmapDrawable(resources,Tools.blurBitmap(this,bm,12F))
        layout.background = drawable


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
