package ua.uz.alex.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import ua.uz.alex.dao.UserDao;
import ua.uz.alex.dao.impl.UserDaoImpl;
import ua.uz.alex.domain.User;
import ua.uz.alex.service.UserService;

public class UserServiceImpl implements UserService {
    private static Logger LOGGER = Logger.getLogger(UserServiceImpl.class);
    private static UserService userServiceImpl;
    private UserDao userDao;

    private UserServiceImpl() {
        try {
            userDao = new UserDaoImpl();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            LOGGER.error(e);
        }
    }
    /* ---- Singleton pattern ----- */
    public static UserService getUserService() {
        if (userServiceImpl == null) {
            userServiceImpl = new UserServiceImpl();
        }
        return userServiceImpl;
    }

    @Override
    public User create(User t) {

        return userDao.create(t);
    }

    @Override
    public User readById(Integer id) {
        return userDao.readById(id);
    }

    @Override
    public User readByString(String string) {
        return userDao.readByString(string);
    }

    @Override
    public User update(User t) {
        return userDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }

    @Override
    public List<User> readAll() {
        return userDao.readAll();
    }

}
