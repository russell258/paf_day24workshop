package sg.edu.nus.iss.paf_day24workshop.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sg.edu.nus.iss.paf_day24workshop.model.Order;
import sg.edu.nus.iss.paf_day24workshop.model.OrderDetails;
import sg.edu.nus.iss.paf_day24workshop.repo.OrderDetailsRepo;
import sg.edu.nus.iss.paf_day24workshop.repo.OrderRepo;

@Service
public class OrderService {
    @Autowired
    OrderRepo ordRepo;

    @Autowired
    OrderDetailsRepo ordDetailsRepo;

    public Boolean makeOrder(Order order, List<OrderDetails> details){
        //use the insertOrder so it will return the primary key, which will be used to set foreign key for the 2nd table, order details
        Integer iCreatedOrderId = ordRepo.insertOrder(order);

        //set the fk for the order details linked to the created order
        for (OrderDetails od: details){
            od.setOrderId(iCreatedOrderId);
        }
        // create the order details

        ordDetailsRepo.add(details);

        return false;
    }
}
