package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.annotation.SuppressLint


class IslemPratikDao {

   @SuppressLint("Range", "Recycle")
    fun tumIslemler(vt: VeritabaniYardimcisi) : ArrayList<IslemPratik>{
        val islemListe = ArrayList<IslemPratik>()
        val db = vt.writableDatabase

        val c = db.rawQuery("SELECT * FROM islempratik ORDER BY RANDOM()",null)

        while (c.moveToNext()){
            val islem = IslemPratik(c.getInt(c.getColumnIndex("islem_id"))
                ,c.getString(c.getColumnIndex("islem"))
            ,c.getString(c.getColumnIndex("islem_cevap")))

            islemListe.add(islem)

        }
        return islemListe
    }

}