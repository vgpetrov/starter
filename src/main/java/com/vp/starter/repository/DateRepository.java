package com.vp.starter.repository;

import com.vp.starter.entities.JDate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.StatelessSession;
import org.hibernate.type.StringType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManagerFactory;
import java.util.Date;
import java.util.List;

@Repository
public class DateRepository {

    @Autowired
    EntityManagerFactory entityManagerFactory;

    public String getTZ() {
        SessionFactory unwrap = entityManagerFactory.unwrap(SessionFactory.class);
        try (
            StatelessSession statelessSession = unwrap.openStatelessSession();
        ) {
            final List list = statelessSession
                    .createNativeQuery("SELECT @@GLOBAL.time_zone as g_tz, @@SESSION.time_zone as s_tz")
                    .addScalar("g_tz", StringType.INSTANCE)
                    .addScalar("s_tz", StringType.INSTANCE)
                    .list();
            Object[] s = (Object[]) list.get(0);
            return s[0]+"/"+s[1];
        }
    }

    public List<JDate> getDate() {
        addDate();
        SessionFactory unwrap = entityManagerFactory.unwrap(SessionFactory.class);
        try (
                final Session session = unwrap.openSession();
        ) {
            return session.createQuery("from JDate order by date desc")
                    .list();
        }
    }

    public void addDate() {
        SessionFactory unwrap = entityManagerFactory.unwrap(SessionFactory.class);
        try (
            final Session session = unwrap.openSession();
        ) {
            session.beginTransaction();
            final JDate object = new JDate();
            object.setDate(new Date());
            session.save(object);
            session.getTransaction().commit();
        }
    }

}
