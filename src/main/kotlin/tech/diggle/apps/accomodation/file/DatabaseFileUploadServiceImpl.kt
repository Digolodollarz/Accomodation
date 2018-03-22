package tech.diggle.apps.accomodation.file

import org.springframework.stereotype.Service
import org.springframework.web.multipart.MultipartFile
import tech.diggle.apps.utils.ImageCompressionUtils
import java.io.IOException

@Service
class DatabaseFileUploadServiceImpl(val repository: DBImagesRepository) : FileUploadService {
    override fun getFile(fileId: Long): ByteArray {
        return repository.findOne(fileId).byteArray!!
    }

    override fun storeFile(house: Long, file: MultipartFile): Long? {
        if (!file.isEmpty) try {
            val fileByteArray = ImageCompressionUtils.compressImage(file.bytes, 0.7f)
            val image = DBImage()
            image.houseId = house
            image.byteArray = fileByteArray
            return repository.save(image).id
        } catch (ex: IOException) {
            ex.printStackTrace()
        }
        return null
    }

    override fun getFile(houseId: Long, fileName: String): ByteArray {
        return repository.findByHouseId(houseId).byteArray!!
    }

}