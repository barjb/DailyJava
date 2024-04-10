package j21.recordpatterns;

record Box<T>(T t) {
    static void printBoxContents(Box<String> bo){
        if(bo instanceof Box<String>(String s)){
            System.out.println("box contains: " + s);
        }
    }
}
