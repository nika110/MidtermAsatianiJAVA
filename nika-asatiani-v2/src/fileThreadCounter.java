import java.io.File;

public class fileThreadCounter extends Thread{

    private int filesNum;
    private File startPath;

    public fileThreadCounter(File Path) {
        this.filesNum = 0;
        this.startPath = Path;
    }

    @Override
    public void run() {
        count(this.startPath);
        System.out.println("ipova direktoria : " + this.filesNum);
    }

    private void count(File Path){
        try {
            File[] files = Path.listFiles();
            for(File cF : files){

                if(cF.isDirectory()) count(cF);
                else {
                    this.filesNum++;
                    System.out.println("Ipova Direktoria saxelad : " + cF.getName());
                    Thread.sleep(3000);

                }
            }
        }catch (Exception except){
            except.printStackTrace();
        }
    }
}