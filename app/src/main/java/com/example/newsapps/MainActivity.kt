package com.example.newsapps

import android.graphics.drawable.Drawable
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.browser.customtabs.CustomTabsIntent
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonObjectRequest
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONObject


class MainActivity : AppCompatActivity(), ItemTouch {
    lateinit var mAdapter: NewsAdapter
    var anstype:String="business"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        anstype = intent.getStringExtra("ContentType").toString()
        recyclerView.layoutManager = LinearLayoutManager(this)
        getItem()
        mAdapter = NewsAdapter(this)
        recyclerView.adapter = mAdapter
    }

    private fun getItem() {
        val url ="https://saurav.tech/NewsAPI/top-headlines/category/"+anstype+"/in.json\n"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener {
                val newsJsonArray = it.getJSONArray("articles")
                val newsArray = ArrayList<News>()
                for (i in 0 until newsJsonArray.length()) {
                    val newsJsonObject = newsJsonArray.getJSONObject(i)
                    val news = News(
                        newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage")
                    )
                  //  Log.d("SAAGR",newsJsonArray.getJSONObject(i).getString("title"))

                    newsArray.add(news)
                }

                mAdapter.updateNews(newsArray)

            },
            {

            })

        MySinglton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun onItemClicked(st: News) {
        Toast.makeText(this,st.url,Toast.LENGTH_SHORT).show()
        val  builder  =CustomTabsIntent.Builder();
        val customTabsIntent  = builder.build();
        customTabsIntent.launchUrl(this, Uri.parse(st.url));
    }
}