package com.bsc.msc.testapp.model

class GuestViewHolderModel(guest: Guest) : ViewHolderModel {
    val name = guest.name
    val avatar = guest.avatar
}