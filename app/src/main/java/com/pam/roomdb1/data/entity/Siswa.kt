package com.pam.roomdb1.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "siswa")
data class Siswa(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nama: String,
    val alamat: String,
    val telpon: String
)
