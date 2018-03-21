package tech.diggle.apps.accomodation.house

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class HouseServiceImpl(@Autowired val repository: HouseRepository)
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

}