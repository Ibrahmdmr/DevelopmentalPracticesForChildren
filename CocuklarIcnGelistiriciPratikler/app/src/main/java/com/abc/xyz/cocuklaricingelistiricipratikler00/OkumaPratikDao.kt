package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.annotation.SuppressLint

class OkumaPratikDao {

    @SuppressLint("Range", "Recycle")
    fun tumOkumalar(vt: VeritabaniYardimcisi) : ArrayList<OkumaPratik>{
        val okumaListe = ArrayList<OkumaPratik>()

        val db = vt.writableDatabase

        val c = db.rawQuery("SELECT * FROM okumapratik ORDER BY RANDOM()",null)

        while (c.moveToNext()){
            val okuma = OkumaPratik(c.getInt(c.getColumnIndex("okuma_metin_id"))
                ,c.getString(c.getColumnIndex("okuma_metin")))

            okumaListe.add(okuma)

        }
        return okumaListe
    }

}