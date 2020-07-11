package com.turskyi.retrofittutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.ArrayList

/** funny stories from bash.org */
class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var posts: MutableList<PostModel>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        posts = ArrayList()

        recyclerView = findViewById(R.id.posts_recycle_view)
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager

        val adapter = PostsAdapter(posts)
        recyclerView.adapter = adapter

        App.api?.getData("bash", 50)?.enqueue(object : Callback<List<PostModel>> {
            override fun onResponse(
                call: Call<List<PostModel>>,
                response: Response<List<PostModel>>
            ) {
                /* The data successfully arrived, but we need to check response.body () for null */
                response.body()?.let { posts.addAll(it) }
                recyclerView.adapter?.notifyDataSetChanged()
            }

            override fun onFailure(call: Call<List<PostModel>>, t: Throwable) {
                /* Error */
                Toast.makeText(
                    this@MainActivity,
                    "An error occurred during networking",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })
    }
}
