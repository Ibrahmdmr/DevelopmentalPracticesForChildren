package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.abc.xyz.cocuklaricingelistiricipratikler00.databinding.ActivityOkumaPratikBinding
import com.google.android.gms.ads.*


class OkumaPratikActivity : AppCompatActivity() {

   // lateinit var mAdView : AdView
    private lateinit var vt: VeritabaniYardimcisi

    private lateinit var tasarim: ActivityOkumaPratikBinding
    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityOkumaPratikBinding.inflate(layoutInflater)
        setContentView(tasarim.root)

       // loadBannerAdd()


        tasarim.toolbarOkumaPratik.title = "TÜRKÇE"
        tasarim.toolbarOkumaPratik.subtitle = "Okuma Pratiği"
        setSupportActionBar(tasarim.toolbarOkumaPratik)



        vt = VeritabaniYardimcisi(this)
        val okumaListe = OkumaPratikDao().tumOkumalar(vt)

        for (o in okumaListe) {
            if (o.okuma_metin == o.okuma_metin) {
                tasarim.cardDevamOkuma.setOnClickListener {



                    val okumaListe = OkumaPratikDao().tumOkumalar(vt)
                    for (o2 in okumaListe) {
                        tasarim.textViewOkunacakMetin.text = o2.okuma_metin

                        tasarim.cardKontrolOkuma.setOnClickListener {

                                if (tasarim.editTextGirilecekMetin.text.toString() == o2.okuma_metin) {
                                    tasarim.textViewKontrol.text =
                                        "Cevabınız Doğrudur :) Devam edin veya bitirin"

                                } else {
                                    tasarim.textViewKontrol.text =
                                        "Cevabınız Yanlıştır :( Devam edin veya bitirin"
                                }
                                tasarim.textViewKontrol.visibility = View.VISIBLE
                                tasarim.editTextGirilecekMetin.setText("")
                            }
                        }
                    }
            }
            tasarim.textViewOkunacakMetin.text = o.okuma_metin

            tasarim.cardKontrolOkuma.setOnClickListener {

                    if (tasarim.editTextGirilecekMetin.text.toString() == o.okuma_metin) {
                        tasarim.textViewKontrol.text = "Cevabınız Doğrudur :) Devam edin veya bitirin"

                    } else {
                        tasarim.textViewKontrol.text = "Cevabınız Yanlıştır :( Devam edin veya bitirin"
                    }
                    tasarim.textViewKontrol.visibility = View.VISIBLE
                    tasarim.editTextGirilecekMetin.setText("")
            }
        }

        tasarim.cardBitisOkuma.setOnClickListener {
            startActivity(Intent(this@OkumaPratikActivity,BitisActivity::class.java))
            finish()
        }

    }


   /* private fun loadBannerAdd(){

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