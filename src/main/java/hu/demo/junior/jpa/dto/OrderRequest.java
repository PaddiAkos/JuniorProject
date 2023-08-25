package hu.demo.junior.jpa.dto;


import hu.demo.junior.jpa.model.Cuser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderRequest {

    private Cuser user;


}
