package com.bsc.msc.testapp.model

import com.bsc.msc.testapp.network.model.response.Guest

class GuestViewItem(guest: Guest) : ViewItem {
    val name = guest.name
    val avatar = guest.avatar
}