package hal.ac.jp.getqiitasnewsbykotlin


import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import android.widget.ProgressBar
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import hal.ac.jp.getqiitasnewsbykotlin.DAO.MyDatabase
import hal.ac.jp.getqiitasnewsbykotlin.client.ArticleClient
import hal.ac.jp.getqiitasnewsbykotlin.model.Article
import hal.ac.jp.getqiitasnewsbykotlin.model.User
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class FavoriteFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v: View = inflater!!.inflate(R.layout.favorite_fragment, container, false)

        val listView: ListView = v.findViewById(R.id.list_view_fav) as ListView
        val listAdapter = ArticleListAdapter(activity.applicationContext)

        val h = MyDatabase(context)
        val db = h.readableDatabase
        val sql = "select * from article"

        val c = db.rawQuery(sql, null)
        var b = c.moveToFirst()
        while (b) {
           listAdapter.articles += listOf(insertArticle(
                    c.getString(1),
                    c.getString(2),
                    c.getString(3),
                    c.getString(4),
                    c.getString(5),
                    c.getString(6)))
//            Log.d("table:::", c.getString(1).toString())
            b = c.moveToNext()
        }
        c.close()
        listView.adapter = listAdapter
        listView.setOnItemClickListener { adapterView, view, position, id ->
            val intent = ArticleActivity.intent(context, listAdapter.articles[position])
//            Log.d("Article", listAdapter.articles[position].toString())
            startActivity(intent)
        }
        return v
    }
    private fun insertArticle(article_id: String,
                              article_title: String,
                              article_url: String,
                              user_id: String,
                              user_name: String,
                              user_profileImageUrl: String): Article =

            Article(id = article_id,
                    title = article_title,
                    url = article_url,
                    user = User(id = user_id, name = user_name, profileImageUrl = user_profileImageUrl))


}
