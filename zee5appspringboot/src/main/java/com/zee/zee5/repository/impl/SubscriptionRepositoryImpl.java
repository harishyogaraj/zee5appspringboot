package com.zee.zee5.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5.dto.Subscription;
import com.zee.zee5.repository.SubscriptionRepository;

@Repository
public class SubscriptionRepositoryImpl implements SubscriptionRepository {

	@Autowired
	DataSource dataSource;
	
	ArrayList<Subscription> subscriptions=new ArrayList<>();
	
	public SubscriptionRepositoryImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String addSubscription(Subscription subscription) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		String addStatement="insert into subscription(subscriptionid,dop,expiry,"
				+ "amount,paymentmode,status,type,autorenewal,regid) values("
				+ "?,?,?,?,?,?,?,?,?)";
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement=connection.prepareStatement(addStatement);
			preparedStatement.setString(1, subscription.getSubscriptionid());
			preparedStatement.setString(2, subscription.getDateofPurchase());
			preparedStatement.setString(3, subscription.getExpiryDate());
			preparedStatement.setInt(4, subscription.getAmount());
			preparedStatement.setString(5, subscription.getPaymentMode());
			preparedStatement.setString(6, subscription.getStatus());
			preparedStatement.setString(7, subscription.getType());
			preparedStatement.setString(8, subscription.getAutoRenewal());
			preparedStatement.setString(9, subscription.getRegid());
			
			int result=preparedStatement.executeUpdate();
			
			if(result>0)
			{
				connection.commit();
				return "success";
			}
			else
			{
				connection.rollback();
				return "fail";
			}

		} catch (Exception e) {
			// TODO: handle exception
			try {
				connection.commit();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
		
	}
	@Override
	public String deleteSubscription(String id) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		String deleteStatement="delete from subscription where subscriptionid=?";
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			preparedStatement=connection.prepareStatement(deleteStatement);
			preparedStatement.setString(1, id);
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				connection.commit();
				return "success";
			}
			else
			{
				connection.rollback();
				return "fail";
			}
		} catch (Exception e) {
			// TODO: handle exception
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
		
	}
	@Override
	public String updateSubscription(String id, Subscription subscription) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		String statement="update subscription set autorenewal=? where subscriptionid=?";
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement=connection.prepareStatement(statement);
			preparedStatement.setString(1, subscription.getAutoRenewal());
			preparedStatement.setString(2, id);
			int result=preparedStatement.executeUpdate();
			if(result>0)
			{
				connection.commit();
				return "success";
			}
			else
			{
				connection.rollback();
				return "fail";
			}
		} catch (Exception e) {
			// TODO: handle exception
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return "fail";
		}
			}
	@Override
	public Optional<Subscription> getSubscriptionById(String id) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		ResultSet resultSet=null;
		String statement="select * from subscription where subscriptionid=?";
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement=connection.prepareStatement(statement);
			preparedStatement.setString(1, id);
			resultSet=preparedStatement.executeQuery();
			if(resultSet.next())
			{
				Subscription subscription=new Subscription();
				subscription.setType(resultSet.getString("type"));
				subscription.setAmount(resultSet.getInt("amount"));
				subscription.setAutoRenewal(resultSet.getString("autorenewal"));
				subscription.setDateofPurchase(resultSet.getString("dop"));
				subscription.setExpiryDate(resultSet.getString("expiry"));
				subscription.setregId(resultSet.getString("regid"));
				subscription.setPaymentMode(resultSet.getString("paymentmode"));
				subscription.setStatus(resultSet.getString("status"));
				subscription.setSubscriptionid(resultSet.getString("subscriptionid"));
				return Optional.ofNullable(subscription);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("id not found!");
		}
				return Optional.empty();
	}
	@Override
	public Optional<ArrayList<Subscription>> getAllSubscription() {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		ArrayList<Subscription> arrayList =new ArrayList<>();
		ResultSet resultSet=null;
		String statement="select * from subscription";
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement=connection.prepareStatement(statement);
			resultSet=preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Subscription subscription=new Subscription();
				subscription.setType(resultSet.getString("type"));
				subscription.setAmount(resultSet.getInt("amount"));
				subscription.setAutoRenewal(resultSet.getString("autorenewal"));
				subscription.setDateofPurchase(resultSet.getString("dop"));
				subscription.setExpiryDate(resultSet.getString("expiry"));
				subscription.setregId(resultSet.getString("regid"));
				subscription.setPaymentMode(resultSet.getString("paymentmode"));
				subscription.setStatus(resultSet.getString("status"));
				subscription.setSubscriptionid(resultSet.getString("subscriptionid"));
				arrayList.add(subscription);
			}
			return Optional.ofNullable(arrayList);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return Optional.empty();
		
	}
	
}
	
//	@Override
//	public String addSubscription(Subscription subscription) {
//		// TODO Auto-generated method stub
//		boolean res=subscriptions.add(subscription);
//		if(res)
//			return "success";
//		else
//			return "fail";
//	}
//
//	@Override
//	public String deleteSubscription(String id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public String updateSubscription(String id, Subscription subscription) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public Subscription getSubscriptionById(String regid) {
//		// TODO Auto-generated method stub
//		for (Subscription subscription : subscriptions) {
//			if(subscription.getRegid().equals(regid))
//			{
//				return subscription;
//			}
//		}
//		return null;
//	}
//
//	@Override
//	public ArrayList<Subscription> getAllSubscription() {
//		// TODO Auto-generated method stub
//		return subscriptions;
//	}
//
//	
//}
