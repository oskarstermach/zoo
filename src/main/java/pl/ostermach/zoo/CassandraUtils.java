package pl.ostermach.zoo;

import com.datastax.driver.core.ResultSet;
import com.datastax.driver.core.Session;
import pl.ostermach.zoo.models.Animal;
import pl.ostermach.zoo.models.Ticket;
import pl.ostermach.zoo.models.ZooKeeper;

public class CassandraUtils {
    private Session session;

    public CassandraUtils(Session session) {
        this.session = session;
    }

    public void initStructure() {
        createKeySpace("zoo", "SimpleStrategy", 1);
        session.execute("USE zoo;");
        createAnimalTable();
        createZooKeeperTable();
        createTicketTable();
    }

    public void deleteById(String tableName, long id) {
        session.execute("DELETE FROM " + tableName + " WHERE id =" + id + "IF EXISTS;");
    }
    public ResultSet selectById(String tableName, long id) {
        return session.execute("SELECT *  FROM " + tableName + " WHERE id =" + id + ";");
    }

    public void updateAnimal( long id, Animal animal){
        String stringBuilder = "UPDATE " +
                "Animal " +
                "SET age=" + animal.getAge() +
                ", name=" + "'" + animal.getName() + "'" +
                "WHERE id=" + id;

        session.execute(stringBuilder);
    }

    public void updateZooKeeper( long id, ZooKeeper zooKeeper){
        String stringBuilder = "UPDATE " +
                "Animal " +
                "SET first_name="+ "'" + zooKeeper.getFirstName() + "'"+
                ", last_name=" + "'" + zooKeeper.getLastName() + "'" +
                "WHERE id=" + id;

        session.execute(stringBuilder);
    }

    public void updateTicket( long id, Ticket ticket){
        String stringBuilder = "UPDATE " +
                "Animal " +
                "SET first_name="+ "'" + ticket.getFirstName() + "'"+
                ", last_name=" + "'" + ticket.getLastName() + "'" +
                "WHERE id=" + id;

        session.execute(stringBuilder);
    }

    public void createKeySpace(String keyspaceName, String replicationStrategy, int replicationFactor) {
        StringBuilder sb =
                new StringBuilder("CREATE KEYSPACE IF NOT EXISTS ")
                        .append(keyspaceName).append(" WITH replication = {")
                        .append("'class':'").append(replicationStrategy)
                        .append("','replication_factor':").append(replicationFactor)
                        .append("};");

        String query = sb.toString();
        session.execute(query);
    }

    public void createAnimalTable() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append("Animal").append("(")
                .append("id bigint PRIMARY KEY, ")
                .append("name text,")
                .append("age int);");

        String query = sb.toString();
        session.execute(query);
    }

    public void createZooKeeperTable() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append("ZooKeeper").append("(")
                .append("id bigint PRIMARY KEY, ")
                .append("first_name text,")
                .append("last_name text);");

        String query = sb.toString();
        session.execute(query);
    }

    public void createTicketTable() {
        StringBuilder sb = new StringBuilder("CREATE TABLE IF NOT EXISTS ")
                .append("Ticket").append("(")
                .append("id bigint PRIMARY KEY, ")
                .append("first_name text,")
                .append("last_name text,")
                .append("date date);");

        String query = sb.toString();
        session.execute(query);
    }


    public void insertIntoZooKeeperTable(ZooKeeper zooKeeper) {
        StringBuilder sb = new StringBuilder("INSERT INTO ZooKeeper (")
                .append('"').append("id").append('"').append(',')
                .append('"').append("first_name").append('"').append(',')
                .append('"').append("last_name").append('"').append(')')
                .append("VALUES(")
                .append(zooKeeper.getId()).append(",")
                .append("'").append(zooKeeper.getFirstName()).append("',")
                .append("'").append(zooKeeper.getLastName()).append("');");
        session.execute(sb.toString());
    }

    public void insertIntoTicketTable(Ticket ticket) {
        StringBuilder sb = new StringBuilder("INSERT INTO Ticket (")
                .append('"').append("id").append('"').append(',')
                .append('"').append("first_name").append('"').append(',')
                .append('"').append("last_name").append('"').append(',')
                .append('"').append("date").append('"').append(')')
                .append("VALUES(")
                .append(ticket.getId()).append(",")
                .append("'").append(ticket.getFirstName()).append("',")
                .append("'").append(ticket.getLastName()).append("',")
                .append("'").append(ticket.getDate()).append("');");
        session.execute(sb.toString());
    }

    public void insertDataToAnimalTable(Animal animal) {
        StringBuilder sb = new StringBuilder("INSERT INTO Animal (")
                .append('"').append("id").append('"').append(',')
                .append('"').append("name").append('"').append(',')
                .append('"').append("age").append('"').append(')')
                .append("VALUES(")
                .append(animal.getId()).append(",")
                .append("'").append(animal.getName()).append("',")
                .append(animal.getAge()).append(");");

        session.execute(sb.toString());
    }
}
