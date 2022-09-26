package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.annotation.SuppressLint

class SayiPratikDao {

    @SuppressLint("Range", "Recycle")
    fun tumSayilar(vt: VeritabaniYardimcisi) : ArrayList<SayiPratik> {
        val sayiListe = ArrayList<SayiPratik>()
        val db = vt.writableDatabase

       val c = db.rawQuery("SELECT * FROM sayipratik ORDER BY RANDOM()",null)

        while (c.moveToNext()){
            val sayi = SayiPratik(c.getInt(c.getColumnIndex("sayi_id"))
                ,c.getString(c.getColumnIndex("sayi"))
            ,c.getString(c.getColumnIndex("sayi_cevap")))

                sayiListe.add(sayi)
        }
        return sayiListe
    }

}