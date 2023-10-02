package com.example.kotlintablayout.adapter

import android.annotation.SuppressLint
import com.example.kotlintablayout.model.Modelfood


import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class Sqliteadapterr(context:Context) : SQLiteOpenHelper(context,DADABASENAME,null,DATABASE_VERSION)  {
    companion object{
        private val DADABASENAME= "DADABASENAME"
        private   val DATABASE_VERSION = 1
        private   val TABLE_NAME="TABLE_NAME";
        private val ID= "id"
        private val QUANTITY= "quantity"
        private val NAME= "name"
        private val PRICE= "price"
        private val LARGE= "large"
        private val MEDEAM= "medeam"
        private val SMALLE= "smalle"
        private val LARGEC= "largec"
        private val MEDEAMC= "medeamc"
        private val SMALLEC= "smallec"
        private val TOTSQL= "totsql"


}

        @SuppressLint("SuspiciousIndentation")
        override fun onCreate(db: SQLiteDatabase?) {

         val query3 = ("CREATE TABLE " + TABLE_NAME+ " ( "
                    + ID + " INTEGER PRIMARY KEY, "
                    + NAME + " TEXT,"
                    + QUANTITY + " TEXT,"
                    + LARGE + " TEXT,"
                    + MEDEAM + " TEXT,"
                    + SMALLE + " TEXT,"
                    + LARGEC + " TEXT,"
                    + MEDEAMC + " TEXT,"
                    + SMALLEC + " TEXT ,"
                    + PRICE + " TEXT) ")

            db?.execSQL(query3)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL(" DROP TABLE IF EXISTS " + TABLE_NAME)
        onCreate(db)

    }



    fun  insertdata3(
        name: String,
        price: String,
        quantity: String,
        larege: String,
        medeam: String,
        smalle: String,
        largec: String,
        medeamc: String,
        smallec: String

    ): Long {
        val db=this.writableDatabase
        val cv= ContentValues()
 //       cv.put(ID,id)
        cv.put(NAME, name)
        cv.put(MEDEAM,medeam)
        cv.put(SMALLE,smalle)
        cv.put(QUANTITY, quantity)
        cv.put(PRICE,price)
        cv.put(LARGE,larege)
        cv.put(LARGEC,largec)
        cv.put(MEDEAMC,medeamc)
        cv.put(SMALLEC,smallec)
   //     cv.put(TOTSQL,totsql)

        val success=db.insert(TABLE_NAME,null,cv)
        db.close()
        return success    }

    @SuppressLint("Range")
    fun getAllData():ArrayList<Modelfood>{
        val allData : ArrayList<Modelfood> = ArrayList()
        val selectQuery="SELECT * FROM $TABLE_NAME"
        val db=this.readableDatabase
        val cursor : Cursor?
        try {
            cursor=db.rawQuery(selectQuery,null)
        }catch (e:Exception){
            e.printStackTrace()
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var id:Int
        var name:String
        var quantity:String
        var price:String
        var large:String
        var medeam:String
        var smalle:String
        var largec:String
        var medeamc:String
        var smallec:String
        var totsql:String

        if(cursor.moveToFirst()){
            do{
                id=cursor.getInt(cursor.getColumnIndex("id"))
                name=cursor.getString(cursor.getColumnIndex("name"))
                quantity=cursor.getString(cursor.getColumnIndex("quantity"))
                price=cursor.getString(cursor.getColumnIndex("price"))
                large=cursor.getString(cursor.getColumnIndex("large"))
                medeam=cursor.getString(cursor.getColumnIndex("medeam"))
                smalle=cursor.getString(cursor.getColumnIndex("smalle"))
                 largec=cursor.getString(cursor.getColumnIndex("largec"))
                medeamc=cursor.getString(cursor.getColumnIndex("medeamc"))
                smallec=cursor.getString(cursor.getColumnIndex("smallec"))








//                totsql=cursor.getString(cursor.getColumnIndex("totsql"))
                val data=Modelfood(id=id,name=name,quantity=quantity
                ,price=price,large=large,medeam=medeam,smalle=smalle,largec=largec,medeamc=medeamc,smallec=smallec)
                allData.add(data)
            }while (cursor.moveToNext())
        }
        return  allData

    }



    fun deletedata(id:Int):Int{

        val db=this.writableDatabase
        val cv=ContentValues()
        cv.put(ID,id)
        val success : Int =db.delete(TABLE_NAME,"id = " + id ,null)
        db.close()
        return success

    }

    fun deletealldata():Int{
        val db=this.writableDatabase
        val success : Int= db.delete(TABLE_NAME, null, null)
        db.close()
        return success

    }






}