package com.customer.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long cutomerId;
	private String customerName;
	private long customerPhoneNo;
	
	private long selectedPlanId;
	
	private List<Long> selectedAddOnsIds;

	public Customer() {
		super();
	}

	public Customer(long cutomerId, String customerName, long customerPhoneNo, long selectedPlanId,
			List<Long> selectedAddOnsIds) {
		super();
		this.cutomerId = cutomerId;
		this.customerName = customerName;
		this.customerPhoneNo = customerPhoneNo;
		this.selectedPlanId = selectedPlanId;
		this.selectedAddOnsIds = selectedAddOnsIds;
	}

	public long getCutomerId() {
		return cutomerId;
	}

	public void setCutomerId(long cutomerId) {
		this.cutomerId = cutomerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public long getCustomerPhoneNo() {
		return customerPhoneNo;
	}

	public void setCustomerPhoneNo(long customerPhoneNo) {
		this.customerPhoneNo = customerPhoneNo;
	}

	public long getSelectedPlanId() {
		return selectedPlanId;
	}

	public void setSelectedPlanId(long selectedPlanId) {
		this.selectedPlanId = selectedPlanId;
	}

	public List<Long> getSelectedAddOnsIds() {
		return selectedAddOnsIds;
	}

	public void setSelectedAddOnsIds(List<Long> selectedAddOnsIds) {
		this.selectedAddOnsIds = selectedAddOnsIds;
	}

	@Override
	public String toString() {
		return "Customer [cutomerId=" + cutomerId + ", customerName=" + customerName + ", customerPhoneNo="
				+ customerPhoneNo + ", selectedPlanId=" + selectedPlanId + ", selectedAddOnsIds=" + selectedAddOnsIds
				+ "]";
	}

	
	

}
