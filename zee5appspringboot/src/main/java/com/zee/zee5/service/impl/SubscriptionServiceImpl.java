package com.zee.zee5.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Subscription;
import com.zee.zee5.repository.SubscriptionRepository;
import com.zee.zee5.repository.impl.SubscriptionRepositoryImpl;
import com.zee.zee5.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	SubscriptionRepository service;
	
	public SubscriptionServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		return service.addSubscription(subscription);
	}

	@Override
	public String deleteSubscription(String id) {
		// TODO Auto-generated method stub
		return service.deleteSubscription(id);
	}

	@Override
	public String updateSubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return service.updateSubscription(id, subscription);
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return service.getSubscriptionById(id);
	}

	@Override
	public Optional<ArrayList<Subscription>> getAllSubscription() {
		// TODO Auto-generated method stub
		return service.getAllSubscription();
	}

}
