package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.annotation.SuppressLint

class YazmaPratikDao {


    @SuppressLint("Recycle", "Range")
    fun tumYazilar(vt: VeritabaniYardimcisi) : ArrayList<YazmaPratik> {
        val yazmaListe = ArrayList<YazmaPratik>()
        val db = vt.writableDatabase

        val c = db.rawQuery("SELECT * FROM yazmapratik ORDER BY RANDOM()",null)

        while (c.moveToNext()){
            val yazma = YazmaPratik(c.getInt(c.getColumnIndex("yazilacak_metin_id"))
                ,c.getString(c.getColumnIndex("yazilacak_metin")))

            yazmaListe.add(yazma)
        }
        return yazmaListe
    }


}