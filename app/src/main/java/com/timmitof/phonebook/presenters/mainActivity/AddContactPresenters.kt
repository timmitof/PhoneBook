package com.timmitof.phonebook.presenters.mainActivity

import com.timmitof.phonebook.models.PhoneNumber
import com.timmitof.phonebook.repositories.Repository
import com.timmitof.phonebook.views.fragments.AddContactFragment

class AddContactPresenters(val view: AddContactFragment): IAddContactPresenters {

    override fun addContact(name: String, phoneNumber: String, photo: String) {
        val user = PhoneNumber(null, name, phoneNumber, photo)
        Repository().addContact(user)
    }
}