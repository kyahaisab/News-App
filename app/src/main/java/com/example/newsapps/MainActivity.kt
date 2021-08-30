package com.example.newsapps

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
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
    lateinit var mAdapter:NewsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
recyclerView.layoutManager=LinearLayoutManager(this)
        getItem()
        val mAdapter=NewsAdapter(this)
        recyclerView.adapter=mAdapter
    }

    private fun getItem() {
        val url = "https://newsapi.org/v2/everything?q=tesla&from=2021-07-30&sortBy=publishedAt&apiKey=78ff1c7d05464705ac9c28cb71eb684e"

        val jsonObjectRequest = JsonObjectRequest(
            Request.Method.GET, url, null,
            Response.Listener {
val newsJsonArray=it.getJSONArray("articles")
                val newsArray=ArrayList<News>()
                for(i in 0 until newsJsonArray.length()){
                    val newsJsonObject=newsJsonArray.getJSONObject(i)
                    val news=News(newsJsonObject.getString("title"),
                        newsJsonObject.getString("author"),
                        newsJsonObject.getString("url"),
                        newsJsonObject.getString("urlToImage"))
                    newsArray.add(news)
                }

mAdapter.updateNews(newsArray)

            },
            {

            })

// Add the request to the RequestQueue.
        MySinglton.getInstance(this).addToRequestQueue(jsonObjectRequest)
    }

    override fun onItemClicked(st: News) {
    }
}