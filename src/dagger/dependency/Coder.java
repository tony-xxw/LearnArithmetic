package dagger.dependency;

import com.sun.tools.javac.jvm.Code;

public class Coder {
    Computer computer;

    public  Coder(Computer computer){
        this.computer = computer;
    }

    public Coder(){
        computer = new Computer();
    }
}
