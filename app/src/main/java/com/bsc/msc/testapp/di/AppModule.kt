package com.bsc.msc.testapp.di

import com.bsc.msc.testapp.data.repository.PartyRepository
import com.bsc.msc.testapp.data.repository.PartyRepositoryImpl
import com.bsc.msc.testapp.data.repository.network.PartyApiImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@InstallIn(ApplicationComponent::class)
@Module
object AppModule {

    @Provides
    fun providesPartyApiImpl() = PartyApiImpl()

    @Provides
    fun providesPartyRepositoryImpl(partyApiImpl: PartyApiImpl) = PartyRepositoryImpl(partyApiImpl)

    @Provides
    fun providesPartyRepository(partyRepository: PartyRepositoryImpl): PartyRepository = partyRepository


}
