package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abc.xyz.cocuklaricingelistiricipratikler00.databinding.ActivitySecimEkraniBinding

class SecimEkraniActivity : AppCompatActivity() {
    private lateinit var tasarim: ActivitySecimEkraniBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivitySecimEkraniBinding.inflate(layoutInflater)
        setContentView(tasarim.root)


        val ad = intent.getStringExtra("ad")

        val sp = getSharedPreferences("adTutucu",Context.MODE_PRIVATE)
        val ad2 =  sp.getString("ad",ad)

        tasarim.textViewAd.text = "Hoşgeldin $ad;"
        tasarim.textViewAd.text = "Hoşgeldin $ad2;"



        tasarim.buttonPratikOkuma.setOnClickListener {
            startActivity(Intent(this@SecimEkraniActivity,OkumaPratikActivity::class.java))
        }

        tasarim.buttonPratikYazma.setOnClickListener {
            startActivity(Intent(this@SecimEkraniActivity,YazmaPratikActivity::class.java))
        }

        tasarim.buttonPratikSayi.setOnClickListener {
            startActivity(Intent(this@SecimEkraniActivity,SayiPratikActivity::class.java))
        }

        tasarim.buttonPratikIslem.setOnClickListener {
            startActivity(Intent(this@SecimEkraniActivity,IslemPratikActivity::class.java))
        }


    }
}