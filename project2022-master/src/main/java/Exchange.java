import persistence.dao.*;
import persistence.dto.ExchangeDTO;
import persistence.mapper.SwedenMapper;

import java.io.DataOutputStream;
import java.io.IOException;

public class Exchange {
    private DataOutputStream dos;
    public Exchange(DataOutputStream dos){
        this.dos = dos;
    }

    public void run(int code,byte[] data){
        switch (code){
            case 1 :
                exchangeMoney(data);
                break;
            case 2 :
                break;
            case 3 :
                break;
        }
    }

    public void exchangeMoney(byte[] data) {
        try {
            ExchangeDTO exchangeDTO = (ExchangeDTO) Protocol.convertBytesToObject(data);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}