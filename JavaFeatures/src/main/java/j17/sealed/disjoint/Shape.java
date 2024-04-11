package j17.sealed.disjoint;

public sealed interface Shape permits Polygon {
}

non-sealed interface Polygon extends Shape {
}

final class UtahTeapot {
}

class Ring {
}

class App {
    public static void main(String[] args) {

    }

    public void work(j17.sealed.disjoint.Shape s) {
//        UtahTeapot u = (UtahTeapot) s;
        //ERROR
        Ring r = (Ring) s;
    }
}
