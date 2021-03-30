package com.bsc.msc.testapp.data.repository.network

import com.bsc.msc.testapp.data.repository.network.response.ApiResponse
import com.bsc.msc.testapp.data.repository.network.response.Guest
import com.bsc.msc.testapp.data.repository.network.response.Party
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Single
import javax.inject.Inject

class PartyApiImpl {
//    fun getPartyInfo(): Observable<ApiResponse> = partyApi.getPartyInfo()

    fun getPartyInfo(): Observable<ApiResponse> = Observable.just(
        ApiResponse(
            party = Party(
                title = "Пати",
                guests = arrayListOf(),
                inviter = "Инвайтер",
                inviterAvatarUrl = "https://html5css.ru/howto/img_avatar.png",
                partyImageUrl = "https://potokmedia.ru/wp-content/uploads/2020/10/real_63873105-ba5a-4700-be7e-55044ee5a282-696x464.jpeg"
            )
        )
    )

    fun getPartyInfo2(): Observable<ApiResponse> = Observable.just(
        ApiResponse(
            party = Party(
                title = "Пати11",
                guests = arrayListOf(
                    Guest("1 гость", "https://html5css.ru/howto/img_avatar.png"),
                    Guest("2 гость", "https://html5css.ru/howto/img_avatar2.png"),
                    Guest("3 гость", "https://html5css.ru/howto/img_avatar.png"),
                    Guest("4 гость", "https://html5css.ru/howto/img_avatar2.png"),
                    Guest("5 гость", "https://html5css.ru/howto/img_avatar.png"),
                    Guest("6 гость", "https://html5css.ru/howto/img_avatar2.png")
                ),
                inviter = "Инвайтер3",
                inviterAvatarUrl = "https://html5css.ru/howto/img_avatar.png",
                partyImageUrl = "https://potokmedia.ru/wp-content/uploads/2020/10/real_63873105-ba5a-4700-be7e-55044ee5a282-696x464.jpeg"
            )
        )
    )
}