package com.example.favmovies.activity

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.favmovies.R
import com.example.favmovies.adapter.MovieAdapter
import com.example.favmovies.model.Movie

class MainActivity : AppCompatActivity() {

    private val movieList = mutableListOf<Movie>()
    private lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val etTitle = findViewById<EditText>(R.id.etTitle)
        val etAuthor = findViewById<EditText>(R.id.etAuthor)
        val btnAdd = findViewById<Button>(R.id.btnAdd)
        val rvMovies = findViewById<RecyclerView>(R.id.rvMovies)

        adapter = MovieAdapter(movieList)
        rvMovies.adapter = adapter

        rvMovies.layoutManager = GridLayoutManager(this, 2)

        btnAdd.setOnClickListener {
            val title = etTitle.text.toString().trim()
            val author = etAuthor.text.toString().trim()

            if (title.isNotEmpty() && author.isNotEmpty()) {

                val newMovie = Movie(title, author)

                movieList.add(newMovie)

                adapter.notifyItemInserted(movieList.size - 1)

                etTitle.text.clear()
                etAuthor.text.clear()

            } else {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show()
            }
        }
    }
}