package com.itbcafrica.microservices;

import com.itbcafrica.microservices.model.Artist;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.sql.DataSource;
import java.sql.*;
import java.util.Random;

@ApplicationScoped
public class ArtistResourceRepository {

  @Inject DataSource dataSource;

  public void persist(Artist artist) throws SQLException {

    Connection connection = dataSource.getConnection();
    String sql = "INSERT INTO t_artists (id,name,bio,created_date) VALUES (?,?,?,?)";
    artist.setId(Math.abs(new Random().nextLong()));
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setLong(1, artist.getId());
      preparedStatement.setString(2, artist.getName());
      preparedStatement.setString(3, artist.getBio());
      preparedStatement.setTimestamp(4, Timestamp.from(artist.getCreatedDate()));
      preparedStatement.executeUpdate();
    }
    connection.close();
  }

  public Artist findById(Long id) throws SQLException {
    Connection connection = dataSource.getConnection();
    String sql = "SELECT id,name,bio,created_date FROM t_artists WHERE id=?";
    Artist artist = new Artist();
    try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
      preparedStatement.setLong(1, id);
      ResultSet resultSet = preparedStatement.executeQuery();
      if (resultSet.next()) {
        artist.setId(resultSet.getLong(1));
        artist.setName(resultSet.getString(2));
        artist.setBio(resultSet.getString(3));
        artist.setCreatedDate(resultSet.getTimestamp(4).toInstant());
        return artist;
      }
    }
    connection.close();
    return null;
  }
}
