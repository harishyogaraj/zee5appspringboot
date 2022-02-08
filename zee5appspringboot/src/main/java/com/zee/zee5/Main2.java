package com.zee.zee5;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5.dto.EROLE;
import com.zee.zee5.dto.Episode;
import com.zee.zee5.dto.Movie;
import com.zee.zee5.dto.Register;
import com.zee.zee5.dto.Role;
import com.zee.zee5.dto.Series;
import com.zee.zee5.dto.Subscription;
import com.zee.zee5.exeption.AlreadyExistsException;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidAmountException;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.repository.MovieRepository;
import com.zee.zee5.repository.RoleRepository;
import com.zee.zee5.service.EpisodeService;
import com.zee.zee5.service.MovieService;
import com.zee.zee5.service.RoleService;
import com.zee.zee5.service.SeriesService;
import com.zee.zee5.service.SubscriptionService;
import com.zee.zee5.service.UserService;

@SpringBootApplication
public class Main2 {

	public static void main(String[] args) throws AlreadyExistsException, IdNotFound {
		// TODO Auto-generated method stub
		ConfigurableApplicationContext applicationContext=
				SpringApplication.run(Zee5appspringbootApplication.class, args);
		
		
		
		
//		SeriesService seriesService=applicationContext.getBean(SeriesService.class);
//		EpisodeService episodeService=applicationContext.getBean(EpisodeService.class);
//		
//		Series series1=new Series();
//		Series series2=new Series();
//		
//		series1.setSeriesid("series1");
//		series1.setAgelimit(10);
//		series1.setCast("NN,MM");
//		series1.setGenere("Action");
//		series1.setLanguage("English");
//		series1.setNoOfEpisodes(20);
//		series1.setReleasedate( new Date(01-01-2022));
//		series1.setSeriesName("series1");
//		series1.setTrailer("trailer");
//		
//		series2.setSeriesid("series2");
//		series2.setAgelimit(10);
//		series2.setCast("NN,MM");
//		series2.setGenere("Action");
//		series2.setLanguage("English");
//		series2.setNoOfEpisodes(20);
//		series2.setReleasedate( new Date(01-01-2022));
//		series2.setSeriesName("series2");
//		series2.setTrailer("trailer");
//		
//		System.out.println(seriesService.addSeries(series1));
//		System.out.println(seriesService.addSeries(series2));
//		
//		Episode episode =new Episode();
//		episode.setEpiId("epi-01");
//		episode.setEpisodeName("episode1");
//		episode.setLength(120);
//		episode.setLocation("drive");
//		episode.setSeries(series2);
//				
//		FileInputStream fileInputStream=null;
//		FileOutputStream fileOutputStream=null;
//		try {
//			fileInputStream= new FileInputStream("C:\\series\\tom.mp4");
//			File file=new File("C:\\series\\tom.mp4");
//			long fileSize=file.length();
//			byte[] allBytes = new byte[(int) fileSize];
//			
//			//fileInputStream.read(allBytes);
//			episode.setTrailer("C:\\series\\seriesStore\\"+file.getName());
//			
//			String res= episodeService.addEpisode(episode);
//			if(res.equals("success"))
//			{
//				 fileOutputStream = new FileOutputStream("C:\\series\\seriesStore\\"+file.getName());
//		    	   
//		    	   byte[] data = new byte[(int) file.length()];
//		    	   
//		    	   fileInputStream.read(data);
//		    	   fileOutputStream.write(data);
//			}
//			
//
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		finally {
//			try {
//				fileInputStream.close();
//				fileOutputStream.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		}	
//
//		
//	//	File file=new File("C:\\series\\tom.mp4");
//		
////		MovieService movieService=applicationContext.getBean(MovieService.class);
////		Movie movie=new Movie();
////		movie.setId("movie4");
////		movie.setAgelimit(10);
////		movie.setCast("MM,NN");
////		movie.setGenere("Action");
////		movie.setLanguage("English");
////		movie.setLength(new BigDecimal(123456789));
////		movie.setMovieName("mavie4");
////		movie.setReleasedate(new Date(12-01-2022));
////		FileInputStream fileInputStream=null;
////		FileOutputStream fileOutputStream=null;
////		try {
////			fileInputStream= new FileInputStream("C:\\movies\\tom.mp4");
////			File file=new File("C:\\movies\\tom.mp4");
////			long fileSize=file.length();
////			byte[] allBytes = new byte[(int) fileSize];
////			
////			//fileInputStream.read(allBytes);
////			movie.setTrailer("C:\\movies\\movieStore\\"+file.getName());
////			
////			String res= movieService.addMovie(movie);
////			if(res.equals("success"))
////			{
////				 fileOutputStream = new FileOutputStream("C:\\movies\\movieStore\\"+file.getName());
////		    	   
////		    	   byte[] data = new byte[(int) file.length()];
////		    	   
////		    	   fileInputStream.read(data);
////		    	   fileOutputStream.write(data);
////			}
////			
////
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		finally {
////			try {
////				fileInputStream.close();
////				fileOutputStream.close();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}	
//	
//		
//		
//		
////		FileOutputStream fileOutputStream=null;
////		try {
////			Optional<Movie> optional=movieService.getMovieById("movie4");
////			if(optional.isEmpty())
////			{
////				System.out.println("record not found");
////			}
////			else
////			{
////				Movie movie=optional.get();
////				
////				fileOutputStream=new FileOutputStream("C:\\movies\\read\\tom.mp4");
////				fileOutputStream.write(movie.getTrailer());
////			}
////		} catch (IdNotFound | IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		finally {
////			try {
////				fileOutputStream.close();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
//		
//		
//		
////		Movie movie=new Movie();
////		movie.setId("movie4");
////		movie.setAgelimit(10);
////		movie.setCast("MM,NN");
////		movie.setGenere("Action");
////		movie.setLanguage("English");
////		movie.setLength(new BigDecimal(123456789));
////		movie.setMovieName("mavie4");
////		movie.setReleasedate(new Date(12-01-2022));
////		FileInputStream fileInputStream=null;
////		try {
////			fileInputStream= new FileInputStream("C:\\movies\\tom.mp4");
////			long fileSize=new File("C:\\movies\\tom.mp4").length();
////			byte[] allBytes = new byte[(int) fileSize];
////			
////			fileInputStream.read(allBytes);
////			movie.setTrailer(allBytes);
////			
////			System.out.println(movieService.addMovie(movie));
////
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		finally {
////			try {
////				fileInputStream.close();
////			} catch (IOException e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////		}
//	
//		//---------------------------------------//
//		
////	SubscriptionService subscriptionService =applicationContext.getBean(SubscriptionService.class);	
////	UserService service = applicationContext.getBean(UserService.class);
////		
////	Register register=new Register();
////		try {
////			register.setId("harish7");
////			register.setFirstName("harish");
////			register.setLastName("y");
////			register.setPassword("1234");
////			register.setEmail("harish7@gmail.com");
////			
////			System.out.println(service.addUser(register));
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////		
////		
////			Subscription subscription=new Subscription();
////			
////			subscription.setAmount(1000);
////			subscription.setAutoRenewal("Yes");
////			subscription.setDateofPurchase(new Date(01-01-2022));
////			subscription.setExpiryDate(new Date(01-07-2022));
////			try {
////	//			subscription.setRegid("harish7");
////				subscription.setRegister(register);
////			} catch (Exception e) {
////				// TODO Auto-generated catch block
////				e.printStackTrace();
////			}
////			subscription.setStatus("active");
////			subscription.setSubscriptionid("sub4");
////			subscription.setType("quaterly");
////			subscription.setPaymentMode("UPI");
////			
////			System.out.println(subscriptionService.addSubscription(subscription));
//			
////			try {
////			String res=service.deleteUserById("harish7");
////			System.out.println(res);
////		} catch (Exception e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		} 
//		
//		
////		SeriesService seriesService=applicationContext.getBean(SeriesService.class);
////		EpisodeService episodeService=applicationContext.getBean(EpisodeService.class);
////		
////		Series series1=new Series();
////		Series series2=new Series();
////		
////		series1.setSeriesid("series1");
////		series1.setAgelimit(10);
////		series1.setCast("NN,MM");
////		series1.setGenere("Action");
////		series1.setLanguage("English");
////		series1.setNoOfEpisodes(20);
////		series1.setReleasedate( new Date(01-01-2022));
////		series1.setSeriesName("series1");
////		series1.setTrailer("trailer");
////		
////		series2.setSeriesid("series2");
////		series2.setAgelimit(10);
////		series2.setCast("NN,MM");
////		series2.setGenere("Action");
////		series2.setLanguage("English");
////		series2.setNoOfEpisodes(20);
////		series2.setReleasedate( new Date(01-01-2022));
////		series2.setSeriesName("series2");
////		series2.setTrailer("trailer");
////		
////		System.out.println(seriesService.addSeries(series1));
////		System.out.println(seriesService.addSeries(series2));
////		
////		Episode episode =new Episode();
////		episode.setEpiId("epi-01");
////		episode.setEpisodeName("episode1");
////		episode.setLength(120);
////		episode.setLocation("drive");
////		episode.setSeries(series2);
////		episode.setTrailer("youtube");
////		try {
////			episodeService.addEpisode(episode);
////		} catch (IdNotFound e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
//		
////			Role role =new Role();
////			role.setRoleName(EROLE.ROLE_ADMIN);
////			
////			Role role2 =new Role();
////			role2.setRoleName(EROLE.ROLE_USER);
////			
////			RoleRepository roleRepository=applicationContext.getBean(RoleRepository.class);
////			RoleService roleService=applicationContext.getBean(RoleService.class);
////			System.out.println(roleService.addRole(role));
////			System.out.println(roleService.addRole(role2));
////		
////		UserService service=applicationContext.getBean(UserService.class);
////		Register register=new Register();
////		register.setId("harish8");
////		register.setFirstName("harish");
////		register.setLastName("y");
////		register.setPassword("1234");
////		register.setEmail("harish8@gmail.com");
////		Set<Role> roles=new HashSet<>();
////	
////		roles.add(roleRepository.findById(1).get());
////		roles.add(roleRepository.findById(2).get());
////		register.setRoles(roles);
////		System.out.println(service.addUser(register));
//		
//		
//
//		
//	//	UserRepository repository=applicationContext.getBean(UserRepository.class);
//	//	System.out.println(repository.existsByEmailAndContactNumber("harish4@gmail.com",new BigDecimal(123456789)));
//	//	System.out.println(repository.existsByContactNumber(new BigDecimal(123456789)));
//		
//		
////		MovieRepository repository=applicationContext.getBean(MovieRepository.class);
////		System.out.println(repository.existsByMovieName("mavie1"));
////		System.out.println(repository.findByMovieNameAndLanguage("mavie1", "English"));
////		
////		System.out.println(repository.findByMovieNameAndReleasedate("mavie1", new Date(1970-01-01)));
////		
////		 System.out.println(repository.findByCast("MM,NN"));
//		
//		 
//
//		
////		SeriesRepository seriesService=applicationContext.getBean(SeriesRepository.class);
////		System.out.println(seriesService.findBySeriesNameAndLanguage("series1", "English"));
//		
//		applicationContext.close();
	}
}
