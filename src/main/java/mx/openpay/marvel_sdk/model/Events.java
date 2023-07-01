package mx.openpay.marvel_sdk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Setter
@Getter
@ToString
public class Events {
    public int available;
    public String collectionURI;
    public List<Object> items;
    public int returned;
}
