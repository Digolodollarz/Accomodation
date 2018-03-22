package tech.diggle.apps.accomodation.file

import org.springframework.web.multipart.MultipartFile

interface FileUploadService {
    fun storeFile(house: Long, file: MultipartFile): Long?
    fun getFile(houseId: Long, fileName: String): ByteArray
    fun getFile(fileId: Long): ByteArray
}