package com.bsc.msc.testapp.model

class GuestViewItem(guest: Guest) : ViewItem {
    val name = guest.name
    val avatar = guest.avatar
}