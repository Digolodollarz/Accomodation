package tech.diggle.apps.accomodation.file

import org.springframework.web.multipart.MultipartFile

interface FileUploadService {
    fun storeFile(house: Long, file: MultipartFile): String?
    fun getFile(house: Long, fileName: String): ByteArray
}