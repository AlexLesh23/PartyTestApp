package com.bsc.msc.testapp.model

class HeaderViewHolderModel(party: Party, resString: String) : ViewHolderModel {
    val inviterName: String = "$resString ${party.inviter}"
    val inviterAvatarURL: String? = party.inviterAvatarUrl
    val partyName: String = party.title
    val partyImageURL: String? = party.partyImageUrl
}