package mx.openpay.marvel_sdk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Setter
@Getter
@ToString
public class Data {
    public int offset;
    public int limit;
    public int total;
    public int count;
    public List<Result> results;
}
