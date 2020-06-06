package pl.ostermach.zoo;

import pl.ostermach.zoo.models.Animal;
import pl.ostermach.zoo.models.Ticket;
import pl.ostermach.zoo.models.ZooKeeper;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ZooBuilder {
    private static final Scanner in = new Scanner(System.in);

    public static ZooKeeper buildZookeper() {
        ZooKeeper zooKeeper = new ZooKeeper();
        System.out.print("Enter ZooKeeper first name:  ");
        zooKeeper.setFirstName(in.nextLine());
        System.out.print("Enter ZooKeeper last name:  ");
        zooKeeper.setLastName(in.nextLine());
        zooKeeper.setId((int) (Math.random() * 500) + 1);
        return zooKeeper;
    }

    public static List<Animal> buildAnimalList() {
        boolean buildAnimals = true;
        List<Animal> animalList = new ArrayList<>();
        while (buildAnimals) {
            Animal animal = new Animal();
            System.out.print("Enter animal age:  ");
            animal.setAge(Integer.parseInt(in.nextLine()));
            System.out.print("Enter animal name:  ");
            animal.setName(in.nextLine());
            animal.setId((int) (Math.random() * 500) + 1);
            animalList.add(animal);

            System.out.print("Enter q to stop adding");
            if (in.nextLine().equals("q")) {
                buildAnimals = false;
            }
        }
        return animalList;
    }

    public static Ticket buildTicket(){
        Ticket ticket = new Ticket();
        System.out.print("Enter clients first name for ticket:  ");
        ticket.setFirstName(in.nextLine());
        System.out.print("Enter clients last name for ticket:  ");
        ticket.setLastName(in.nextLine());
        ticket.setId((int) (Math.random() * 500) + 1);
        ticket.setDate(LocalDate.now());
        return ticket;
    }


}
