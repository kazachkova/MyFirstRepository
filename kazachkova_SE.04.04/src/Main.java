import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Actors actor1 = new Actors("Name1", "Surname1");
        Actors actor2 = new Actors("Name2", "Surname2");
        Actors actor3 = new Actors("Name3", "Surname3");
        Movies movie1 = new Movies(actor1, actor2, "Movie1");
        Movies movie2 = new Movies(actor1, actor2, "Movie2");
        Movies movie3 = new Movies(actor1, actor3, "Movie3");
        String fileName = "D:\\file.txt";
        FileOutputStream os = new FileOutputStream(fileName);
        ObjectOutputStream oos = new ObjectOutputStream(os);
        oos.writeObject(movie1);
        oos.writeObject(movie2);


        System.out.println("Read objects and modify: ");
        FileInputStream is = new FileInputStream(fileName);
        ObjectInputStream ois = new ObjectInputStream(is);
        while (is.available() > 0) {
            Movies movies = (Movies) ois.readObject();
            movies.printInfo();
        }
        oos.reset();
        oos.writeObject(movie3);
        oos.close();
        os.close();
        is.close();
        ois.close();
        System.out.println("Read objects: ");
        is = new FileInputStream(fileName);
        ois = new ObjectInputStream(is);
        while (is.available() > 0) {
            Movies movies = (Movies) ois.readObject();
            movies.printInfo();
        }
        is.close();
        ois.close();
    }
}
