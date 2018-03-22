package tech.diggle.apps.accomodation.owner

import org.springframework.stereotype.Service

@Service
class OwnerServiceImpl(val repository: OwnerRepository) : OwnerService {
    override fun get(id: Long): Owner {
        return this.repository.getOne(id)
    }

    override fun add(o: Owner): Owner {
        return this.repository.save(o)
    }

    override fun getOrAdd(o: Owner): Owner = repository.findByEmail(o.email) ?: repository.save(o)

    override fun update(o: Owner): Owner {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


}