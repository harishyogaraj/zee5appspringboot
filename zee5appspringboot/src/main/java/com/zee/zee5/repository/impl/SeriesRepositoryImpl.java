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
import java.util.TreeSet;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.zee.zee5.dto.Movie;
import com.zee.zee5.dto.Series;
import com.zee.zee5.exeption.IdNotFound;
import com.zee.zee5.repository.SeriesRepository;

@Repository
public class SeriesRepositoryImpl implements SeriesRepository {
	
	@Autowired
	DataSource dataSource;
	
	public SeriesRepositoryImpl() throws IOException {
		// TODO Auto-generated constructor stub
	}
		@Override
	public String addSeries(Series series) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		String statement="insert into series(seriesid,agelimit,cast,"
				+ "genere,length,releasedate,language,noofepisodes,"
				+ "seriesname) values(?,?,?,?,?,?,?,?,?)";
		
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			preparedStatement=connection.prepareStatement(statement);
			preparedStatement.setString(1, series.getSeriesid());
			preparedStatement.setString(2, series.getAgelimit());
			preparedStatement.setString(3, series.getCast());
			preparedStatement.setString(4, series.getGenere());
			preparedStatement.setString(5, series.getLength());
			preparedStatement.setString(6, series.getReleasedate());
			preparedStatement.setString(7, series.getLanguage());
			preparedStatement.setString(8, series.getNoofepisodes());
			preparedStatement.setString(9, series.getSeriesName());
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
	public String updateSeries(String id, Series series) {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try {
			connection=dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String statement="update series set releasedate=? where seriesid=?";
		try {
			preparedStatement=connection.prepareStatement(statement);
			preparedStatement.setString(1, series.getReleasedate());
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
	public Optional<Series> getSeriesById(String id) throws IdNotFound {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		ResultSet resultSet;
		String statement="select * from series where seriesid=?";
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement=connection.prepareStatement(statement);
			preparedStatement.setString(1, id);
			resultSet= preparedStatement.executeQuery();
			if(resultSet.next())
			{
				Series series=new Series();
				series.setAgelimit(resultSet.getString("agelimit"));
				series.setCast(resultSet.getString("cast"));
				series.setGenere(resultSet.getString("genere"));
				series.setSeriesId(resultSet.getString("seriesid"));
				series.setLanguage(resultSet.getString("language"));
				series.setLength(resultSet.getString("length"));
				series.setNoofepisodes(resultSet.getString("noofepisodes"));
				series.setReleasedate(resultSet.getString("releasedate"));
				series.setSeriesName(resultSet.getString("seriesname"));
				
				return Optional.ofNullable(series);		
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("id not found!");
		}
		
		return Optional.empty();
	}

	@Override
	public Optional<List<Series>> getAllSeries() {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		ResultSet resultSet;
		ArrayList<Series> arrayList=new ArrayList<Series>();
		String statement="select * from series";
		try {
			connection=dataSource.getConnection();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			preparedStatement=connection.prepareStatement(statement);
			resultSet= preparedStatement.executeQuery();
			while(resultSet.next())
			{
				Series series=new Series();
				series.setAgelimit(resultSet.getString("agelimit"));
				series.setCast(resultSet.getString("cast"));
				series.setGenere(resultSet.getString("genere"));
				
				series.setSeriesId(resultSet.getString("seriesid"));

				series.setLanguage(resultSet.getString("language"));

				series.setLength(resultSet.getString("length"));
				
				series.setNoofepisodes(resultSet.getString("noofepisodes"));
				series.setReleasedate(resultSet.getString("releasedate"));
				series.setSeriesName(resultSet.getString("seriesname"));

				arrayList.add(series);
				
			}
			return Optional.ofNullable(arrayList);		
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("id not found!");
		}
	
		return Optional.empty();
	
	}

	@Override
	public String deleteSeriesById(String id) throws IdNotFound {
		// TODO Auto-generated method stub
		Connection connection=null;
		PreparedStatement preparedStatement=null;

		try {
			connection=dataSource.getConnection();
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		String deleteStatement="delete from series where seriesid=?";
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
