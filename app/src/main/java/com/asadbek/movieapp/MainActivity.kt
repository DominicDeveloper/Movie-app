package com.asadbek.movieapp

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asadbek.movieapp.adapter.RvAdapter
import com.asadbek.movieapp.databinding.ActivityMainBinding
import com.asadbek.movieapp.models.Movie
import com.asadbek.movieapp.models.Save
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var list: ArrayList<Movie>
    lateinit var rvAdapter: RvAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = ArrayList()
        list.add(Movie("Test","test","test","test"))
        val gson = Gson()
        val sharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)
        val data = sharedPreferences.getString("movie","example")
        if (data != "example"){
            val type = object: TypeToken<ArrayList<Movie>>(){}.type
            val gsonToContact = gson.fromJson<ArrayList<Movie>>(data,type)
            if (gsonToContact.isNotEmpty()){
                list.addAll(gsonToContact)
            }
        }



        rvAdapter = RvAdapter(this,list,object :RvAdapter.RvClick{
            override fun onClick(movie: Movie) {
                val intent = Intent(this@MainActivity,AboutActivtiy::class.java)
                Save.movie = Movie(movie.name,movie.author,movie.about,movie.date)
                startActivity(intent)
            }
        })
        binding.rv.adapter = rvAdapter
        binding.btnAdd.setOnClickListener {
            val intent = Intent(this,AddActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onResume() {
        super.onResume()


    }
}