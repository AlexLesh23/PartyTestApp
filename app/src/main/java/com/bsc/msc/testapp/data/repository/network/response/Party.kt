package com.bsc.msc.testapp.data.repository.network.response

data class Party(
    val title: String,
    val partyImageUrl: String?,
    val inviter: String,
    val inviterAvatarUrl: String?,
    val guests: List<Guest>
)