package com.bsc.msc.testapp.viewmodel

import android.content.Context
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.bsc.msc.testapp.R
import com.bsc.msc.testapp.model.GuestViewHolderModel
import com.bsc.msc.testapp.model.HeaderViewHolderModel
import com.bsc.msc.testapp.model.ViewHolderModel
import com.bsc.msc.testapp.repository.PartyRepository
import dagger.hilt.android.qualifiers.ApplicationContext
import io.reactivex.rxjava3.core.Single

class PartyViewModel @ViewModelInject constructor(
    private val partyRepository: PartyRepository,
    @ApplicationContext private val context: Context
) :
    ViewModel() {

    fun getPartyInfo(): Single<MutableList<ViewHolderModel>> = partyRepository.getPartyInfo().map {
        val models = mutableListOf<ViewHolderModel>()
        models.add(
            HeaderViewHolderModel(
                it.party,
                context.getString(R.string.inviterLabel)
            )
        )
        it.party.guests.forEach { guest ->
            models.add(GuestViewHolderModel(guest))
        }
        models
    }
}