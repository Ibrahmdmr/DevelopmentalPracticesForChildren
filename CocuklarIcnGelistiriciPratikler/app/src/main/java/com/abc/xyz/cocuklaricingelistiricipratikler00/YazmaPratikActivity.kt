package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.abc.xyz.cocuklaricingelistiricipratikler00.databinding.ActivityYazmaPratikBinding
import com.google.android.gms.ads.*

class YazmaPratikActivity : AppCompatActivity() {

    private lateinit var vt: VeritabaniYardimcisi
    //lateinit var mAdView : AdView

    private lateinit var tasarim : ActivityYazmaPratikBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityYazmaPratikBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

       // loadBannerAdd()

        tasarim.toolbarYazmaPratik.title = "TÜRKÇE"
        tasarim.toolbarYazmaPratik.subtitle = "Yazma Pratiği"
        setSupportActionBar(tasarim.toolbarYazmaPratik)


        vt = VeritabaniYardimcisi(this@YazmaPratikActivity)
        val yazmaListe = YazmaPratikDao().tumYazilar(vt)

        for (y in yazmaListe){
            if (y.yazilacak_metin == y.yazilacak_metin){
                tasarim.cardDevamYazma.setOnClickListener {
                    val yazmaListe = YazmaPratikDao().tumYazilar(vt)
                    for (y2 in yazmaListe){
                        tasarim.textViewYazilacakMetin.text = y2.yazilacak_metin

                        tasarim.cardKontrolYazma.setOnClickListener {

                            if (tasarim.editTextTextYazLanMetin.text.toString() == y2.yazilacak_metin) {
                                tasarim.textViewKontrolYazma.text = "Cevabınız Doğrudur :) Devam edin veya bitirin"

                            } else {
                                tasarim.textViewKontrolYazma.text = "Cevabınız Yanlıştır :( Devam edin veya bitirin"
                            }
                            tasarim.textViewKontrolYazma.visibility = View.VISIBLE
                            tasarim.editTextTextYazLanMetin.setText("")
                        }
                }
                }
            }
            tasarim.textViewYazilacakMetin.text = y.yazilacak_metin

            tasarim.cardKontrolYazma.setOnClickListener {

                if (tasarim.editTextTextYazLanMetin.text.toString() == y.yazilacak_metin) {
                    tasarim.textViewKontrolYazma.text = "Cevabınız Doğrudur :) Devam edin veya bitirin"

                } else {
                    tasarim.textViewKontrolYazma.text = "Cevabınız Yanlıştır :( Devam edin veya bitirin"
                }
                tasarim.textViewKontrolYazma.visibility = View.VISIBLE
                tasarim.editTextTextYazLanMetin.setText("")

            }
        }


        tasarim.cardBitisYazma.setOnClickListener {
            startActivity(Intent(this@YazmaPratikActivity,BitisActivity::class.java))
            finish()
        }

    }

  /*  private fun loadBannerAdd(){

        MobileAds.initialize(this) {}

        mAdView = findViewById(R.id.adView)
        val adRequest = AdRequest.Builder().build()
        mAdView.loadAd(adRequest)

        mAdView.adListener = object: AdListener() {
            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
            }

            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
            }

            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
            }
        }

    }*/


}