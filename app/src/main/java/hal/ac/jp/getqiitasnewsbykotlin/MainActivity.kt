package hal.ac.jp.getqiitasnewsbykotlin

import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.widget.Button



class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "GetQiita'sNews"
        val vp: ViewPager = findViewById(R.id.pager) as ViewPager
        val pa: PagerAdapter = MyPageAdapter(supportFragmentManager)
//        val btn: Button = findViewById(R.id.button2) as Button
        vp.adapter = pa
        vp.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {
            }

            override fun onPageSelected(position: Int) {
                pa.notifyDataSetChanged()
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        })

//        btn.setOnClickListener {
//            pa.notifyDataSetChanged()
//
//        }
    }
}



