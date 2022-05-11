import persistence.dao.DAO;
import persistence.dto.BkprDTO;
import persistence.dto.BkprFormedDTO;
import persistence.dto.GrafDTO;
import persistence.dto.GrafRequestDTO;

import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Graf {
    private DataOutputStream dos;
    public Graf(DataOutputStream dos){
        this.dos = dos;
    }
    public void run(int code,byte[] data){
        switch (code){
            case 1 :
                break;
            case 2 :
                break;
            case 3 :
                break;
        }
    }

    public void grafYear(byte[] data){
        Date date_now = new Date(System.currentTimeMillis());
        SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyyMMdd");

        try {
            GrafRequestDTO grafRequestDTO = (GrafRequestDTO) Protocol.convertBytesToObject(data);
            DAO dao = new DAO(MyBatisConnectionFactory.getSqlSessionFactory(),grafRequestDTO.getCountry());
            ArrayList<BkprDTO> list = dao.selectBkpr(grafRequestDTO.getDate(),fourteen_format.format(date_now));
            ArrayList<BkprFormedDTO> formedList = new ArrayList<>();
            for(int i=0;i<list.size();i++){
                formedList.add(new BkprFormedDTO(list.get(i)));
            }
            GrafDTO grafDTO = new GrafDTO();
            int startYear = formedList.get(0).getYear();
            int count = 0;
            int sum = 0;
            for(int i=0;i<formedList.size();i++){

                if(formedList.get(i).getYear()!= startYear){
                    grafDTO.getArr().add(startYear,new Integer(sum/count));
                    count = 0;
                    sum = 0;
                }
                sum+= formedList.get(i).getBkpr();
                count++;
            }
            byte[] bytes = Protocol.convertObjectToBytes(1,2,(Object) grafDTO);
            dos.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void grafMonth(byte[] data){
        try {
            GrafRequestDTO grafDTO = (GrafRequestDTO) Protocol.convertBytesToObject(data);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

}
