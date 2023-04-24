package com.example;

class Auth {
    public void authorize() {
        System.out.println("Authorized");
    }
}

class Log {
    public void log() {
        System.out.println("Logged");
    }
}

// Real
class DxcTraining {

    public void getJavaTraining() {
        System.out.println("Java");
    }
    public void getKotlinTraining() {
        System.out.println("Kotlin");
    }
}

// placeholder / proxy
class DxcTrainingProxy{
    private Auth auth=new Auth();
    private Log log=new Log();
    private DxcTraining dxcTraining=new DxcTraining();
    public void getJavaTraining() {
        auth.authorize();
        log.log();
        dxcTraining.getJavaTraining();
    }
    public void getKotlinTraining() {
        auth.authorize();
        log.log();
        dxcTraining.getKotlinTraining();
    }
}

public class Academy {
    public static void main(String[] args) {

        DxcTrainingProxy dxcTraining = new DxcTrainingProxy();

        // E1
        dxcTraining.getJavaTraining();

        // E2
        dxcTraining.getKotlinTraining();


    }
}
