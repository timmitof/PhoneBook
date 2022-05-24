package com.timmitof.phonebook.repositories

import androidx.room.*
import com.timmitof.phonebook.models.PhoneNumber

@Dao
interface PhoneNumberDao {

    @Query("SELECT * FROM Phones")
    fun getAllPhoneNumbers(): List<PhoneNumber>

    @Insert
    fun insertPhoneNumber(vararg phoneNumber: PhoneNumber)

    @Delete
    fun deletePhoneNumber(phoneNumber: PhoneNumber)

    @Update
    fun updatePhoneNumber(phoneNumber: PhoneNumber)
}