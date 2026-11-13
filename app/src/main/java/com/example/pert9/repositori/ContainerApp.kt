package com.example.pert9.repositori

import android.content.Context
import com.example.pert9.room.DatabaseSiswa

interface ContainerApp {
    val repositoriSiswa: RepositoriSiswa
}

class ContainerDataApp(
    private val context: Context
) : ContainerApp {


}