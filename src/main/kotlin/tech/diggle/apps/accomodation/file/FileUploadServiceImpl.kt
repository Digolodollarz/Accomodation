package tech.diggle.apps.accomodation.file

import org.springframework.web.multipart.MultipartFile
import tech.diggle.apps.utils.ImageCompressionUtils
import java.io.File
import java.io.FileOutputStream
import java.io.IOException

class FileUploadServiceImpl {

     fun storeFile(house: Long, file: MultipartFile): String? {
        if (!file.isEmpty) try {
            val saveFile = File("""$UPLOAD_DIR/$house/${file.originalFilename}""")
            if (!saveFile.parentFile.exists()) saveFile.parentFile.mkdirs()
//            file.transferTo(saveFile)
            val fileByteArray = ImageCompressionUtils.compressImage(file.bytes, 0.7f)
            val fos = FileOutputStream(saveFile)
            fos.use { fs ->
                fs.write(fileByteArray)
            }
            return saveFile.path
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return null
    }

     fun getFile(house: Long, fileName: String): ByteArray {
        return File("""$UPLOAD_DIR/$house/$fileName""").readBytes()
    }

    companion object {
        val UPLOAD_DIR: String = "C:/Projects/House"
    }

}