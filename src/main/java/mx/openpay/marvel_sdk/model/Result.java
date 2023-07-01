package mx.openpay.marvel_sdk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;

@Setter
@Getter
@ToString
public class Result {
    public int id;
    public String name;
    public String description;
    public Date modified;
    public Thumbnail thumbnail;
    public String resourceURI;
    public Comics comics;
    public Series series;
    public Stories stories;
    public Events events;
    public List<Url> urls;
}
