package mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MySessionFactory {
    private static MySessionFactory instance;
    private static SqlSessionFactory factory;

    private MySessionFactory() {
        String config = "mybatis-config.xml";
        Reader configReader = null;
        try {
            configReader = Resources.getResourceAsReader(config);
            factory = new SqlSessionFactoryBuilder().build(configReader);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static MySessionFactory getInstance() {
        if (instance == null) {
            instance = new MySessionFactory();
        }
        return instance;
    }

    public SqlSessionFactory getFactory() {
        return factory;
    }
//    public static void main(String[] args) throws IOException {
//        String resource = "src/main/resources/mybatis/mybatis-config.xml";
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        MySQLSessionFactory sqlSessionFactory =
//                (MySQLSessionFactory) new SqlSessionFactoryBuilder().build(inputStream);
//    }

}
