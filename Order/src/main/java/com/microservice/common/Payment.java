package com.microservice.common;

public class Payment {
 
	int payment_id;
	String paymentStatus;
	String transactionId;
	int orderId;
	int amount;
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Payment(int payment_id, String paymentStatus, String transactionId, int orderId, int amount) {
//		super();
		this.payment_id = payment_id;
		this.paymentStatus = paymentStatus;
		this.transactionId = transactionId;
		this.orderId = orderId;
		this.amount = amount;
	}
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
//	@Override
//	public String toString() {
//		return "Payment [payment_id=" + payment_id + ", paymentStatus=" + paymentStatus + ", transactionId="
//				+ transactionId + ", orderId=" + orderId + ", amount=" + amount + "]";
//	}
//	
//	
	
}
