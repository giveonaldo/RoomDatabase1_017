package com.pam.roomdb1.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.pam.roomdb1.data.dao.SiswaDao
import com.pam.roomdb1.data.entity.Siswa

@Database(entities = [Siswa::class], version = 1, exportSchema = false)
abstract class DatabaseSiswa: RoomDatabase() {
    abstract fun siswaDao(): SiswaDao

    companion object {
        @Volatile
        private var Instance: DatabaseSiswa? = null

        fun getDatabase(context: Context): DatabaseSiswa {
            return Instance?: synchronized(this) {
                Instance?: buildDatabase(context).also { Instance = it }
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                DatabaseSiswa::class.java,
                "siswa_database"
            ).build()
    }
}