package guru.springframework.services.jpaservices;

import guru.springframework.domain.User;
import guru.springframework.services.UserService;
import guru.springframework.services.security.EncryptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by jt on 12/14/15.
 */
@Service
@Profile("jpadao")
public class UserServiceJpaDaoImpl extends AbstractJpaDaoService implements UserService {

    private EncryptionService encryptionService;
    private EntityManager entityManager;

    @Autowired
    public void setEncryptionService(EncryptionService encryptionService, EntityManager entityManager) {
        this.encryptionService = encryptionService;
        this.entityManager = entityManager;
    }

    @Override
    public List<User> listAll() {

        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public User getById(Integer id) {

        return entityManager.find(User.class, id);
    }

    @Override
    public User saveOrUpdate(User domainObject) {

        entityManager.getTransaction().begin();

        if(domainObject.getPassword() != null){
            domainObject.setEncryptedPassword(encryptionService.encryptString(domainObject.getPassword()));
        }

        User savedUser = entityManager.merge(domainObject);
        entityManager.getTransaction().commit();

        return savedUser;
    }

    @Override
    public void delete(Integer id) {

        entityManager.getTransaction().begin();
        entityManager.remove(entityManager.find(User.class, id));
        entityManager.getTransaction().commit();
    }

    @Override
    public User findByUsername(String userName) {
        return entityManager.createQuery("from User where username = :userName", User.class).getSingleResult();
    }
}
