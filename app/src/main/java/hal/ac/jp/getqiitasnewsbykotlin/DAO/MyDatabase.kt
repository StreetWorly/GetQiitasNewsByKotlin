package hal.ac.jp.getqiitasnewsbykotlin.DAO

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import hal.ac.jp.getqiitasnewsbykotlin.FavoriteFragment

class MyDatabase(context: Context) : SQLiteOpenHelper(context, "MyDatabase", null, 1) {

    override fun onCreate(db: SQLiteDatabase?) {

        db!!.execSQL("create table article ("
                + "_id integer primary key autoincrement not null, "
                + "article_id text, "
                + "article_title text,"
                + "article_url text,"
                + "user_id text,"
                + "user_name text,"
                + "user_profileImageUrl text"
                + "flg )")

        db!!.execSQL("insert into article(" +
                "article_id," +
                "article_title," +
                "article_url," +
                "user_id," +
                "user_name," +
                "user_profileImageUrl) " +
                "values(" +
                "''," +
                "'kotlin'," +
                "'https://kotlinlang.org/'," +
                "''," +
                "'taro'," +
                "'https://qiita-image-store.s3.amazonaws.com/0/159589/profile-images/1488957877')")
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
    }
}