package com.abc.xyz.cocuklaricingelistiricipratikler00

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

@Entity(tableName = "islempratik")
data class IslemPratik(@PrimaryKey(autoGenerate = true)
                       @ColumnInfo(name = "islem_id")@NotNull var islem_id:Int,
                       @ColumnInfo(name = "islem")@NotNull var islem:String,
                       @ColumnInfo(name = "islem_cevap")@NotNull var islem_cevap:String)