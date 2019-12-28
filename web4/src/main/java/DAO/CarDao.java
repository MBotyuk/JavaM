package DAO;

import model.Car;
import model.DailyReport;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class CarDao {

    private Session session;

    public CarDao(Session session) {
        this.session = session;
    }

    public List<Car> getAllCar() {
        Transaction transaction = session.beginTransaction();
        List<Car> cars = session.createQuery("FROM Car").list();
        transaction.commit();
        session.close();
        return cars;
    }

    public List<Car> getAllCarOfBrand(String brand) {
        Transaction transaction = session.beginTransaction();
        List<Car> cars = session.createQuery("FROM Car where brand = '" + brand + "'").list();
        transaction.commit();
        session.close();
        return cars;
    }

    public void addCar(Car car) {
        Transaction transaction = session.beginTransaction();
        session.save(car);
        transaction.commit();
        session.close();
    }

    public void delCar(Car car) {
        Transaction transaction = session.beginTransaction();
        session.delete(car);
        transaction.commit();
        session.close();
    }

    public int count(String brand) {
        Transaction transaction = session.beginTransaction();
        int result = session.createQuery("FROM Car where brand = '" + brand + "'").list().size() + 1;
        transaction.commit();
        session.close();
        return result;
    }

    public void refresh() {
        Transaction transaction = session.beginTransaction();
        session.clear();
        transaction.commit();
        session.close();
    }

}
