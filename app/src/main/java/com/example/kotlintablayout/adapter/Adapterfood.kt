package com.example.kotlintablayout.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kotlintablayout.R
import com.example.kotlintablayout.model.Foodmodul
import com.example.kotlintablayout.views.Fooddetails





class Adapterfood( val context: Context,val listf: ArrayList<Foodmodul>): RecyclerView.Adapter<Adapterfood.Viewhf>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapterfood.Viewhf {


        val v=LayoutInflater.from(parent.context).inflate(R.layout.itemfood,parent,false)
        return Viewhf(v)
    }

    override fun onBindViewHolder(holder: Adapterfood.Viewhf, position: Int) {

//                val m=listf.get(position)
//                holder.name2.setText(m.foodname)


        val mm=listf[position]
        holder.name2.text=mm.foodname





        Glide.with(context).load(mm.imagefoodm).into(holder.image2)




    }

    override fun getItemCount(): Int {


       return listf.size
    }


    inner class Viewhf(itemView:View) :RecyclerView.ViewHolder(itemView) {

        var image2: ImageView
        var name2: TextView

        init {
          image2=itemView.findViewById(R.id.imagefooditem)
            name2=itemView.findViewById(R.id.namefooditem)




            itemView.setOnClickListener() {

                val intent= Intent(itemView.context, Fooddetails::class.java)

                val mm=listf.get(position)
                intent.putExtra("catid",mm.catidm)
                intent.putExtra("catname",mm.catname)
                intent.putExtra("foodid",mm.foodid)
                intent.putExtra("foodname",mm.foodname)
                intent.putExtra("imagefoodm",mm.imagefoodm)
                intent.putExtra("large",mm.large)
                intent.putExtra("medium",mm.medium)
                intent.putExtra("smalle",mm.smalle)
                ContextCompat.startActivity(itemView.context, intent, null)




//                Toast.makeText(
//                    itemView.context,list[adapterPosition].name,
//                    Toast.LENGTH_LONG
//                ).show()


            }





        }
    }


}