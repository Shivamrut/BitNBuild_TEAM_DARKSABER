package com.example.techtrekkerbitnbuild.databaseFiles

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserDataDao {
    @Query("SELECT * FROM userData")
    fun getAllUsers(): List<UserData>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertUser(user: UserData): Long // Make the function suspend

    @Query("SELECT * FROM userData WHERE id = :userId")
    fun getUserById(userId: Long): UserData

    @Query("DELETE FROM userData")
    suspend fun deleteAll()

}