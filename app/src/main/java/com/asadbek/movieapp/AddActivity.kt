package com.asadbek.movieapp

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.asadbek.movieapp.databinding.ActivityAddBinding
import com.asadbek.movieapp.models.Movie
import com.google.gson.Gson

class AddActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddBinding
    lateinit var list:ArrayList<Movie>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddBinding.inflate(layoutInflater)
        setContentView(binding.root)
        list = ArrayList()
        val gson = Gson()

        val sharedPreferences = getSharedPreferences("PREFERENCE_NAME", Context.MODE_PRIVATE)


        binding.btnSave.setOnClickListener {
            var name = binding.edtName.text?.toString()?.trim()
            var author = binding.edtAuthors.text?.toString()?.trim()
            var about = binding.edtAbout.text?.toString()?.trim()
            var date = binding.edtDate.text?.toString()?.trim()

            if (name!!.isNotEmpty() && author!!.isNotEmpty() && about!!.isNotEmpty() && date!!.isNotEmpty()){
                var movie = Movie(name,author,about,date)
                list.add(movie)
                var jsonList = gson.toJson(list)
                val editor =sharedPreferences.edit()
                editor.putString("movie",jsonList.toString())
                editor.apply()
                Toast.makeText(this, "Saqlandi!", Toast.LENGTH_SHORT).show()
                binding.edtName.text!!.clear()
                binding.edtAbout.text!!.clear()
                binding.edtDate.text!!.clear()
                binding.edtAuthors.text!!.clear()

            }else if (name.isEmpty()){
                binding.edtName.error = "To`ldiring"
                binding.edtName.isFocusable = true
            }else if (author!!.isEmpty()){
                binding.edtAuthors.error = "To`ldiring"
                binding.edtAuthors.isFocusable = true
            }else if (about!!.isEmpty()){
                binding.edtAbout.error = "To`ldiring"
                binding.edtAbout.isFocusable = true
            }else if (date!!.isEmpty()){
                binding.edtDate.error = "To`ldiring"
                binding.edtDate.isFocusable = true
            }else{
                Toast.makeText(this, "Ma`lumotlarda xatolik!", Toast.LENGTH_SHORT).show()
            }

        }

    }

}