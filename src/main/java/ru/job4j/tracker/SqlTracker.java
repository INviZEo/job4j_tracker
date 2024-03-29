package ru.job4j.tracker;

import ru.job4j.tracker.Item;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store {
    private final List<Item> items = new ArrayList<Item>();
    private int ids = 1;

    private Connection connection;

    public SqlTracker() {
        init();
    }

    private Item itemGet(ResultSet resultSet) throws SQLException {
        return new Item(
                resultSet.getInt("id"),
                resultSet.getString("name"),
                resultSet.getTimestamp("created").toLocalDateTime()
        );
    }

    public SqlTracker(Connection connection) {
        this.connection = connection;
    }

    private void init() {
        try (InputStream in = SqlTracker.class.getClassLoader()
                .getResourceAsStream("db/liquibase.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement statement =
                     connection.prepareStatement("INSERT INTO items (name, created) VALUES (?, ?)",
                             Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.execute();
            try (ResultSet generatedKeys = statement.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean result = false;
        try (PreparedStatement statement =
                     connection.prepareStatement("UPDATE items SET name = ?, created = ? WHERE id = ?")) {
            statement.setString(1, item.getName());
            statement.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            statement.setInt(3, id);
            result = statement.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public void delete(int id) {
        try (PreparedStatement statement =
                     connection.prepareStatement("DELETE FROM items WHERE id = ?")) {
            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement("select * from items")) {
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                rsl.add(itemGet(result));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement statement =
                     connection.prepareStatement("select * from items where name = ?")) {
            statement.setString(1, key);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    rsl.add(itemGet(result));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item rsl = null;
        try (PreparedStatement statement =
                     connection.prepareStatement("select * from items where id = ?")) {
            statement.setInt(1, id);
            try (ResultSet result = statement.executeQuery()) {
                while (result.next()) {
                    rsl = itemGet(result);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return rsl;
    }
}