package com.bsc.msc.testapp.domain

import com.bsc.msc.testapp.data.repository.network.response.Guest
import com.bsc.msc.testapp.data.repository.network.response.Party
import com.bsc.msc.testapp.domain.model.GuestItemView
import com.bsc.msc.testapp.domain.model.HeaderItemView

object GuestTransformer {
    fun transform(guest: Guest) = GuestItemView(guest.name, guest.avatar)
}

object HeaderTransformer {
    fun transform(party: Party) = HeaderItemView(party)
}

