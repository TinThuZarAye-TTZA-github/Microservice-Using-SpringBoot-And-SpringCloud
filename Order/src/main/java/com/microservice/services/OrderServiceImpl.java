package com.microservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.microservice.common.Payment;
import com.microservice.common.TransactionRequest;
import com.microservice.common.TransactionResponse;
import com.microservice.entities.Order;
import com.microservice.repositories.OrderRepository;

@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	OrderRepository repo;
	
	@Autowired
	RestTemplate template;


	@Override
	public List<Order> getAllOrder() {
		List<Order> order_list = repo.findAll();
		return order_list;
	}

	@Override
	public TransactionResponse doOrder(TransactionRequest request) {
		String message = "";
		Order order = request.getOrder();
		Payment payment = request.getPayment();
		payment.setOrderId(order.getOrder_id());
		payment.setAmount(order.getPrice());
		
		//REST API call
		//url from payment controller
		Payment paymentResponse = template
								.postForObject("http://localhost:8081/payment/add", payment, Payment.class);
		
		
		if(paymentResponse.getPaymentStatus().equals("success")) {
			message = "Payment Success";
		}else {
			message = "Payment not Success";
		}
		
		Order newOrder = repo.save(order);
		
		return new TransactionResponse(newOrder, paymentResponse.getAmount(),paymentResponse.getTransactionId(), message);
	}

}
