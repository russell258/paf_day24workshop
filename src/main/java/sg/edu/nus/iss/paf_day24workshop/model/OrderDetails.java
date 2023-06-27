package sg.edu.nus.iss.paf_day24workshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetails {
    private Integer orderId;

    private String product;

    private Float unitPrice;

    private Float discount;

    private Integer quantity;
}
