package be.isims.ihm.dp.tp1.ex3.code;

public abstract class FileSystem { //root
    protected String name;
    protected FileSystem parentFile;

    public FileSystem(String name) {
        this.name = name;
        this.parentFile = null;
    }

    public FileSystem(FileSystem parent, String name){
        this.name = name;
        this.parentFile = parent;
    }

    public String getName() {
        return name;
    }

    public String getInfos(){
        if(parentFile == null)
            return "Current: "+name+" |Parent: None";
        else
            return "Current: "+name+" |Parent: "+parentFile.getName();
    }

    public FileSystem getParentFile() {
        return parentFile;
    }

    public void setParentFile(FileSystem parentFile) {
        this.parentFile = parentFile;
    }
}
