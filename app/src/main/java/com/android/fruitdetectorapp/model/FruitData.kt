package com.android.fruitdetectorapp.model

import java.io.Serializable


//fruit model data object
data class FruitData(
    val id : Int,
    val nama : String,
    val deskripsi : String,
    val asal : String,
    val manfaat : String,
    val nutrisi : String,
    val gambar : String
) : Serializable
