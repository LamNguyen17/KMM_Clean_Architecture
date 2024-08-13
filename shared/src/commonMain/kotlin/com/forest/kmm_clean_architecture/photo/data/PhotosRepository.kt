package com.forest.kmm_clean_architecture.photo.data

class PhotosRepository(
    private val dataSource: PhotosDataSource,
    private val service: PhotosService
) {

    suspend fun getPhotos(forceFetch: Boolean): List<PhotoRaw> {
        if (forceFetch) {
            dataSource.clearPhotos()
            return fetchPhotos()
        }

        val photosDb = dataSource.getAllPhotos()
        println("Got ${photosDb.size} from the database!!")

        if (photosDb.isEmpty()) {
            return fetchPhotos()
        }
        return photosDb
    }

    private suspend fun fetchPhotos(): List<PhotoRaw> {
        val fetchedPhotos = service.fetchPhotos()
        dataSource.insertPhotos(fetchedPhotos)
        return fetchedPhotos
    }
}