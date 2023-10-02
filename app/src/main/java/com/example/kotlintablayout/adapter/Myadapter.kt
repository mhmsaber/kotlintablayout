package com.example.kotlintablayout.adapter

import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.kotlintablayout.Fragment1
import com.example.kotlintablayout.Fragment2
import com.example.kotlintablayout.Fragment3
import com.example.kotlintablayout.Fragment4


class Myadapter(fragmentmanger :FragmentManager,lifecycle: Lifecycle) :FragmentStateAdapter(
    fragmentmanger,lifecycle) {

    val fragmentsize=3

    override fun getItemCount(): Int {

       return  this.fragmentsize


    }

    override fun createFragment(position: Int): Fragment {
       when(position){
           0 ->{
               return  Fragment1()
           }
           1 ->{

               return  Fragment2()
           }
           2 ->{
               return  Fragment3()
           }
           3 ->{
               return  Fragment4()
           }
       }

        return  Fragment1()
    }

}

