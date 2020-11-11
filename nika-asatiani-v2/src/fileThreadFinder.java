import java.io.File;
import java.util.Scanner;

public class fileThreadFinder extends Thread{

    private File path;

    public fileThreadFinder(File Path) {
        this.path = Path;
    }

    @Override
    public void run() {
        Scanner scanner = new Scanner(System.in);
        while(true) {
            System.out.println("Sadziebo sitkva : ");
            String word = scanner.nextLine();
            if (word.length() == 0) {
                System.out.println("Ar Aris Validuri Sitkva Gtxovt Sheikvanot Tavidan : ");
                break;
            }
            findDir(this.path, word);
        }
    }

    private static void findDir(File Path, String word){
        try {
            File[] files = Path.listFiles();
            for(File currentFile : files){
                if(byWord(currentFile.getName(),word)) {
                    System.out.println("Ipova :" + currentFile.getName());
                    Thread.sleep(3000);
                }else {
                    System.out.println("Veraperi ver ipova");
                    Thread.sleep(3000);
                }

                if(currentFile.isDirectory()) findDir(currentFile, word);
            }
        }catch (Exception except){
            except.printStackTrace();
        }
    }

    private static boolean byWord(String word, String toFind){
        int maxIndex = word.length() - toFind.length()+1;

        for(int i = 0; i < maxIndex; i++) {

            String sub = word.substring(i, i+toFind.length());
            if(sub.equals(toFind)) return true;

        }
        return false;

    }
}