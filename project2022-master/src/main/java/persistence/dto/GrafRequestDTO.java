package persistence.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class GrafRequestDTO implements Serializable {
    private int country;
    private String date;
}
