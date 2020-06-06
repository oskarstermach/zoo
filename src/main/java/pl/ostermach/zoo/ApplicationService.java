package pl.ostermach.zoo;


import com.datastax.driver.core.ResultSet;
import pl.ostermach.zoo.models.Animal;
import pl.ostermach.zoo.models.Ticket;
import pl.ostermach.zoo.models.ZooKeeper;

public class ApplicationService extends AbstractService {

    public ApplicationService() {
        super();
    }

    public void addNewEntry() {
        System.out.println("[1]Animal\n[2]Zookeeper\n[3]Ticket");
        int choice = Integer.parseInt(in.nextLine());
        switch(choice){
            case 1:
                Animal animal = ZooBuilder.buildAnimalList().get(0);
                cassandraUtils.insertDataToAnimalTable(animal);
                break;
            case 2:
                ZooKeeper zooKeeper = ZooBuilder.buildZookeper();
                cassandraUtils.insertIntoZooKeeperTable(zooKeeper);
                break;
            case 3:
                Ticket ticket = ZooBuilder.buildTicket();
                cassandraUtils.insertIntoTicketTable(ticket);
                break;
        }

    }

    public void deleteEntry() {
        System.out.println("[1]Animal\n[2] Zookeeper\n[3]Ticket");
        int choice = Integer.parseInt(in.nextLine());
        switch(choice){
            case 1:
                System.out.println("Enter id");
                cassandraUtils.deleteById("Animal",Long.parseLong(in.nextLine()));
                break;
            case 2:
                System.out.println("Enter id");
                cassandraUtils.deleteById("ZooKeeper",Long.parseLong(in.nextLine()));
                break;
            case 3:
                System.out.println("Enter id");
                cassandraUtils.deleteById("Ticket",Long.parseLong(in.nextLine()));
                break;
        }
    }


    public void findById() {
        System.out.println("[1]Animal\n[2] Zookeeper\n[3]Ticket");
        int choice = Integer.parseInt(in.nextLine());
        switch(choice){
            case 1:
                System.out.println("Enter id");
                ResultSet rows = cassandraUtils.selectById("Animal",Long.parseLong(in.nextLine()));
                rows.forEach(System.out::println);
                break;
            case 2:
                System.out.println("Enter id");
                rows = cassandraUtils.selectById("ZooKeeper",Long.parseLong(in.nextLine()));
                rows.forEach(System.out::println);
                break;
            case 3:
                System.out.println("Enter id");
                rows = cassandraUtils.selectById("Ticket",Long.parseLong(in.nextLine()));
                rows.forEach(System.out::println);
                break;
        }
    }

    public void getEntries() {
        System.out.println("[1]Animal\n[2]Zookeeper\n[3]Ticket");
        int choice = Integer.parseInt(in.nextLine());
        switch(choice){
            case 1:
                StringBuilder sb = new StringBuilder("SELECT * FROM ").append("Animal");
                String query = sb.toString();
                ResultSet rs = session.execute(query);
                System.out.println("Animals:");
                System.out.println("Id, age, name");
                rs.forEach(System.out::println);
                break;
            case 2:
                sb = new StringBuilder("SELECT * FROM ").append("ZooKeeper");
                query = sb.toString();
                rs = session.execute(query);
                System.out.println("Zookepers:");
                System.out.println("Id, firstName, lastName");
                rs.forEach(System.out::println);
                break;
            case 3:
                sb = new StringBuilder("SELECT * FROM ").append("Ticket");
                query = sb.toString();
                rs = session.execute(query);
                System.out.println("Tickets:");
                System.out.println("Id, date, firstName, lastName");
                rs.forEach(System.out::println);
                break;
        }
    }

    public void updateEntry() {
        System.out.println("[1]Animal\n[2] Zookeeper\n[3]Ticket");
        int choice = Integer.parseInt(in.nextLine());
        switch(choice){
            case 1:
                System.out.println("Enter id");
                cassandraUtils.updateAnimal(Long.parseLong(in.nextLine()),ZooBuilder.buildAnimalList().get(0));
                System.out.println("Updated animal row");
                break;
            case 2:
                System.out.println("Enter id");
                cassandraUtils.updateZooKeeper(Long.parseLong(in.nextLine()),ZooBuilder.buildZookeper());
                System.out.println("Updated zookeeper row");
                break;
            case 3:
                System.out.println("Enter id");
                cassandraUtils.updateTicket(Long.parseLong(in.nextLine()),ZooBuilder.buildTicket());
                System.out.println("Updated ticket row");
                break;
        }
    }



}
