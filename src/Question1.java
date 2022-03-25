import java.util.ArrayList;
import java.util.List;

public class Question1 {
    public static void main(String[] args) throws Exception {
        List<Integer> listA = new ArrayList<Integer>();
        List<Integer> listB = new ArrayList<Integer>();

        insertTestValues(listA, listB);

        System.out.println(findIntersection(listA, listB));

        Question2 myStack = new Question2();

        myStack.push(8);
        myStack.push(10);
        myStack.push(5);

        System.out.println(myStack.pop());
        System.out.println(myStack.max());

    }

    private static String findIntersection(List<Integer> listA, List<Integer> listB) {
        int index = 0;
        for (int i = 0; i < listB.size(); i++) {
            if (listA.contains(listB.get(i))) {
                index = exploreIntersection(0, i, listA, listB);
            }
        }
        if (index < 0) {
            return "The Lists do not intersect.";
        } else {
            return "Intersection is at Index " + index + " of ListA";
        }
    }


    private static int exploreIntersection(int value, int i, List<Integer> listA, List<Integer> listB) {
        value = value + listA.indexOf(listB.get(i));
        List<Integer> subListA = listA.subList(listA.indexOf(listB.get(i)), listA.size());
        int j = i;
        for (int k = 0; k < subListA.size(); k++) {
            if (subListA.get(k) == listB.get(j)) {
                j++;
            } else {
                if (subListA.indexOf(listB.get(i)) > 0) {
                    exploreIntersection(value, i, subListA, listB);
                } else {
                    return -1;
                }
            }
        }
        return value;
    }

    private static void insertTestValues (List < Integer > listA, List < Integer > listB){
        int[] testListA = new int[]{10, 18, 33, 21, 18, 28};
        int[] testListB = new int[]{20, 4, 7, 44, 18, 28};
        for (int i = 0; i < testListA.length; i++) {
            listA.add(testListA[i]);
        }
        for (int i = 0; i < testListB.length; i++) {
            listB.add(testListB[i]);
        }
    }
}
