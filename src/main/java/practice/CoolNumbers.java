package practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.TreeSet;

public class CoolNumbers {

  public static ArrayList<String> list = new ArrayList<>();

  public static List<String> generateCoolNumbers() {
    String[] letters = {"А", "В", "Е", "К", "М", "Н", "О", "Р", "С", "Т", "У", "Х"};
    for (String firstLetter : letters) {
      for (String secondLetter : letters) {
        for (String thirdLetter : letters) {
          for (int number = 0; number < 10; number++) {
            for (int region = 1; region <= 199; region++) {
              String formattedRegion = String.format("%03d", region);
              String numberplate = String.format("%s%d%d%d%s%s%s", firstLetter, number, number,
                  number, secondLetter, thirdLetter, formattedRegion);
              list.add(numberplate);
            }
          }
        }
      }
    }

    return list;
  }

  public static boolean bruteForceSearchInList(List<String> list, String number) {
    for (String item : list) {
      if (item.equals(number)) {
        return true;
      }
    }
    return false;
  }

  public static boolean binarySearchInList(List<String> sortedList, String number) {
    int index = Collections.binarySearch(sortedList, number);
    return index >= 0;
  }

  public static boolean searchInHashSet(HashSet<String> hashSet, String number) {

    return hashSet.contains(number);
  }

  public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {

    return treeSet.contains(number);
  }

}

