package cn.syutung.jisuanqi

import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Context
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
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_about.*
import kotlinx.android.synthetic.main.activity_main.*

class About : AppCompatActivity() {
    private fun layoutBackgroundBlur(context: Context?, i : Int){
        val layout : RelativeLayout =findViewById(i)
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
        setContentView(R.layout.activity_about)
        layoutBackgroundBlur(this,R.id.aboutlay)
        if (Build.VERSION.SDK_INT>=21){
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }

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
