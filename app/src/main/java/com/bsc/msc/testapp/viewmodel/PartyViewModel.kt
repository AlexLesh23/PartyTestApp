package com.bsc.msc.testapp.viewmodel

import androidx.lifecycle.ViewModel
import com.bsc.msc.testapp.model.GuestViewItem
import com.bsc.msc.testapp.model.HeaderViewItem
import com.bsc.msc.testapp.model.ViewItem
import com.bsc.msc.testapp.repository.PartyRepository
import io.reactivex.rxjava3.core.Single

class PartyViewModel (
    private val partyRepository: PartyRepository
) :
    ViewModel() {

    fun getPartyInfo(): Single<MutableList<ViewItem>> = partyRepository.getPartyInfo().map {
        val models = mutableListOf<ViewItem>()
        models.add(
            HeaderViewItem(
                it.party,
                "Пригласил(а): "
            )
        )
        it.party.guests.forEach { guest ->
            models.add(GuestViewItem(guest))
        }
        models
    }
}