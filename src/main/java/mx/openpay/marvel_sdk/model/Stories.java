package mx.openpay.marvel_sdk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Setter
@Getter
@ToString
public class Stories {
    public int available;
    public String collectionURI;
    public List<Item> items;
    public int returned;
}
