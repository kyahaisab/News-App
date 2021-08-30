package com.example.newsapps

//package com.example.newsapps
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import android.widget.Toast
//import androidx.recyclerview.widget.LinearLayoutManager
//import kotlinx.android.synthetic.main.activity_main.*
//
//class MainActivity : AppCompatActivity(), ButtonInterface {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        recyclerView.layoutManager = LinearLayoutManager(this)
//        val adapter = NewsAdapter(getItem(), getItem1(), this)
//        recyclerView.adapter = adapter
//    }
//
//    private fun getItem(): ArrayList<String> {
//        var ite = ArrayList<String>()
//        for (i in 1 until 20) {
//            ite.add("Item $i")
//        }
//        return ite
//    }
//
//    private fun getItem1(): ArrayList<String> {
//        var ite = ArrayList<String>()
//        for (i in 10 until 30) {
//            ite.add("Item $i")
//        }
//        return ite
//    }
//
//    override fun onButtonClicked(st: String) {
//        Toast.makeText(this, "$st is clicked", Toast.LENGTH_SHORT).show()
//    }
//
//}


//package com.example.newsapps
//
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class NewsAdapter(
//    private val item: ArrayList<String>,
//    val item1: ArrayList<String>,
//    val liste: ButtonInterface
//) : RecyclerView.Adapter<NewsViewHolder>() {
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_news, parent, false)
//        val viewHolder = NewsViewHolder(view)
//        view.setOnClickListener {
//            liste.onButtonClicked(item[viewHolder.adapterPosition])
//        }
//        return viewHolder
//    }
//
//    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
//        holder.titleView.text = item[position]
//        holder.titleView1.text = item1[position]
//    }
//
//    override fun getItemCount(): Int {
//        return item.size
//    }
//}
//
//class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
//    val titleView: TextView = itemView.findViewById(R.id.title)
//    val titleView1: TextView = itemView.findViewById(R.id.title1)
//}
//
//interface ButtonInterface {
//    fun onButtonClicked(st: String)
//}


//<TextView
//android:id="@+id/title"
//android:layout_width="0dp"
//android:layout_height="wrap_content"
//android:padding="10dp"
//android:text="Title"
//android:textSize="20sp"
//app:layout_constraintStart_toStartOf="parent"
//app:layout_constraintTop_toTopOf="parent" />
//<TextView
//android:id="@+id/title1"
//android:layout_width="0dp"
//android:layout_height="wrap_content"
//app:layout_constraintStart_toEndOf="@id/title"
//app:layout_constraintEnd_toEndOf="parent"
//app:layout_constraintTop_toTopOf="parent"
//android:text="cool"
//android:textSize="10sp"
//android:padding="10dp"/>