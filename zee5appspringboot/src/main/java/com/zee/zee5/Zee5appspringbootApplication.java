package com.zee.zee5;

import java.math.BigDecimal;
import java.sql.Date;
import java.text.DecimalFormat;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityProperties.User;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5.dto.Movie;
import com.zee.zee5.dto.Register;
import com.zee.zee5.dto.Series;
import com.zee.zee5.dto.Subscription;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidAmountException;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;
import com.zee.zee5.repository.UserRepository;
import com.zee.zee5.service.MovieService;
import com.zee.zee5.service.SeriesService;
import com.zee.zee5.service.SubscriptionService;
import com.zee.zee5.service.UserService;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=
				SpringApplication.run(Zee5appspringbootApplication.class, args);
		
		DataSource dataSource=applicationContext.getBean(DataSource.class);
	//	System.out.println(dataSource!=null);
		
		
		
		UserService service = applicationContext.getBean(UserService.class);
		
		
		try {
			Register register=new Register();
			register.setId("harish4");
			register.setFirstName("harish");
			register.setLastName("y");
			register.setPassword("1234");
			register.setEmail("harish4@gmail.com");
			
			System.out.println(service.addUser(register));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
//		
//		try {
//			Optional<Register> register2=service.getUserById("pavan1");
//			System.out.println(register2);
//		} catch (IdNotFound e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		try {
//			Optional<List<Register>> register3 =service.getAllRegisters();
//			if(register3.isEmpty())
//			{
//				System.out.println("No records");
//			}
//			else
//			{
//				register3.get().forEach(e->System.out.println(e));
//	
//			}
//		} catch (InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			Register[] register3 =service.getAllUsers();
//			if(register3==null)
//			{
//				System.out.println("No records");
//			}
//			else
//			{
//				for (Register register2 : register3) {
//					System.out.println(register2);
//				}
//			}
//		} catch (InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		try {
//			String res=service.deleteUserById("pavan9");
//			System.out.println(res);
//		} catch (IdNotFound e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidNameException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (InvalidIdLengthException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		
//-----------------------movie----------------------------------//
		
//		
//		MovieService movieService=applicationContext.getBean(MovieService.class);
//		
//		try {
//			Movie movie=new Movie();
//			movie.setId("movie1");
//			movie.setAgelimit(10);
//			movie.setCast("MM,NN");
//			movie.setGenere("Action");
//			movie.setLanguage("English");
//			movie.setLength(new BigDecimal(123456789));
//			movie.setMovieName("1mavie");
//			movie.setReleasedate(new Date(12-01-2022));
//			movie.setTrailer("url.link");
//			System.out.println("yes");
//
//			System.out.println(movieService.addMovie(movie));
//			
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		try {
//			System.out.println(movieService.getMovieById("movie1"));
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("id not found");
//		}
//		
//		
//		try {
//			Optional<List<Movie>> optional=movieService.getAllMovies();
//			if(optional.isEmpty())
//			{
//				System.out.println("No records");
//			}
//			else
//			{
//				optional.get().forEach(e->System.out.println(e));
//	
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		
//		try {
//			System.out.println(movieService.deleteMovieById("movie1"));
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
			
		
		
//----------------------------series------------------------------//
		
//		SeriesService seriesService = applicationContext.getBean(SeriesService.class);
//	
//		try {
//			Series series=new Series();
//			series.setAgelimit(10);
//			series.setCast("NN,MM");
//			series.setGenere("Action");
//			series.setLanguage("English");
//			series.setNoOfEpisodes(20);
//			series.setReleasedate(new Date(01-01-2022));
//			series.setSeriesName("series1");
//			series.setTrailer("trailer");
//			System.out.println(seriesService.addSeries(series));
//			System.out.println("yes");
//
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		try {
//			System.out.println(seriesService.getSeriesById("series1"));
//		} catch (Exception e) {
//			// TODO: handle exception
//			System.out.println("id not found");
//		}
//		
//		
//		try {
//			Optional<List<Series>> optional=seriesService.getAllSeries();
//			if(optional.isEmpty())
//			{
//				System.out.println("No records");
//			}
//			else
//			{
//				optional.get().forEach(e->System.out.println(e));
//	
//			}
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
//		
//		
//		try {
//			System.out.println(seriesService.deleteSeriesById("series1"));
//		} catch (Exception e) {
//			// TODO: handle exception
//		}
		
	
//-------------------subscription----------------------------//
		
		SubscriptionService subscriptionService =applicationContext.getBean(SubscriptionService.class);
		
		
		try {
			Subscription subscription=new Subscription();
			subscription.setAmount(1000);
			subscription.setAutoRenewal("Yes");
			subscription.setDateofPurchase(new Date(01-01-2022));
			subscription.setExpiryDate(new Date(01-07-2022));
			try {
				subscription.setregId("harish4");
			} catch (InvalidIdLengthException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			subscription.setStatus("active");
			subscription.setSubscriptionid("sub4");
			subscription.setType("quaterly");
			subscription.setPaymentMode("UPI");
			
			System.out.println(subscriptionService.addSubscription(subscription));
			
		} catch (InvalidAmountException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			System.out.println(subscriptionService.getSubscriptionById("sub1"));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("id not found");
		}
		
		
		try {
			Optional<List<Subscription>> optional=subscriptionService.getAllSubscription();
			if(optional.isEmpty())
			{
				System.out.println("No records");
			}
			else
			{
				optional.get().forEach(e->System.out.println(e));
	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		try {
			System.out.println(subscriptionService.deleteSubscription("sub1"));
		} catch (Exception e) {
			// TODO: handle exception
		}
				
		applicationContext.close();
	}

}
