import java.util.Comparator;

/**
 * @author ericfouh
 */
public interface ITerm
        extends Comparable<ITerm> {

    /**
     * Compares the two terms in descending order by weight.
     *
     * @return comparator Object
     */
    public static Comparator<ITerm> byReverseWeightOrder() {
        return new Comparator<ITerm>() {
            @Override
            public int compare(ITerm t1, ITerm t2) {
                return Long.compare(t2.getWeight(), t1.getWeight());
            }
        };
    }


    /**
     * Compares the two terms in lexicographic order but using only the first r
     * characters of each query.
     *
     * @param r
     * @return comparator Object
     */
    public static Comparator<ITerm> byPrefixOrder(int r) {
        if (r < 0) {
            throw new IllegalArgumentException("r must be non-negative");
        }
        return new Comparator<ITerm>() {
            @Override
            public int compare(ITerm t1, ITerm t2) {
                String s1 = t1.getTerm();
                String s2 = t2.getTerm();
                int len1 = Math.min(r, s1.length());
                int len2 = Math.min(r, s2.length());
                return s1.substring(0, len1).compareTo(s2.substring(0, len2));
            }
        };
    }

    // Compares the two terms in lexicographic order by query.
    public int compareTo(ITerm that);


    // Returns a string representation of this term in the following format:
    // the weight, followed by a tab, followed by the query.
    public String toString();

    // Required getters.
    public long getWeight();
    public String getTerm();

    // Required setters (mostly for autograding purposes)
    public void setWeight(long weight);
    public String setTerm(String term);

}


//import java.util.Comparator;
//
///**
// * @author ericfouh
// */
//public interface ITerm
//    extends Comparable<ITerm>
//{
//
//    /**
//     * Compares the two terms in descending order by weight.
//     *
//     * @return a comparator
//     */
//    public static Comparator<ITerm> byReverseWeightOrder()
//    {
//        return new Comparator<ITerm>() {
//            public int compare(ITerm t1, ITerm t2)
//            {
//                return (int)(((Term)t2).getWeight() - ((Term)t1).getWeight());
//            }
//        };
//    }
//
//
//    /**
//     * Compares the two terms in lexicographic order but using only the first r
//     * characters of each query.
//     *
//     * @param r
//     * @return comparator Object
//     */
//    public static Comparator<ITerm> byPrefixOrder(int r)
//    {
//        return new Comparator<ITerm>() {
//            public int compare(ITerm t1, ITerm t2)
//            {
//                int min_length = Math.min(((Term)t1).getTerm().length(), ((Term)t2).getTerm().length());
//                int l = r;
//                if(r > min_length) {
//                    l = min_length;
//                }
//                String w1 = ((Term)t1).getTerm().substring(0, l);
//                String w2 = ((Term)t2).getTerm().substring(0, l);
//                return w1.compareTo(w2);
//            }
//        };
//    }
//
//    // Compares the two terms in lexicographic order by query.
//    public int compareTo(ITerm that);
//
//
//    // Returns a string representation of this term in the following format:
//    // the weight, followed by a tab, followed by the query.
//    public String toString();
//
//}

