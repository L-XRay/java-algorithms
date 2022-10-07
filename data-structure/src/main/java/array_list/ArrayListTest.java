package array_list;

import org.junit.jupiter.api.Test;

public class ArrayListTest {

    @Test
    public void test_array_list() {
        ArrayList<String> list = new ArrayList<>();
        list.add("01");
        list.add("02");
        list.add("03");
        list.add("04");
        list.add("05");
        list.add("06");
        list.add("07");
        list.add("08");
        list.add("09");
        list.add("10");
        list.add("11");
        list.add("12");

        System.out.println(list);

        list.remove(9);

        System.out.println(list);
    }

}
