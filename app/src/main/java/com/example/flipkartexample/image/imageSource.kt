package com.example.flipkartexample.image

import com.example.flipkartexample.R
import com.example.flipkartexample.datas.DataSource
import com.example.flipkartexample.datas.KartSource

class ImageSource {
    fun getAll(): List<DataSource> {
        return listOf(
            DataSource(R.drawable.h1),
            DataSource(R.drawable.h2),
            DataSource(R.drawable.h3),
        )
    }
    fun getAl(): List<KartSource> {
        return listOf(
            KartSource(R.drawable.h8),
            KartSource(R.drawable.h6),
            KartSource(R.drawable.h4),
        )
    }
}