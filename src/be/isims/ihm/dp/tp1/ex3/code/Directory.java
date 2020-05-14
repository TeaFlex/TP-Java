package be.isims.ihm.dp.tp1.ex3.code;

public class Directory extends FileSystem { //node
    protected FileSystem childFile;

    public Directory(String name){
        super(name);
    }

    public Directory(String name, FileSystem parent){
        super(parent, name);
    }

    public void addFile(FileSystem child){
        this.childFile = child;
        child.setParentFile(this);
    }

    public void deleteFile(FileSystem child){
        this.childFile = null;
        child.setParentFile(null);
    }

    public FileSystem getChildFile() {
        return childFile;
    }

}
