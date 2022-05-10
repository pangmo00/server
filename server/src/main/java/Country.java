import lombok.Getter;
import org.apache.ibatis.session.SqlSessionFactory;
import persistence.dao.*;
public class Country {

    private AmericaDAO americaDAO;
    private JapanDAO japanDAO;

    private DAO[] daos = {americaDAO, japanDAO};


    public  DAO getDAO(int num){
        return daos[num];
    }






}
