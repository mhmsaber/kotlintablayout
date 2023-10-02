package com.example.kotlintablayout

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintablayout.adapter.Adapterr
import com.example.kotlintablayout.model.User
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener



class Fragment1 : Fragment() {




    private  lateinit var userarraylist:ArrayList<User>
    private  lateinit var database: DatabaseReference
    private  lateinit var recyy : RecyclerView






    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false )

    }




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


      //  write code from here

        recyy=view.findViewById(R.id.recy)

      //  Toast.makeText(context,"WLCOME IN FRAGMENT 1",Toast.LENGTH_SHORT).show()

        database = FirebaseDatabase.getInstance().getReference("EGYPT").child("menu")



        Recyblock()

        GatdatafromFBsae()




    }


    private fun Recyblock() {
        recyy.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
        recyy.setHasFixedSize(true)
        userarraylist = arrayListOf<User>()
    }




    private  fun GatdatafromFBsae(){




        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    for (usersnapshot in snapshot.children) {
                        val userr = usersnapshot.getValue(User :: class.java)
                        userarraylist.add(userr!!)

                    }


                    val adapterrr = context?.let { Adapterr(it, userarraylist) }
                    recyy.adapter = adapterrr
                    if (adapterrr != null) {
                        adapterrr.notifyDataSetChanged()
                    }



                }


            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })



    }





}