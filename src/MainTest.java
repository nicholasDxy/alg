import java.util.LinkedList;
import java.util.List;

public class MainTest {
    private List<List<Integer>> res;

    MainTest() {
        res = new LinkedList<>();
    }

    public static void main(String[] args) {
//        System.out.println(10+2>>1);
//        SOS s = new SOS();
//        s.combine(4,2);
    }

    public void createList() {
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        addList(linkedList);
    }

    public void addList(List<Integer> list) {
        System.out.print(list.toString());
        res.add(list);
    }

    public void print() {
        System.out.print(res.toString());
    }
}
