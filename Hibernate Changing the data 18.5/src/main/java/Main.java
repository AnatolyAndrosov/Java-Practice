import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class Main {
    public static void main(String[] args) {

        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry).getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();


       /* //TODO Добавление данных
        Course course = new Course();
        course.setName("Новый курс");
        course.setType(CoursesType.BUSINESS);
        course.setTeacherId(1);
        session.save(course);*/

       /* //TODO Изменение данных
        Course course = session.get(Course.class, 47);
        course.setName("Совсем Новый Курс");
        session.save(course);*/

        /*//TODO Удаление данных
        Course course = session.get(Course.class, 47);
        session.delete(course);
*/

        transaction.commit();
        sessionFactory.close();
    }
}
