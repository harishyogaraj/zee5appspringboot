package com.zee.zee5.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.zee.zee5.dto.Subscription;
import com.zee.zee5.exeption.IdNotFound;

@Service
public interface SubscriptionService {

	public String addSubscription(Subscription subscription);
	public String deleteSubscription(String id) throws IdNotFound;
	public String updateSubscription(String id, Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id);
	public Optional<List<Subscription>> getAllSubscription();

}
