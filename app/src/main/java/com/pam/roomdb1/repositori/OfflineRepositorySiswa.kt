package com.pam.roomdb1.repositori

import com.pam.roomdb1.data.dao.SiswaDao
import com.pam.roomdb1.data.entity.Siswa
import kotlinx.coroutines.flow.Flow

class OfflineRepositorySiswa(private val siswaDao: SiswaDao): RepositorySiswa {
    override fun getAllSiswaStream(): Flow<List<Siswa>> = siswaDao.getAllSiswa()
    override suspend fun insertSiswa(siswa: Siswa) = siswaDao.insert(siswa)
}