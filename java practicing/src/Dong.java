public class Dong {
    public static void main(String[] args) {
        play p1 = new play();
        if (p1.test == true) {
            p1.playSnare();
        }
        p1.playTopHat();
    }
}

    class play {

        boolean test = true;

        void playSnare() {
            System.out.println("bang bang ba-bang");
        }

        void playTopHat() {
            System.out.println("ding ding da-ding");
        }

    }

