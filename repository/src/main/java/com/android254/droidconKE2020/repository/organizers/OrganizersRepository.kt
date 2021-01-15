package com.android254.droidconKE2020.repository.organizers

import com.android254.droidconKE2020.core.models.OrganizerUIModel
import com.android254.droidconKE2020.network.api.ApiService
import com.android254.droidconKE2020.repository.Data
import com.android254.droidconKE2020.repository.mappers.toOrganizerUIModel

interface OrganizersRepository {
    suspend fun fetchOrganizers(): Data<List<OrganizerUIModel>>
}
class OrganizersRepositoryImpl(private val apiService: ApiService) : OrganizersRepository {
    override suspend fun fetchOrganizers(): Data<List<OrganizerUIModel>> {
        return try {
            val response = apiService.organizers.fetchOrganizers()
            when {
                response.isSuccessful -> Data.Success(
                    response.body()!!.organizers.map { organizerItem ->
                        organizerItem.toOrganizerUIModel()
                    }
                )
                else -> Data.Error(response.message())
            }
        } catch (exception: Exception) {
            Data.Error(exception.message)
        }
    }
}