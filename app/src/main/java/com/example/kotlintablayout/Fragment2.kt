package com.example.kotlintablayout

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


import com.example.kotlintablayout.adapter.Adapterrcart
import com.example.kotlintablayout.adapter.Request
import com.example.kotlintablayout.adapter.Sqliteadapterr

import com.example.kotlintablayout.views.MainActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase


import java.text.NumberFormat
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale


class Fragment2 : Fragment() {



    private   val adapterrcart= Adapterrcart()


    var totall:Int=0











    val database: DatabaseReference = FirebaseDatabase.getInstance()
        .getReference("EGYPT").child("orders")


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?



    ): View? {
        // Inflate the layout for this fragment

        Toast.makeText(context,"1 override fun onCreateView ",Toast.LENGTH_SHORT).show()

//
        return inflater.inflate(R.layout.fragment_2, container, false)
    }




    @SuppressLint("SuspiciousIndentation", "NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)






        Toast.makeText(context,"GOOD",Toast.LENGTH_SHORT).show()
        val recycart:RecyclerView=view.findViewById(R.id.recycart)
        val send:Button=view.findViewById(R.id.send)
        val totprice:TextView=view.findViewById(R.id.totpricce)



        val sqliteadapterr= context?.let { Sqliteadapterr(it) }


        val listcart= sqliteadapterr!!.getAllData()


        recycart.adapter=adapterrcart
        recycart.setHasFixedSize(true)
        recycart.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

         adapterrcart.addItem(listcart)
        adapterrcart.notifyDataSetChanged()













        for (modelfood in listcart) {


            totall   += Integer.valueOf(modelfood.price)
            val locale = Locale("en", "eg")
            val ftm = NumberFormat.getCurrencyInstance(locale)
            totprice.setText(ftm.format(totall.toLong()))
        }





        send.setOnClickListener {

            if(totall==0){
                Toast.makeText(context," NO ITEM IN YOUR CART",Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }



            var dialog: AlertDialog
            val alertdialog = AlertDialog.Builder(context)
            alertdialog.setTitle("            ادخل بياناتك")
            val view = layoutInflater.inflate(R.layout.itemdialog, null)
            alertdialog.setIcon(R.drawable.cart2)

            val namedialog2: EditText
            val telephone2: EditText
            val editaddress: EditText
            val senddailog: Button
            namedialog2 = view.findViewById(R.id.namedialog)
            telephone2 = view.findViewById(R.id.telphonedialog)
            editaddress = view.findViewById(R.id.addressdialog)
            senddailog = view.findViewById(R.id.senddialog)
            alertdialog.setView(view)



            senddailog.setOnClickListener {
                val m = telephone2.text.toString()
                val adressx = editaddress.text.toString()
                val namex = namedialog2.text.toString()
                val calendar = Calendar.getInstance()
                //     SimpleDateFormat sdf=new SimpleDateFormat("dd-MM-yy  hh:mm:ss");
                val sdf = SimpleDateFormat(" hh:mm   dd MM ")
                val time = sdf.format(calendar.time)
                val status = " order"


                if(namex.isEmpty()){
                    Toast.makeText(context,"please inter name",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }
                if(m.isEmpty()){
                    Toast.makeText(context,"please inter phone",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }

                if(adressx.isEmpty()){
                    Toast.makeText(context,"please inter adress",Toast.LENGTH_SHORT).show()
                    return@setOnClickListener
                }



                val request = Request(
                    namex,  adressx,m,totall.toString(), time, status,
                    listcart
                )


                //send data to Firebase by milisecand system
                //ref.child("Orders").child(String.valueOf(System.currentTimeMillis())).setValue(request);
                //.child("Orders").child(m).setValue(request)
                //send data to Firebase by milisecand system
                //ref.child("Orders").child(String.valueOf(System.currentTimeMillis())).setValue(request);
    //            database.child(m).setValue(request)

              sqliteadapterr.deletealldata()

                val intent=Intent(context,MainActivity::class.java)
                startActivity(intent)


            }


            // this code for show dialog



            dialog = alertdialog.create()
            dialog.setIcon(R.drawable.cart_24)
            dialog.show()






        }








    }

    override fun onDestroy() {
        super.onDestroy()
    }


        }

