package com.example.kotlintablayout.adapter

import android.annotation.SuppressLint
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintablayout.R
import com.example.kotlintablayout.model.Modelfood
import com.example.kotlintablayout.views.MainActivity



class Adapterrcart: RecyclerView.Adapter<Adapterrcart.Viewcart>() {

    var list: ArrayList<Modelfood> = ArrayList()

    fun addItem(items: ArrayList<Modelfood>) {
        this.list = items
        notifyDataSetChanged()
    }






    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapterrcart.Viewcart {

        val v: View = LayoutInflater.from(parent.context).inflate(R.layout.itemcart, parent, false)
        return Viewcart(v)

    }





    @SuppressLint("SuspiciousIndentation")
    override fun onBindViewHolder(holder: Adapterrcart.Viewcart, position: Int) {

        val m = list.get(position)

        holder.name22.setText(m.name)
        holder.price22.setText(m.price)
        holder.deleteBtn.setOnClickListener {



//            val alertDialog = AlertDialog.Builder(it.context)
//            alertDialog.setTitle("welcome")
//                .setMessage("are you sure updata : ")
//                .setCancelable(true)
//                .setPositiveButton("yes") { alertDialog, it ->
//


//                    val progressdialog = ProgressDialog(it.)
//                    progressdialog.setMessage("جارى التحميل ياغالى برجاء الانتظار....")
//                    progressdialog.show()




                  Toast.makeText(it.context, "deleted " + m.name, Toast.LENGTH_SHORT).show()

                    val sql = Sqliteadapterr(it.context)
                    sql.deletedata(m.id)

                    var intent = Intent(it.context, MainActivity::class.java)
                    ContextCompat.startActivity(it.context, intent, null)



//                    progressdialog.dismiss();
//                    Toast.makeText(this, "تم التحميل بنجاح  sccsuflly", Toast.LENGTH_SHORT).show();

 //               }

//                .setNegativeButton("NO") { alertDialog, it ->
//                    alertDialog.cancel()
//                }.show()


        }



    }

    override fun getItemCount(): Int {
       return list.size
    }

   inner class Viewcart(itemView: View) : RecyclerView.ViewHolder(itemView) {


        var name22: TextView
        var price22: TextView
        var deleteBtn:ImageView

        init {

            name22 = itemView.findViewById(R.id.itemcartname)
            price22=itemView.findViewById(R.id.itemcartprice)
            deleteBtn=itemView.findViewById(R.id.itemcartdelet)




            deleteBtn.setOnClickListener {

//                val m= list.get(position)
//                val sql=Sqliteadapterr(it.context)
//                sql.deletedata(m.id)
//                Toast.makeText(itemView.context,"delete"+ m.name,Toast.LENGTH_SHORT).show()
//
//                var intent = Intent(it.context, MainActivity::class.java)
//                ContextCompat.startActivity(it.context, intent, null)
//





            }


        }
   }
        }