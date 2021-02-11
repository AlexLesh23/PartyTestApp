package com.bsc.msc.testapp.model

data class Party(
    val title: String,
    val partyImageUrl: String?,
    val inviter: String,
    val inviterAvatarUrl: String?,
    val guests: List<Guest>
)