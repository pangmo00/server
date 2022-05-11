package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BkprFormedDTO {
    private int bkpr;
    private int year;
    private int month;
    private int day;

    public BkprFormedDTO(String bkprStr, String dateStr) {
        this.bkpr = Integer.parseInt(bkprStr);
        String yearStr = dateStr.substring(0,4);
        String monthStr = dateStr.substring(4,6);
        String dayStr = dateStr.substring(6);
        this.year = Integer.parseInt(yearStr);
        this.month = Integer.parseInt(monthStr);
        this.day = Integer.parseInt(dayStr);
    }

    public BkprFormedDTO(BkprDTO bkprDTO) {
        this.bkpr = Integer.parseInt(bkprDTO.getBkpr());
        String dateStr = bkprDTO.getDate();
        String yearStr = dateStr.substring(0,4);
        String monthStr = dateStr.substring(4,6);
        String dayStr = dateStr.substring(6);
        this.year = Integer.parseInt(yearStr);
        this.month = Integer.parseInt(monthStr);
        this.day = Integer.parseInt(dayStr);
    }
}
