package com.pam.roomdb1.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pam.roomdb1.data.entity.Siswa
import kotlinx.coroutines.flow.Flow

@Dao
interface SiswaDao {
    // Tambah Data
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(siswa: Siswa)

    // Get All Data
    @Query("SELECT * FROM siswa ORDER BY nama ASC")
    fun getAllSiswa(): Flow<List<Siswa>>
}