package hal.ac.jp.getqiitasnewsbykotlin

import android.content.Context
import android.content.Intent
import android.database.Cursor
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.webkit.WebView
import android.widget.Button
import android.widget.Toast
import hal.ac.jp.getqiitasnewsbykotlin.DAO.MyDatabase
import hal.ac.jp.getqiitasnewsbykotlin.model.Article
import hal.ac.jp.getqiitasnewsbykotlin.view.ArticleView


/**
 * Created by sutoyusuke on 2017/03/02.
 */
class ArticleActivity : AppCompatActivity() {

    companion object {

        private const val ARTICLE_EXTRA: String = "article"

        fun intent(context: Context, article: Article): Intent =
                Intent(context, ArticleActivity::class.java).putExtra(ARTICLE_EXTRA, article)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_article)

        title = "記事の詳細"
        val insertBtn = findViewById(R.id.button) as Button
        val articleView = findViewById(R.id.article_view) as ArticleView
        val webView = findViewById(R.id.web_view) as WebView
        val article: Article = intent.getParcelableExtra(ARTICLE_EXTRA)

        articleView.setArticle(article)
        webView.loadUrl(article.url)

        val h = MyDatabase(applicationContext)
        val db = h.readableDatabase
        val sql = "select article_id from article where article_id = ?"
        val c = db.rawQuery(sql, arrayOf<String>(article.id))
        var b = c.moveToFirst()
        var flg = ""
        while (b) {
            flg = c.getString(0)

            b = c.moveToNext()
        }
        c.close()

        Log.d("flg::::::", flg)
        Log.d("article_id::::::", article.id)

        if (flg == article.id) {
            insertBtn.text = "お気に入りの削除"
        }

        insertBtn.setOnClickListener {
            if (flg == article.id) {
                val h = MyDatabase(applicationContext)
                val db = h.writableDatabase
                val sql = "delete from article where article_id = ?"
                db.execSQL(sql, arrayOf(article.id))
                Toast.makeText(this, "お気に入りから削除しました。", Toast.LENGTH_SHORT).show()
            } else {
                val h = MyDatabase(applicationContext)
                val db = h.writableDatabase
                val sql = "insert into article(" +
                        "article_id," +
                        "article_title," +
                        "article_url," +
                        "user_id," +
                        "user_name," +
                        "user_profileImageUrl) " +
                        "values(?,?,?,?,?,?)"
                db.execSQL(sql, arrayOf(
                        article.id,
                        article.title,
                        article.url,
                        article.user.id,
                        article.user.name,
                        article.user.profileImageUrl))
                Toast.makeText(this, "お気に入りに登録しました", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

