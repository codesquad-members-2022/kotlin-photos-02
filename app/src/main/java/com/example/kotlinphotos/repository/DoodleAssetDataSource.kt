package com.example.kotlinphotos.repository

import com.example.kotlinphotos.AssetLoader
import com.example.kotlinphotos.model.Photo
import org.json.JSONArray

class DoodleAssetDataSource(
    private val assetLoader: AssetLoader
) : DoodleDataSource {

    override fun getDoodleData(): List<Photo> {
        val photos = mutableListOf<Photo>()
        val str = assetLoader.jsonToString(DOODLE_FILE_NAME)
        val jsonArray = JSONArray(str)

        val size = jsonArray.length()
        repeat(size) {
            val json = jsonArray.getJSONObject(it)
            val title = json.getString("title")
            val image = json.getString("image")
            val date = json.getString("date")
            photos.add(Photo(title, image, date))
        }
        return photos
    }

    companion object {
        const val DOODLE_FILE_NAME = "doodle.json"
    }
}