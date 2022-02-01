package com.zee.zee5.repository.impl;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.mysql.cj.xdevapi.Result;
import com.zee.zee5.dto.Movie;
import com.zee.zee5.dto.Register;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.exeption.InvalidIdLengthException;
import com.zee.zee5.exeption.InvalidNameException;
import com.zee.zee5.repository.MovieRepository;
import com.zee.zee5.service.MovieService;


@Repository
public class MovieRepositoryImpl implements MovieRepository {
	
	@Autowired
	DataSource dataSource;
	
	
	public MovieRepositoryImpl() throws IOException{
		// TODO Auto-generated constructor stub
		
	}
	
	

	@Override
	public String addMovie(Movie movie) {
		// TODO Auto-generated method stub

		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String insertStatement="insert into movies(movieid,name,"
				+ "agelimit,cast,genere,length,trailer,releasedate,language)"
				+ " values (?,?,?,?,?,?,?,?,?)";
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		
		try {
			preparedStatement=connection.prepareStatement(insertStatement);
			
			preparedStatement.setString(1, movie.getId());
			preparedStatement.setString(2, movie.getMovieName());
			preparedStatement.setString(3, movie.getAgelimit());
			preparedStatement.setString(4, movie.getCast());
			preparedStatement.setString(5, movie.getGenere());
			preparedStatement.setString(6, movie.getLength());
			preparedStatement.setString(7, movie.getTrailer());
			preparedStatement.setString(8, movie.getReleasedate());
			preparedStatement.setString(9, movie.getLanguage());

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
	public String updateMovie(String id, Movie movie) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String updateStatement="update movies set releasedate=? where movieid=?";
		try {
			connection= dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement=connection.prepareStatement(updateStatement);
			preparedStatement.setString(1, movie.getReleasedate());
			preparedStatement.setString(2, id);
			int result;
			result=preparedStatement.executeUpdate();
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
	public Optional<Movie> getMovieById(String id) throws IdNotFound {
		// TODO Auto-generated method stub
		Movie movie=new Movie();
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		
		String statement="select * from movies where movieid=?";
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
				movie.setId(resultSet.getString("movieid"));
				movie.setAgelimit(resultSet.getString("agelimit"));
				movie.setCast(resultSet.getString("cast"));
				movie.setGenere(resultSet.getString("genere"));
				movie.setLanguage(resultSet.getString("language"));
				movie.setLength(resultSet.getString("length"));
				movie.setMovieName(resultSet.getString("name"));
				movie.setReleasedate(resultSet.getString("releasedate"));
				movie.setTrailer(resultSet.getString("trailer"));
				return Optional.of(movie);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("id not found");
			return null;
		}
				return Optional.empty();
	}

	@Override
	public Optional<List<Movie>> getAllMovies() throws InvalidIdLengthException, InvalidNameException {
		// TODO Auto-generated method stub
		
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		ArrayList<Movie> arrayList=new ArrayList<Movie>();
		String selectStatement="select * from movies";
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			preparedStatement=connection.prepareStatement(selectStatement);
		
			resultSet=preparedStatement.executeQuery();
			
			while(resultSet.next())
			{
				Movie movie=new Movie();
							
				movie.setId(resultSet.getString("movieid"));
				movie.setAgelimit(resultSet.getString("agelimit"));
				movie.setCast(resultSet.getString("cast"));
				movie.setGenere(resultSet.getString("genere"));
				movie.setLanguage(resultSet.getString("language"));
				movie.setLength(resultSet.getString("length"));
				movie.setMovieName(resultSet.getString("name"));
				movie.setReleasedate(resultSet.getString("releasedate"));
				movie.setTrailer(resultSet.getString("trailer"));
				arrayList.add(movie);
				
			}
			return Optional.ofNullable(arrayList);
			
		} catch (SQLException e) {
			// TODO: handle exception
		}
		
		
		return Optional.empty();
	
	}

	@Override
	public String deleteMovieById(String id) throws IdNotFound {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		String deleteStatement="delete from movies where movieid=?";
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

}
