package com.example.techtrekkerbitnbuild.databaseFiles

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userData")
data class UserData(
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0,
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = "",
    var collegeName: String = "",
    var degree: String = "",
    var dob: String = "",
    var imgRes: Int = 0,
    var eventsParticipated: Int = 0,
    var club: String = "",
    var phone: Long = 0,
    var bio: String = ""

)

