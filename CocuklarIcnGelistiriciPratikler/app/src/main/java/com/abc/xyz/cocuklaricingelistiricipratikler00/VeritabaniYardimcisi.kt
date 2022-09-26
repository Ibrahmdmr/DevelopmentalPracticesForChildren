package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper


class VeritabaniYardimcisi(context: Context) : SQLiteOpenHelper(context,"okumapratik1.sqlite",null,1) {
 override fun onCreate(db: SQLiteDatabase?) {
  db?.execSQL("CREATE TABLE IF NOT EXISTS \"okumapratik\" (\n" +
          "\t\"okuma_metin_id\"\tINTEGER NOT NULL,\n" +
          "\t\"okuma_metin\"\tTEXT NOT NULL,\n" +
          "\tPRIMARY KEY(\"okuma_metin_id\" AUTOINCREMENT)\n" +
          ");")

  db?.execSQL("CREATE TABLE IF NOT EXISTS \"yazmapratik\" (\n" +
          "\t\"yazilacak_metin_id\"\tINTEGER NOT NULL,\n" +
          "\t\"yazilacak_metin\"\tTEXT NOT NULL,\n" +
          "\tPRIMARY KEY(\"yazilacak_metin_id\" AUTOINCREMENT)\n" +
          ");")

  db?.execSQL("CREATE TABLE IF NOT EXISTS \"islempratik\" (\n" +
          "\t\"islem_id\"\tINTEGER NOT NULL,\n" +
          "\t\"islem\"\tTEXT NOT NULL,\n" +
          "\t\"islem_cevap\"\tTEXT NOT NULL,\n" +
          "\tPRIMARY KEY(\"islem_id\" AUTOINCREMENT)\n" +
          ");")

  db?.execSQL("CREATE TABLE IF NOT EXISTS \"sayipratik\" (\n" +
          "\t\"sayi_id\"\tINTEGER NOT NULL,\n" +
          "\t\"sayi\"\tINTEGER NOT NULL,\n" +
          "\t\"sayi_cevap\"\tTEXT NOT NULL,\n" +
          "\tPRIMARY KEY(\"sayi_id\" AUTOINCREMENT)\n" +
          ");")

 }

 override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
  db?.execSQL("DROP TABLE IF EXISTS okumapratik")
  db?.execSQL("DROP TABLE IF EXISTS yazmapratik")
  db?.execSQL("DROP TABLE IF EXISTS islempratik")
  db?.execSQL("DROP TABLE IF EXISTS sayipratik")

  onCreate(db)

 }

}