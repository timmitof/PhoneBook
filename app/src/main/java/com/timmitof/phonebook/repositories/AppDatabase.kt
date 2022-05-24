package com.timmitof.phonebook.repositories

import androidx.room.Database
import androidx.room.RoomDatabase
import com.timmitof.phonebook.models.PhoneNumber

@Database(entities = [PhoneNumber::class], version = 3, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {
    abstract fun PhoneNumberDao(): PhoneNumberDao
}