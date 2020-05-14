package be.isims.ihm.dp.tp1.ex3.code;

public class Main {
    static private Directory root = new Directory("Root");
    static private Directory cd = root;
    public static void main(String[] args) {
        System.out.println(cd.getInfos());
        cd.addFile(new Directory("Dir1", root));
        cd = (Directory) cd.getChildFile();
        System.out.println(cd.getInfos());
    }
}
