import persistence.dao.*;
import persistence.dto.ExchangeDTO;

import java.io.IOException;

public class Exchange  {
//1~n 나라 코드 정하기
    private Country country = new Country();




    public void run(int code,byte[] data){
        
    }

    public void exchangeMoney(byte[] data) throws IOException, ClassNotFoundException {
        ExchangeDTO exchange = (ExchangeDTO)Protocol.convertBytesToObject(data);
        DAO dao = country.getDAO(exchange.getCountry1());
        dao.insert();

    }
    



}
