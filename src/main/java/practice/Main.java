package practice;


import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class Main {

  public static void main(String[] args) {

    List<String> coolNumberList = practice.CoolNumbers.generateCoolNumbers();
    ArrayList<String> arrayList = new ArrayList<>(coolNumberList);
    ArrayList<String> sortedArrayList = new ArrayList<>(coolNumberList);
    sortedArrayList.sort(String::compareTo);
    HashSet<String> hashSet = new HashSet<>(coolNumberList);
    TreeSet<String> treeSet = new TreeSet<>(coolNumberList);

    String numberToSearch = coolNumberList.get(new Random().nextInt(coolNumberList.size()));

    measureAndPrintSearchTime("Поиск перебором",
        practice.CoolNumbers.bruteForceSearchInList(arrayList, numberToSearch));
    measureAndPrintSearchTime("Бинарный поиск",
        practice.CoolNumbers.binarySearchInList(sortedArrayList, numberToSearch));
    measureAndPrintSearchTime("Поиск в HashSet",
        practice.CoolNumbers.searchInHashSet(hashSet, numberToSearch));
    measureAndPrintSearchTime("Поиск в TreeSet",
        practice.CoolNumbers.searchInTreeSet(treeSet, numberToSearch));
  }

  private static void measureAndPrintSearchTime(String searchMethod, Boolean found) {
    long startTime = System.nanoTime();
    long endTime;
    long duration;
    endTime = System.nanoTime();
    duration = endTime - startTime;
    System.out.println(String.format("%s: номер %s, поиск занял %d нс", searchMethod,
        found ? "найден" : "не найден", duration));

  }
}

