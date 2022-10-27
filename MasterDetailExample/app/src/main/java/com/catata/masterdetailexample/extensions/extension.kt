package com.catata.masterdetailexample.extensions

import android.graphics.BitmapFactory
import android.widget.ImageView
import java.io.InputStream

fun ImageView.setBitmapfromString(name:String){

    val imageName = name.split(".")[0]

    val id = context.resources.getIdentifier(
        imageName, //Something like "batman"
        "raw",
        context.packageName
    )
    val inputStream = context.resources.openRawResource(id)

    val image = BitmapFactory.decodeStream(inputStream)
    setImageBitmap(image)

}