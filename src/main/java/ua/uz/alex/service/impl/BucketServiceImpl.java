package ua.uz.alex.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.apache.log4j.Logger;
import ua.uz.alex.dao.BucketDao;
import ua.uz.alex.dao.impl.BucketDaoImpl;
import ua.uz.alex.domain.Bucket;
import ua.uz.alex.service.BucketService;


public class BucketServiceImpl implements BucketService {
    private static Logger LOGGER = Logger.getLogger(BucketServiceImpl.class);
    private static BucketService bucketServiceImpl;
    private BucketDao bucketDao;

    private BucketServiceImpl() {
        try {
            bucketDao = new BucketDaoImpl();
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
            LOGGER.error(e);
        }
    }

    /* ---- Singleton pattern ----- */
    public static BucketService getBucketService() {
        if (bucketServiceImpl == null) {
            bucketServiceImpl = new BucketServiceImpl();
        }
        return bucketServiceImpl;
    }

    @Override
    public Bucket create(Bucket t) {
        return bucketDao.create(t);
    }

    @Override
    public Bucket readById(Integer id) {
        return null;
    }

    @Override
    public Bucket readByString(String string) {
        return null;
    }

    @Override
    public Bucket update(Bucket t) {
        return bucketDao.update(t);
    }

    @Override
    public void delete(Integer id) {
        bucketDao.delete(id);
    }

    @Override
    public List<Bucket> readAll() {
        return bucketDao.readAll();
    }

}