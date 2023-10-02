package com.example.kotlintablayout.model

import java.util.Random

data class Modelfood (
 var id:Int =getAutoId(),

          val name:String,
          val quantity:String,
          val price:String,
          val large:String,
         val medeam:String,
          val smalle:String,
       var largec: String,
       var medeamc: String,
       var smallec: String
//        var totsql: String

)
{
          companion object{

     fun getAutoId(): Int {
         val random= Random()
         return  random.nextInt(100)
     }

          }

}




//
//data class Modelfood1 (
//    var id:Int =getAutoId(),
//
//    val name:String,
//    val quantity:String,
//    val price:String,
//    val large:String,
//    val medeam:String,
//    val smalle:String,
//    var totsql: String,

//) {
//    companion object {
//
//        fun getAutoId(): Int {
//            val random = Random()
//            return random.nextInt(100)
  //      }



  //  }
//}
