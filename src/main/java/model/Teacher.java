package model;

public class Teacher {
    private int id;
    private String name;
    private String address;
    private int classID;
    
    public Teacher() {
    }
    
    public Teacher( String name, String address, int classID) {
        this.name = name;
        this.address = address;
        this.classID = classID;
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public int getClassID() {
        return classID;
    }
    
    public void setClassID(int classID) {
        this.classID = classID;
    }
    
    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", classID=" + classID +
                '}';
    }
}
