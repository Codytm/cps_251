package com.example.contactproject

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "contacts")
class Contact {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "contactId")
    var id: Int = 0

    @ColumnInfo(name = "contactName")
    var contactName: String? = null

    var contactPhone: String? = null


    constructor() {}

    constructor(id: Int, contactname: String, contactphone: String) {
        this.id = id
        this.contactName = contactname
        this.contactPhone = contactphone
    }
    constructor(contactname: String, contactphone: String) {
        this.contactName = contactname
        this.contactPhone = contactphone
    }
}