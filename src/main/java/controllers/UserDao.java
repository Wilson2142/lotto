package controllers;

import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


@Component
@Transactional
public class UserDao {

    @PersistenceContext
    private EntityManager em;

    public void save(User user) {
        em.persist(user);
    }

    public List<User> findAll() {
        return em.createQuery("SELECT u FROM User u", User.class)
                .getResultList();
    }

    public void update(User newUser) {
        em.merge(newUser);
    }


    public User findUserByEmail(String emailReg) {
        List<User> users = em.createQuery("SELECT u FROM User u WHERE u.email=:email", User.class)
                .setParameter("email", emailReg)
                .getResultList();

        return !users.isEmpty()
                ? users.get(0)
                : null;
    }
}
