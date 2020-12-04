package cn.syutung.jisuanqi

import android.Manifest
import android.annotation.SuppressLint
import android.app.WallpaperManager
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.content.res.Configuration
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_more.*


class More : AppCompatActivity() {
    fun shouToast(sss:String){
        Toast.makeText(this,sss, Toast.LENGTH_SHORT).show()
    }
    private val mPermissions = arrayOf<String>(
        Manifest.permission.READ_EXTERNAL_STORAGE
    )

    private fun lacksPermission(mContexts: Context, permission: String): Boolean {
        return ContextCompat.checkSelfPermission(mContexts, permission) ==
                PackageManager.PERMISSION_DENIED
    }
    fun lacksPermissions(mContexts: Context?, mPermissions: Array<String>?): Boolean {
        if (mPermissions != null) {
            for (permission in mPermissions) {
                if (lacksPermission(mContexts!!, permission)) {
                   shouToast( "没有开启权限")
                    return true
                }
            }
        }
        return false
    }
    fun layoutBackgroundBlur(context: Context?, i : Int){
        val layout : ConstraintLayout =findViewById<ConstraintLayout>(i)
        val wallpaperManager: WallpaperManager = WallpaperManager.getInstance(context)
        val wallpaperDrawable: Drawable = wallpaperManager.drawable
        val bd = wallpaperDrawable as BitmapDrawable
        val bm = bd.bitmap
        val drawable: Drawable =   BitmapDrawable(resources, Tools.blurBitmap(context, bm, 12F))
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

    @SuppressLint("ResourceAsColor")
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        if (lacksPermissions(this,mPermissions)){
            requestPermissions(mPermissions,1)
        }
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_more)
        layoutBackgroundBlur(this,R.id.shouye)
        if (Build.VERSION.SDK_INT>=21){
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION)
        }
        jinzhi.setOnClickListener {
            val intant = Intent(this, JinZhi::class.java)
            startActivity(intant)
        }
        jisuanqi.setOnClickListener {
            val intant = Intent(this, MainActivity::class.java)
            startActivity(intant)

        }


    }

}
