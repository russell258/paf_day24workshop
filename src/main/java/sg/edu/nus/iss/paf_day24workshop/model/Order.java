package sg.edu.nus.iss.paf_day24workshop.model;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private Long orderId;
    private Date orderDate;
    private String customerName;
    private String shippingAddress;
    private String notes;
    private Float tax;
}
