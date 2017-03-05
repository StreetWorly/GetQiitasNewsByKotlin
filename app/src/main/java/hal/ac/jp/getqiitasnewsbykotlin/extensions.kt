package hal.ac.jp.getqiitasnewsbykotlin

import android.content.Context
import android.support.annotation.IdRes
import android.view.View
import android.widget.Toast
import javax.xml.datatype.Duration

fun<T: View> View.bindView(@IdRes id: Int): Lazy<T> = lazy {
    findViewById(id) as T
}

fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT){
    Toast.makeText(this, message, duration)
}