package com.zee.zee5.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Movie;
import com.zee.zee5.dto.Subscription;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.repository.SubscriptionRepository;
import com.zee.zee5.service.SubscriptionService;

@Service
public class SubscriptionServiceImpl implements SubscriptionService {

	@Autowired
	private SubscriptionRepository subservice;
	
	public SubscriptionServiceImpl() throws IOException{
		// TODO Auto-generated constructor stub
	}

	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		Subscription subscription2=subservice.save(subscription);
		if(subscription2==null)
			return "fail";
		return "success";
	}

	@Override
	public String deleteSubscription(String id) throws IdNotFound {
		// TODO Auto-generated method stub
		try {
			Optional<Subscription> optional = this.getSubscriptionById(id);
			if(optional.isEmpty()) {
				throw new IdNotFound("record not found");
			}
			else {
				subservice.deleteById(id);
			return "delete successful";}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFound(e.getMessage());
		}

	}

	@Override
	public String updateSubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Optional<Subscription> getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		return subservice.findById(id);
	}

	@Override
	public Optional<List<Subscription>> getAllSubscription() {
		// TODO Auto-generated method stub
		return Optional.ofNullable(subservice.findAll());
	}
	
	
//	@Override
//	public String addSubscription(Subscription subscription) {
//		// TODO Auto-generated method stub
//		return service.addSubscription(subscription);
//	}
//
//	@Override
//	public String deleteSubscription(String id) {
//		// TODO Auto-generated method stub
//		return service.deleteSubscription(id);
//	}
//
//	@Override
//	public String updateSubscription(String id, Subscription subscription) {
//		// TODO Auto-generated method stub
//		return service.updateSubscription(id, subscription);
//	}
//
//	@Override
//	public Optional<Subscription> getSubscriptionById(String id) {
//		// TODO Auto-generated method stub
//		return service.getSubscriptionById(id);
//	}
//
//	@Override
//	public Optional<ArrayList<Subscription>> getAllSubscription() {
//		// TODO Auto-generated method stub
//		return service.getAllSubscription();
//	}

}
