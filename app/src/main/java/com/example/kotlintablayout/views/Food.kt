package com.example.kotlintablayout.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.kotlintablayout.R
import com.example.kotlintablayout.adapter.Adapterfood
import com.example.kotlintablayout.model.Foodmodul
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class Food : AppCompatActivity() {

    private  lateinit var foodarray:ArrayList<Foodmodul>
    private  lateinit var database: DatabaseReference
    private lateinit var recyfood: RecyclerView




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.food)





        val catid: TextView =findViewById(R.id.catid)
        recyfood=findViewById(R.id.recyfood)




        val intent1=getIntent().getStringExtra("id")
        catid.setText(intent1.toString())

        database= FirebaseDatabase.getInstance()
            .getReference("EGYPT").child("menu").child(catid.text.toString()).child("xx")




        Recyfoodblock()


        GatdatafoodfromFB()
       



    }

    private fun Recyfoodblock(){
        recyfood.layoutManager= LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        recyfood.setHasFixedSize(true)
        foodarray = arrayListOf<Foodmodul>()



    }


    private  fun GatdatafoodfromFB(){



        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                if(snapshot.exists()) {
                    for (usersnapshot in snapshot.children) {
                        val foodmodul = usersnapshot.getValue(Foodmodul :: class.java)
                        foodarray.add(foodmodul!!)
                    }
                    val adapterrrr = Adapterfood(applicationContext ,foodarray)
                    recyfood.adapter=adapterrrr
                    adapterrrr.notifyDataSetChanged()
                }

            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }


        })




    }
}