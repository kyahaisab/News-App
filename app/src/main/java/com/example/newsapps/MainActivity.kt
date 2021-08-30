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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
recyclerView.layoutManager=LinearLayoutManager(this)
        val x=NewsAdapter(getItem(),this)
        recyclerView.adapter=x
    }

    private fun getItem(): ArrayList<String> {
     val list= ArrayList<String>()
        for(i in 0 until 20){
            list.add("Item $i")
        }
        return list
    }

    override fun onItemClicked(st: String) {
        Toast.makeText(this, " $st is clicked", Toast.LENGTH_SHORT).show()
    }
}