package persistence.dto;

import java.util.ArrayList;
import java.util.Map;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class GrafDTO implements Serializable {
    ArrayList<Map<String,Integer>> arr = new ArrayList<>();

}
