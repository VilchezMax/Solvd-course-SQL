package db.services;

import db.models.Entities;
import db.models.Worker;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ServiceFactory {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        ICrudServices<Worker> service = ServiceFactory.getService("mysql", Entities.WORKER.getClassValue());
        System.out.println(Entities.WORKER.getClassValue().getSimpleName());

    }
    //FACTORY METHOD PATTERN FOR MYSQL OR MYBATIS SERVICES


    public static <T> ICrudServices<T> getService(String dataSourceSubstitute, Class<?> clazz) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        /*
         * Uses VM argument to choose data source for service layer.
         * If not found, uses method argument for data source
         */

        String dataSource = System.getProperty("datasource");

        if (dataSource == null) {
            dataSource = dataSourceSubstitute;
        }
        Constructor serviceConstructor =
                Class.forName("db.services." + dataSource + "." + clazz.getSimpleName() + "Service")
                        .getDeclaredConstructor();

        ICrudServices<T> service = (ICrudServices<T>) serviceConstructor.newInstance();

        return service;
    }
}
