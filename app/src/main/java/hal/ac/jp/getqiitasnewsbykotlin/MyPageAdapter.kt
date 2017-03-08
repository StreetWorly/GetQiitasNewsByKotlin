package hal.ac.jp.getqiitasnewsbykotlin

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.view.ViewGroup
import android.support.v4.view.ViewPager


class MyPageAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    val fragments: Array<Fragment> = arrayOf(MainFragment(), FavoriteFragment())

    override fun getCount(): Int = 2

    override fun getPageTitle(position: Int): CharSequence {
        var title: String = ""
        when (position) {
            0 -> title = "記事の検索"
            1 -> title = "お気に入り記事"
        }
        return title
    }

    override fun getItemPosition(`object`: Any?): Int {
        return POSITION_NONE
    }

    override fun getItem(position: Int): Fragment = fragments[position]

}
