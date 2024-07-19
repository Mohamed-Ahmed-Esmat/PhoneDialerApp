package com.example.phonedialerapp.data

import com.example.phonedialerapp.R
import com.example.phonedialerapp.model.Contact

class DataSource {
    fun getContactsData(): List<Contact> {
        val contacts = mutableListOf<Contact>()
        contacts.add(Contact("Auntie", "+201123456678", R.drawable.auntie))
        contacts.add(Contact("Brother", "+201123456789", R.drawable.brother))
        contacts.add(Contact("Daughter", "+201234567890", R.drawable.daughter))
        contacts.add(Contact("Friend 1", "+201345678901", R.drawable.friend_1))
        contacts.add(Contact("Friend 2", "+201456789012", R.drawable.friend_2))
        contacts.add(Contact("Grandfather", "+201567890123", R.drawable.grandfather))
        contacts.add(Contact("Granny", "+201678901234", R.drawable.granny))
        contacts.add(Contact("Neighbour", "+201789012345", R.drawable.neigbour))
        contacts.add(Contact("Sister", "+201890123456", R.drawable.sister))
        contacts.add(Contact("Son", "+201901234567", R.drawable.son))
        contacts.add(Contact("Uncle", "+201012345678", R.drawable.uncle))
        return contacts
    }
}