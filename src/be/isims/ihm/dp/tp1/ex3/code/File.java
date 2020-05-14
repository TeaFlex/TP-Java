package be.isims.ihm.dp.tp1.ex3.code;

public class File extends FileSystem { //leaf
    private String content;

    public File(String name){
        super(name);
    }

    public File(String name, FileSystem parent){
        super(parent, name);
    }
}
