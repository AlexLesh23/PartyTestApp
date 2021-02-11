package com.bsc.msc.testapp.ui.party

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bsc.msc.testapp.R
import com.bsc.msc.testapp.addToCompositeDisposable
import com.bsc.msc.testapp.ui.adapter.GuestsRecyclerViewAdapter
import com.bsc.msc.testapp.viewmodel.PartyViewModel
import dagger.hilt.android.AndroidEntryPoint
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

@AndroidEntryPoint
class PartyActivity : AppCompatActivity() {
    private val partyViewModel: PartyViewModel by viewModels()

    private val disposeBag = CompositeDisposable()
    private var guestsAdapter: GuestsRecyclerViewAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        loadData()
    }

    private fun loadData() {
        partyViewModel.getPartyInfo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ models ->
                val guestsRecyclerView = findViewById<RecyclerView>(R.id.guestsRecyclerView)
                guestsRecyclerView.apply {
                    setHasFixedSize(true)
                    guestsAdapter = GuestsRecyclerViewAdapter(models, this@PartyActivity)
                    adapter = guestsAdapter
                    layoutManager = LinearLayoutManager(this@PartyActivity)
                }
            }, {
                Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
            }).addToCompositeDisposable(disposeBag)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onDestroy() {
        disposeBag.clear()
        super.onDestroy()
    }
}


