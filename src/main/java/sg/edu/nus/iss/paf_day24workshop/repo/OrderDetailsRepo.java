package sg.edu.nus.iss.paf_day24workshop.repo;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import sg.edu.nus.iss.paf_day24workshop.model.OrderDetails;

@Repository
public class OrderDetailsRepo {
    
    @Autowired
    JdbcTemplate jdbc;

    private final String insertSQL = "insert into order_details (product, unit_price, discount, quantity, order_id) values (?, ?, ?, ?, ?)";

    public int[] add(List<OrderDetails> orderDetails){
        // day 22 slide 17
        List<Object[]> params = orderDetails.stream().map(od -> new Object[]{od.getProduct(),od.getUnitPrice(),od.getDiscount(),
        od.getQuantity(), od.getOrderId()}).collect(Collectors.toList());
        int added[] = jdbc.batchUpdate(insertSQL, params);

        return added;
    }

}
