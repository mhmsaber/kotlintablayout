package com.example.kotlintablayout.views

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.example.kotlintablayout.Fragment1
import com.example.kotlintablayout.R
import com.example.kotlintablayout.adapter.Myadapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {



   val mytabs= arrayOf("القائمة","مشترياتك","عروض")

    @SuppressLint("MissingInflatedId", "NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val tablayout: TabLayout=findViewById(R.id.tablayout)
        val viewpager :ViewPager2=findViewById(R.id.viewPager)






        val myadapter=Myadapter(supportFragmentManager,lifecycle)

        viewpager.adapter=myadapter





        TabLayoutMediator(tablayout,viewpager){
            tab,position ->tab.text=mytabs[position]}.attach()



















    }

}