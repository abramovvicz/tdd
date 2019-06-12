package day2.cars;

public class CarService {
    public String getCar(int carId) {
        CarDAO carDao = new CarDAOImp();
        Car car = carDao.getCar(carId);
        return String.format("Samochód %d ma nazwę %s i kolor %s", car.getId(), car.getName(), car.getColor());
    }
}
