package com.example.deltatask.domain.repository

import com.example.deltatask.data.network.service

const val api_key = "90a0dea35e574f45b381e81a45bccbb5"

class DataRepository {
    val list = service.getEverything("tesla", api_key)
}