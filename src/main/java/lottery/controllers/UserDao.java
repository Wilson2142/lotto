package lottery.controllers;

import lottery.domain.Account;
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

    public void save(Account account) {
        em.persist(account);
    }

    public List<Account> findAll() {
        return em.createQuery("SELECT u FROM Account u", Account.class)
                .getResultList();
    }

    public void update(Account newAccount) {
        em.merge(newAccount);
    }


    public Account findUserByEmail(String emailReg) {
        List<Account> accounts = em.createQuery("SELECT u FROM Account u WHERE u.email=:email", Account.class)
                .setParameter("email", emailReg)
                .getResultList();

        return !accounts.isEmpty()
                ? accounts.get(0)
                : null;
    }
}
