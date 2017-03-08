package hal.ac.jp.getqiitasnewsbykotlin

import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v4.view.PagerTabStrip
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        title = "GetQiita'sNews"
        val tab : PagerTabStrip = findViewById(R.id.tab) as PagerTabStrip
        val vp: ViewPager = findViewById(R.id.pager) as ViewPager
        val pa: PagerAdapter = MyPageAdapter(supportFragmentManager)
        vp.adapter = pa

    }
}
