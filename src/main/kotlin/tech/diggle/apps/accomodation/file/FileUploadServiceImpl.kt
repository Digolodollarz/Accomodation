package tech.diggle.apps.accomodation.file

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import java.io.File
import java.io.IOException

@Service
class FileUploadServiceImpl : FileUploadService {

    override fun storeFile(house: Long, file: MultipartFile): String? {
        if (!file.isEmpty) try {
            val saveFile = File("""$UPLOAD_DIR/$house/${file.originalFilename}""")
            if (!saveFile.parentFile.exists()) saveFile.parentFile.mkdirs()
            file.transferTo(saveFile)
            return saveFile.path
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return null
    }

    override fun getFile(house: Long, fileName: String): ByteArray {
        return File("""$UPLOAD_DIR/$house/$fileName""").readBytes()
    }

    companion object {
        val UPLOAD_DIR: String = "C:/Projects/House"
    }

}