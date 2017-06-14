package sg.edu.rp.c346.c347_midrevision;

/**
 * Created by 15056158 on 14/6/2017.
 */

public class contact {
    private int id;
    private String name;
    private String gender;
    private double height;

    public contact(int id, String name, String gender, double height){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.height = height;
    }

    public String getName(){
        return name;

    }

    public String getGender(){
        return gender;

    }

    public int getId(){
        return id;
    }

    public double getHeight(){
        return height;
    }

}
