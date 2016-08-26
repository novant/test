package usermanager.dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import usermanager.model.User;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.stereotype.Repository;


import java.util.List;


@Repository
public class UserDao implements IUSerDao {
    private static final Logger logger = LoggerFactory.getLogger(UserDao.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(user);
        logger.info("User successfully saved. User details: " + user);
    }

    @Override
    public void updateUser(User user) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(user);
        logger.info("User successfully update. User details: " + user);
    }

    @Override
    public void removeUser(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));

        if (user!=null){
            session.delete(user);
        }
        logger.info("User successfully removed. User details: " + user);
    }

    @Override
    public User getUserId(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        User user = (User) session.load(User.class, new Integer(id));
        logger.info("User successfully loaded. User details: " + user);

        return user;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<User> listUsers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<User> list = session.createQuery("from users").list();

        for (User user : list){
            logger.info("User list: " + user);
        }
        return list;
    }
}
