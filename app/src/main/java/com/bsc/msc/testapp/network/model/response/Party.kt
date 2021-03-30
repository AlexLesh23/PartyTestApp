package com.bsc.msc.testapp.network.model.response

import com.bsc.msc.testapp.network.model.response.Guest

data class Party(
    val title: String,
    val partyImageUrl: String?,
    val inviter: String,
    val inviterAvatarUrl: String?,
    val guests: List<Guest>
)