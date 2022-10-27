package com.ompava.p2_master_detail_series.extesions

import android.graphics.BitmapFactory
import android.widget.ImageView


fun ImageView.setBitmapfromString(name: String) {
    val imageName = name.split(".")[0]
    val id = context.resources.getIdentifier(
        imageName, //Something like "batman"
        "drawable",
        context.packageName
    )
    val inputStream = context.resources.openRawResource(id)

    val image = BitmapFactory.decodeStream(inputStream)
    setImageBitmap(image)
}
