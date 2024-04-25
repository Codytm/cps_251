package com.example.contactproject

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.*



class ContactRepository (application: Application) {
    val searchResults = MutableLiveData<List<Contact>>()
    private var contactDao: ContactDao?
    private val coroutineScope = CoroutineScope(Dispatchers.Main)
    val allContacts: LiveData<List<Contact>>?
    val ascContacts: LiveData<List<Contact>>?
    val descContacts: LiveData<List<Contact>>?

    init {
        val db: ContactRoomDatabase? =
            ContactRoomDatabase.getDatabase(application)
        contactDao = db?.contactDAO()
        allContacts = contactDao?.getAllContacts()
        ascContacts = contactDao?.getAscContacts()
        descContacts = contactDao?.getDescContacts()
    }

    fun insertContact(newcontact: Contact) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncInsert(newcontact)
        }
    }
    private fun asyncInsert(contact: Contact) {
        contactDao?.insertContact(contact)
    }

    fun deleteContact(id: Int) {
        coroutineScope.launch(Dispatchers.IO) {
            asyncDelete(id)
        }
    }
    private fun asyncDelete(id: Int) {
        contactDao?.deleteContact(id)
    }

    fun findContact(name: String) {
        coroutineScope.launch(Dispatchers.Main) {
            searchResults.value = asyncFind(name).await()
        }
    }
    //USES THE DEFERRED TO RETURN THE VALUES TO THE AWAIT OF THE FIND PRODUCT
    private fun asyncFind(name: String): Deferred<List<Contact>?> =
        coroutineScope.async(Dispatchers.IO) {
            //NOTICE THIS IS A RETURN HERE BECAUSE IT IS A SELECT QUERY IT RETURNS A VALUE
            return@async contactDao?.findContact(name)
        }
    fun getAscContacts() {
        coroutineScope.launch(Dispatchers.Main) {
            asyncAsc().await()
        }
    }
    private fun asyncAsc() : Deferred<LiveData<List<Contact>>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.getAscContacts()
        }

    fun getDescContacts() {
        coroutineScope.launch(Dispatchers.Main) {
            asyncDesc().await()
        }
    }
    private fun asyncDesc() : Deferred<LiveData<List<Contact>>?> =
        coroutineScope.async(Dispatchers.IO) {
            return@async contactDao?.getDescContacts()
        }
}