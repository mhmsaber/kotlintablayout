package com.example.kotlintablayout.views

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.bumptech.glide.Glide
import com.example.kotlintablayout.R
import com.example.kotlintablayout.adapter.Sqliteadapterr
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Fooddetails : AppCompatActivity() {


    private val database: DatabaseReference = FirebaseDatabase.getInstance()
        .getReference("EGYPT")




    private var uri: Uri? = null




    private lateinit var foodnameup: TextView
    private lateinit var send: Button
    private lateinit var largeup: TextView
    private lateinit var mediumup: TextView
    private lateinit var smalleup: TextView
    private lateinit var foodimageup: ImageView
    private lateinit var remov1: ImageView
    private lateinit var remov2: ImageView
    private lateinit var remov3: ImageView
    private lateinit var add1: ImageView
    private lateinit var add2: ImageView
    private lateinit var add3: ImageView
    private lateinit var cart2: CardView
    private lateinit var cart3: CardView
    private lateinit var cont1: TextView
    private lateinit var cont2: TextView
    private lateinit var cont3: TextView
    private lateinit var totalprice: TextView

    private var sqliteadapterr= Sqliteadapterr(this)


    private lateinit var mid:String
    private lateinit var mname:String
    private lateinit var mcatid:String





    var tot:Int = 0
    var tot11:Int = 0
    var tot22:Int = 0
    var tot33:Int = 0
    var c1:Int=0
    var c2:Int=0
    var c3:Int=0





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fooddetails)










        foodnameup= findViewById(R.id.foodnameup)
        send=findViewById(R.id.send)
        largeup= findViewById(R.id.largeup)
        mediumup= findViewById(R.id.mediumup)
        smalleup= findViewById(R.id.smalleup)
        foodimageup= findViewById(R.id.foodimageup)
        remov1=findViewById(R.id.remov1)
        remov2=findViewById(R.id.remov3)
        remov3=findViewById(R.id.remov3)
        add1=findViewById(R.id.add1)
        add2=findViewById(R.id.add2)
        add3=findViewById(R.id.add3)
        cart2 =findViewById(R.id.cart2)
        cart3=findViewById(R.id.cart3)
        cont1=findViewById(R.id.cont1)
        cont2=findViewById(R.id.cont2)
        cont3=findViewById(R.id.cont3)

        totalprice=findViewById(R.id.totalprice)
















        Reciveddatafromfoodactivity()



        Getnummberofitem()

        //     this function  if the fooditem have one price to prevent the two empity    appears for client


        Preventempetyprice()


























        send.setOnClickListener {

            SumpriceandsenddatatoCart()


        }




        //Functions

    }

    private fun SumpriceandsenddatatoCart() {

        tot11 = c1 * intent.getStringExtra("large")!!.toInt()
        tot22 = c2 *intent.getStringExtra("medium")!!.toInt()
        tot33 = c3 *intent.getStringExtra("smalle")!!.toInt()
        if (c1 + c2 + c3 == 0) {
            Toast.makeText(this, "لاتوجد مشتريات", Toast.LENGTH_SHORT).show()
        }else {
            tot = tot11 + tot22 + tot33;
            totalprice.setText(" المجموع " + tot + " جنية")
            val intent2= Intent(this,Food::class.java)
            intent2.putExtra("foodid",mid)
            intent2.putExtra("catname",mname)
            intent2.putExtra("id",mcatid)
            Toast.makeText(this,mname.toString(), Toast.LENGTH_SHORT).show()
            sqliteadapterr.insertdata3(foodnameup.text.toString(),tot.toString(),totalprice.text.toString(),
                largeup.text.toString(),mediumup.text.toString(),smalleup.text.toString(),
                c1.toString(),c2.toString(),c3.toString())
            Toast.makeText(this,"data id insert", Toast.LENGTH_SHORT).show()
            startActivity(intent2)

        }

    }


    private fun Getnummberofitem(){

        add1.setOnClickListener {
            if (c1 < 10) {
                c1++
                cont1.setText(c1.toString())
            }
        }
        remov1.setOnClickListener {
            if (c1 > 0.5) {
                c1--
                cont1.setText(c1.toString())
            }
        }

        add2.setOnClickListener {
            if (c2 < 10) {
                c2++
                cont2.setText(c2.toString())
            }
        }
        remov2.setOnClickListener {
            if (c2 > 0.5) {
                c2--
                cont2.setText(c2.toString())
            }
        }

        add3.setOnClickListener {
            if (c3 < 10) {
                c3++
                cont3.setText(c3.toString())
            }
        }
        remov3.setOnClickListener {
            if (c3 > 0.5) {
                c3--
                cont3.setText(c3.toString())
            }

        }



    }

    private fun Reciveddatafromfoodactivity(){

        mid= getIntent().getStringExtra("foodid").toString()
        mname= getIntent().getStringExtra("catname").toString()
        mcatid= getIntent().getStringExtra("catid").toString()
        foodnameup.setText(getIntent().getStringExtra("foodname"))
        largeup.setText("  كبير   " + getIntent().getStringExtra("large"))
        mediumup.setText("  وسط    " + getIntent().getStringExtra("medium"))
        smalleup.setText("  صغير   " + getIntent().getStringExtra("smalle"))
        Glide.with(this).load(getIntent().getStringExtra("imagefoodm")).into(foodimageup)
        Toast.makeText(this,mname, Toast.LENGTH_SHORT).show()


    }



    private fun Preventempetyprice(){

        if (intent.getStringExtra("smalle")!!.toInt()==0 ) {
            cart3.setVisibility(View.INVISIBLE)
        }
        if ( intent.getStringExtra("medium")!!.toInt()==0  ) {
            cart2.setVisibility(View.INVISIBLE)
        }







    }
}