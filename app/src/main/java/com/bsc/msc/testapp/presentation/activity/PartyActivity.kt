package com.bsc.msc.testapp.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import com.bsc.msc.testapp.R
import com.bsc.msc.testapp.presentation.fragment.PartyFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PartyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        initFragment()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    private fun initFragment() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.content_party, PartyFragment())
            .commit()
    }
}


