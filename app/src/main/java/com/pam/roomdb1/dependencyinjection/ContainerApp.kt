package com.pam.roomdb1.dependencyinjection

import android.content.Context
import com.pam.roomdb1.data.database.DatabaseSiswa
import com.pam.roomdb1.repositori.OfflineRepositorySiswa
import com.pam.roomdb1.repositori.RepositorySiswa

interface InterfaceContainerApp {
    val repositorySiswa: RepositorySiswa
}

class ContainerApp(private val context: Context): InterfaceContainerApp {
    override val repositorySiswa: RepositorySiswa by lazy {
        OfflineRepositorySiswa(DatabaseSiswa.getDatabase(context).siswaDao())
    }
}