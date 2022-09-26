package com.abc.xyz.cocuklaricingelistiricipratikler00

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.abc.xyz.cocuklaricingelistiricipratikler00.databinding.ActivityEnBastakiBinding

class EnBastakiActivity : AppCompatActivity() {
   // lateinit var mAdView : AdView

    private lateinit var tasarim : ActivityEnBastakiBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        tasarim = ActivityEnBastakiBinding.inflate(layoutInflater)
        setContentView(tasarim.root)
      //  loadBannerAdd()

        supportActionBar?.hide()

        veritabaniCopy()


        tasarim.buttonBasla.setOnClickListener {
            startActivity(Intent(this@EnBastakiActivity,AdGirisActivity::class.java))
            // finish()
        }

    }

    fun veritabaniCopy() {
        val copyHelpery = DatabaseCopyHelper(this)
        try {
            copyHelpery.createDataBase()
            copyHelpery.openDataBase()
        } catch (e: Exception) {
            e.printStackTrace()

        }
    }

 /*   private fun loadBannerAdd(){

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