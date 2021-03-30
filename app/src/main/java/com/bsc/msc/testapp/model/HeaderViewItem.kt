package com.bsc.msc.testapp.model

class HeaderViewItem(party: Party, inviterLabel: String) : ViewItem {
    val inviterName: String = "$inviterLabel ${party.inviter}"
    val inviterAvatarURL: String? = party.inviterAvatarUrl
    val partyName: String = party.title
    val partyImageURL: String? = party.partyImageUrl
}