package com.asadbek.movieapp.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.asadbek.movieapp.R
import com.asadbek.movieapp.models.Movie

class RvAdapter(val context: Context, val list:ArrayList<Movie>, val rvClick: RvClick) : RecyclerView.Adapter<RvAdapter.VH>() {
            inner class VH(var itemRv: View): RecyclerView.ViewHolder(itemRv){
                fun onBind(movie: Movie){
                    itemRv.setOnClickListener {
                        rvClick.onClick(movie)
                    }
                    itemRv.findViewById<TextView>(R.id.movieDate).setText(movie.date)
                    itemRv.findViewById<TextView>(R.id.movieName).setText(movie.name)
                    itemRv.findViewById<TextView>(R.id.movieAuthors).setText(movie.author)
/*

                    itemRv.findViewById<MaterialButton>(R.id.btnEdit).setOnClickListener {
                       // val intent = Intent(context,EditActivity::class.java)
                       // Save.movie = Movie(movie.name,movie.author,movie.about,movie.date)
                      //  context.startActivity(intent)
                    }
                    itemRv.findViewById<MaterialButton>(R.id.btnDelete).setOnClickListener {
                      //  list.remove(movie)
                       // notifyDataSetChanged()
                    }
 */

                }
            }

            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
                return  VH(LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false))
            }

            override fun onBindViewHolder(holder: VH, position: Int) {
                holder.onBind(list[position])
            }

            override fun getItemCount(): Int {
                return  list.size
            }
            interface RvClick{
                fun onClick(movie: Movie)

            }
}