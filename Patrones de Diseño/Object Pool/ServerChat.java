import java.util.ArrayList;
import java.util.List;

class Connection {
    public void reset() {
        System.out.println("Conexión reiniciada");
    }
}

class ConnectionPool {
    private List<Connection> poolConnections;
    private int maxSize;

    public ConnectionPool(int maxSize) {
        this.maxSize = maxSize;
        this.poolConnections = new ArrayList<>();

        // Crear Connectiones iniciales y agregarlas a la piscina
        for (int i = 0; i < maxSize; i++) {
            poolConnections.add(createConnection());
        }
    }

    private Connection createConnection() {
        return new Connection();
    }


    public Connection getConnection() {
        if (poolConnections.isEmpty()) {
            return createConnection();
        } else {
            Connection Connection = poolConnections.remove(0);
            System.out.println("Conexión tomada de la piscina");
            return Connection;
        }
    }

    public void returnConnection(Connection connection) {
        if (poolConnections.size() < maxSize) {
            // Reiniciar la conexión y devolverla a la piscina
            connection.reset();
            poolConnections.add(connection);
            System.out.println("Conexión devuelta a la piscina");
        } else {
            System.out.println("La piscina está llena. La conexión no será devuelta.");
        }
    }
}

public class ServerChat {
    public static void main(String[] args) {
        // Crear una piscina de Connectiones
        ConnectionPool connectionPool = new ConnectionPool(10);

        // Simular solicitudes de clientes
        for (int i = 0; i < 15; i++) {
            // Tomar una conexión de la piscina para atender al cliente
            Connection connection = connectionPool.getConnection();

            // Simular el uso de la conexión para atender al cliente
            System.out.println("Atendiendo al cliente...");

            // Devolver la conexión a la piscina una vez que se completa la solicitud del
            // cliente
            connectionPool.returnConnection(connection);
        }
    }
}
