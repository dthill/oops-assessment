package read;

import java.io.File;

public class SortFiles {

  public static File[] sortByFileName(File[] fileList) {
    return mergeSort(fileList);
  }

  private static File[] mergeSort(File[] list) {
    if (list.length <= 1) {
      return list;
    }
    int middle = list.length / 2;
    File[] leftList = new File[middle];
    File[] rightList = new File[list.length - middle];
    for (int i = 0; i < list.length; i++) {
      if (i < middle) {
        leftList[i] = list[i];
      } else {
        rightList[i - middle] = list[i];
      }
    }
    return merge(mergeSort(leftList), mergeSort(rightList));
  }

  private static File[] merge(File[] leftList, File[] rightList) {
    File[] mergedList = new File[leftList.length + rightList.length];
    int leftIndex = 0;
    int rightIndex = 0;
    while (leftIndex < leftList.length && rightIndex < rightList.length) {
      if (leftList[leftIndex].getName().charAt(0) <= rightList[rightIndex].getName().charAt(0)) {
        mergedList[leftIndex + rightIndex] = leftList[leftIndex];
        leftIndex++;
      } else {
        mergedList[leftIndex + rightIndex] = rightList[rightIndex];
        rightIndex++;
      }
    }
    while (leftIndex < leftList.length) {
      mergedList[leftIndex + rightIndex] = leftList[leftIndex];
      leftIndex++;
    }
    while (rightIndex < rightList.length) {
      mergedList[leftIndex + rightIndex] = rightList[rightIndex];
      rightIndex++;
    }
    return mergedList;
  }
}
