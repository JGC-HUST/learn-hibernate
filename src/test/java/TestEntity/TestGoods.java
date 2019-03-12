package TestEntity;

import Entity.Goods;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Description: TODO
 * @Author: JGC
 * @Date: 2019/3/12 16:53
 * @Version: 1.0
 */
public class TestGoods {
    private SessionFactory sessionFactory;
    private Session session;
    private Transaction transaction;

    @Before
    public void init() {
        Configuration configuration = new Configuration().configure();
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        transaction = session.beginTransaction();
    }

    @After
    public void destory() {
        transaction.commit();
        session.close();
        sessionFactory.close();
    }

    @Test
    public void testGoods() {
        Goods goods = new Goods(1, "你好", 233.33);
        session.save(goods);
    }
}
