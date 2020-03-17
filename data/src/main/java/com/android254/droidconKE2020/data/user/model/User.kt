package com.android254.droidconKE2020.data.user.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * 15/03/20
 * @author bernard
 */
@Entity
data class User(
    @PrimaryKey
    var id: Int,
    var name: String = "John doe"
)