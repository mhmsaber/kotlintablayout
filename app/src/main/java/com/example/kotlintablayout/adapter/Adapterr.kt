package com.example.kotlintablayout.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.kotlintablayout.Fragment2
import com.example.kotlintablayout.Fragment3
import com.example.kotlintablayout.model.User





import com.example.kotlintablayout.R
import com.example.kotlintablayout.views.Food


class Adapterr(val context: Context, val list: ArrayList<User>): RecyclerView.Adapter<Adapterr.Viewh>() {




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapterr.Viewh {
        val  view=LayoutInflater.from(parent.context).inflate(R.layout.item,parent,false)
        return Viewh(view)
    }

    override fun onBindViewHolder(holder: Adapterr.Viewh, position: Int) {

//        val m=list.get(position)
//       holder.id2.setText(m.id)
//        holder.name2.setText(m.name)
//        holder.adress2.setText(m.adress)

        val m=list[position]
 //       holder.id2.text=m.id
        holder.name2.text=m.name
        Glide.with(context).load(m.imagecat).into(holder.image2)









    }

    override fun getItemCount(): Int {
        return list.size

    }
    inner class Viewh(itemView:View) :RecyclerView.ViewHolder(itemView) {

 //       var id2:TextView
        var name2:TextView
        var image2:ImageView

        init {
//            id2=itemView.findViewById(R.id.itemid)
            name2=itemView.findViewById(R.id.itemname)
            image2=itemView.findViewById(R.id.itemcatimage)



            itemView.setOnClickListener() {



              val intent=Intent(itemView.context, Food::class.java)

                val m=list.get(position)
                Toast.makeText(context,m.name,Toast.LENGTH_SHORT).show()



                intent.putExtra("id",m.id)
                intent.putExtra("name",m.name)
                intent.putExtra("image",m.imagecat)








              startActivity(context,intent,null)








       }

            }
        }









    }
