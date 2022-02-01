package com.zee.zee5.service;

import java.util.ArrayList;
import java.util.Optional;

import com.zee.zee5.dto.Subscription;

public interface SubscriptionService {

	public String addSubscription(Subscription subscription);
	public String deleteSubscription(String id);
	public String updateSubscription(String id, Subscription subscription);
	public Optional<Subscription> getSubscriptionById(String id);
	public Optional<ArrayList<Subscription>> getAllSubscription();

}
