public class PhraseOMatic {
    public static void main(String[] args) {
// make three sets of words to choose from. Add your own!
        String[] wordListOne = {"24/7", "multi-Tier", "30,000 foot", "B-to-B", "win-win", "front-end",
                "web-based", "pervasive", "smart", "six- sigma", "critical-path", "dynamic"};
        String[] wordListTwo = {"empowered", "sticky",
                "value-added", "oriented", "centric", "distributed",
                "clustered", "branded", "outside-the-box", "positioned",
                "networked", "focused", "leveraged", "aligned",
                "targeted", "shared", "cooperative", "accelerated"};
        String[] wordListThree = {"process", "tipping-point",
                "strategy", "mindshare", "portal", "space", "vision",
                "paradigm", "mission"};

        int len_one = wordListOne.length;
        int len_two=wordListTwo.length;
        int len_three=wordListThree.length;
        System.out.println("this the length  of wordlistone ="+len_one);
        System.out.println("this the length  of wordlisttwo ="+len_two);
        System.out.println("this the length  of wordlistthree ="+len_three);
        // generate three random numbers
        int rand1 = (int) (Math.random() * len_one);
        int rand2 = (int) (Math.random() * len_two);
        int rand3 = (int) (Math.random() * len_three);
        // now build a phrase
        String phrase = wordListOne[rand1] + " " +
                wordListTwo[rand2] + " " + wordListThree[rand3];
// print out the phrase
        System.out.println("What we need is a " + phrase);
    }
}
