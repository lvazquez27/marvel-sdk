package mx.openpay.marvel_sdk.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
public class ApiResponse {
    public int code;
    public String status;
    public String copyright;
    public String attributionText;
    public String attributionHTML;
    public String etag;
    public Data data;
}
