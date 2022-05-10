import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import persistence.mapper.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

public class MyBatisConnectionFactory {
    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            String resource = "config/config.xml";
            Reader reader = Resources.getResourceAsReader(resource);
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader,"development");
            }
            Class[] mappers ={
                    AmericaMapper.class,
                    JapanMapper.class,
                    KoreaMapper.class,
                    YuanMapper.class
            };
            for(Class mapper:mappers){
                sqlSessionFactory.getConfiguration().addMapper(mapper);
            }
            System.out.println("연결완료");
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            System.out.println("---------------" + iOException.toString());
            iOException.printStackTrace();
        }
        catch (Exception iOException) {
            System.out.println("---------------" + iOException.toString());
            iOException.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
}