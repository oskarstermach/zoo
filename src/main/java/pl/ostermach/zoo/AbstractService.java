package pl.ostermach.zoo;


import com.datastax.driver.core.Session;

import java.util.Scanner;

public abstract class AbstractService {
    public final Session session;
    public Scanner in = new Scanner(System.in);
    public CassandraUtils cassandraUtils;

    public AbstractService() {
        CassandraConnector client = new CassandraConnector();
        client.connect("127.0.0.1", 9042);
        this.session = client.getSession();
        this.cassandraUtils = new CassandraUtils(this.session);
        cassandraUtils.initStructure();
    }
}
