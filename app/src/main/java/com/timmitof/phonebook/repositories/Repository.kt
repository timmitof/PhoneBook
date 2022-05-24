package com.timmitof.phonebook.repositories

import com.timmitof.phonebook.App
import com.timmitof.phonebook.models.PhoneNumber

class Repository{
    fun addContact(user: PhoneNumber){
        App.instance?.getDatabase()?.PhoneNumberDao()?.insertPhoneNumber(user)
    }
}