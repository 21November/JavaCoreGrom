package lesson11.interfaceexample;

public class PostgreSQLDbProvider implements DbProvider {

    @Override
    public void connectToDb() {
        //some logic for SQLDb
    }

    @Override
    public void disconnectFromDb() {
        //some logic for SQLDb
    }

    @Override
    public void encryptDate() {
        //some logic for SQLDb
    }
}
