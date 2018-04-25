import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Exception in thread "main" java.util.ConcurrentModificationException
 * at java.util.ArrayList$Itr.checkForComodification(ArrayList.java:901)
 * at java.util.ArrayList$Itr.next(ArrayList.java:851)
 * at Sort.main(Sort.java:15)
 * <p>
 * 在对一个Collection边遍历边做增删操作，影响size变化，抛出此异常。
 *
 * @author liuhe
 * @date 2018/4/25
 */
public class ListError {

    public static void main(String[] args) {

        List<String> list = new ArrayList();

        list.add("aa");
        list.add("bb");
        list.add(new String("cc"));
        list.add("dd");

       // test0 无异常
        for (int i = list.size()-1;i>=0;i--){
            if (list.get(i)== "cc" || list.get(i) == "bb") {
                list.remove(list.get(i));
            }
        }

        System.out.println(list);

//        //  test1 存在异常
//        for (String s : list) {
//            if (s == "cc" || s == "bb") {
//                list.remove(s);
//            }
//        }
//        //  test 2 存在异常
//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()){
//            String next = iterator.next();
//            if (next == "cc" || next == "bb") {
//                list.remove(next);
//            }
//        }
//      //  test3 修改异常
//        for (String s : list) {
//            if (s.equals("cc")) {
//                list.add("ad");
//            }
//        }
    }
}
