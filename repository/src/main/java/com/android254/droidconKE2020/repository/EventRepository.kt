package com.android254.droidconKE2020.repository

import com.android254.droidconKE2020.core.models.SponsorUIModel
import com.android254.droidconKE2020.network.api.ApiService
import com.android254.droidconKE2020.repository.mappers.toSponsorUIModel

interface EventRepository {
    suspend fun fetchSponsors(): Data<List<SponsorUIModel>>
}

class EventRepositoryImpl(private val apiService: ApiService) : EventRepository {
    override suspend fun fetchSponsors(): Data<List<SponsorUIModel>> {
        return try {
            val response = apiService.events.getSponsors()
            when {
                response.isSuccessful -> {
                    val data = response.body()!!
                    Data.Success(
                        data.data.map { sponsorItem ->
                            sponsorItem.toSponsorUIModel()
                        }
                    )
                }
                else -> {
                    Data.Error(response.message())
                }
            }
        } catch (exception: Exception) {
            Data.Error(exception.message)
        }
    }
}