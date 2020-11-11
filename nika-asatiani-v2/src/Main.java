import java.io.File;

public class Main {

    public static void main(String[] args) {
        File p = new File("~/BTU_DOCUMENT");

        new fileThreadCounter(p).start();
        new fileThreadFinder(p).start();
    }

}

