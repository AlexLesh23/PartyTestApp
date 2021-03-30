package com.bsc.msc.testapp.domain.model

import com.bsc.msc.testapp.data.repository.network.response.Party

class HeaderItemView(party: Party) : ItemView {
    val inviterName: String = party.inviter
    val inviterAvatarURL: String? = party.inviterAvatarUrl
    val partyName: String = party.title
    val partyImageURL: String? = party.partyImageUrl
}