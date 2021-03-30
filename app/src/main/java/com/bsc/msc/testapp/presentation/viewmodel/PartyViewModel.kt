package com.bsc.msc.testapp.presentation.viewmodel

import android.os.Handler
import android.os.Looper
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.bsc.msc.testapp.data.repository.PartyRepository
import com.bsc.msc.testapp.domain.GuestTransformer
import com.bsc.msc.testapp.domain.HeaderTransformer
import com.bsc.msc.testapp.domain.model.ItemView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers

class PartyViewModel @ViewModelInject constructor(private val repository: PartyRepository) : ViewModel() {
    private val partyInfo = MutableLiveData<MutableList<ItemView>>(mutableListOf())

    fun loadPartyInfo(): MutableLiveData<MutableList<ItemView>> {
        repository.getPartyInfo()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                val models = ArrayList<ItemView>()
                models.add(HeaderTransformer.transform(it.party))
                it.party.guests.forEach { guest ->
                    models.add(GuestTransformer.transform(guest))
                }
                models
            }
            .subscribe {
                partyInfo.postValue(it)
            }
        Looper.myLooper()?.let {
            Handler(it).postDelayed({
                updateData()
            }, 2000)
        }
        return partyInfo
    }

    private fun updateData() {
        repository.getPartyInfo2()
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .map {
                val models = ArrayList<ItemView>()
                models.add(HeaderTransformer.transform(it.party))
                it.party.guests.forEach { guest ->
                    models.add(GuestTransformer.transform(guest))
                }
                models
            }
            .subscribe {
                partyInfo.postValue(it)
            }
    }
}