package com.example.newsapps

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main2.*

class MainActivity2 : AppCompatActivity(), ChoiceInterface {

    lateinit var contentList: ArrayList<String>
    var country: String = "in"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        et1.setOnClickListener { country = "in" }
        et2.setOnClickListener { country = "us" }
        et3.setOnClickListener { country = "au" }
        et4.setOnClickListener { country = "ru" }
        et1.setOnClickListener { country = "fr" }
        et2.setOnClickListener { country = "gb" }

        recyclerView2.layoutManager = LinearLayoutManager(this)
        val adapterr = ChoiceAdapter(getType(), this)
        recyclerView2.adapter = adapterr
    }

    private fun getType(): ArrayList<String> {
        val typee = ArrayList<String>()
        contentList = ArrayList<String>()

        typee.add("Business")
        typee.add("Entertainment")
        typee.add("General")
        typee.add("Health")
        typee.add("Science")
        typee.add("Sports")
        typee.add("Technology")

        contentList.add("business")
        contentList.add("entertainment")
        contentList.add("general")
        contentList.add("health")
        contentList.add("science")
        contentList.add("sport")
        contentList.add("technology")

        return typee
    }

    override fun onChoiceClicked(t: Int) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtra("ContentType", contentList[t])
        intent.putExtra("CNTRY", country)
        startActivity(intent)
    }
}