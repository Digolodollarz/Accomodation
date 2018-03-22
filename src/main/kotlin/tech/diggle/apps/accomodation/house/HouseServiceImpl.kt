package tech.diggle.apps.accomodation.house

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import tech.diggle.apps.accomodation.file.FileUploadService
import tech.diggle.apps.accomodation.owner.OwnerService


@Service
class HouseServiceImpl(@Autowired val repository: HouseRepository,
                       @Autowired val ownerService: OwnerService,
//                       @Qualifier("DatabaseFileUploadServiceImpl")
                       @Autowired val fileUploadService: FileUploadService)
    : HouseService {
    override fun get(id: Long): House {
        return repository.findOne(id)
    }

    override fun add(house: House): House {
        return repository.save(house)
    }

    override fun update(house: House): House {
        return repository.save(house)
    }

    @SuppressWarnings("uncheckedCasts")
    override fun getAll(): List<House> {
        return repository.findAll() as List<House>
    }

    override fun create(form: HouseForm): House {
        var house = House()
        house.title = form.title!!
        house.address = form.address!!
        house.location = form.location!!
        house.capacity = form.capacity!!
        house.occupied = form.occupied!!
        house.rooms = form.rooms!!

        val owner = ownerService.getOrAdd(form.owner!!)

        house.owner = owner
        house = repository.save(house)

        if (form.images.count() > 0) {
            for (file in form.images) {
                val fileId = fileUploadService.storeFile(house.id, file)
                if (fileId != null) {
                    val filename = file.originalFilename
                    house.images.add(fileId!!)
                }
            }
        }

        return this.update(house)
    }

}