// Brian Sosa Colman
// COP2800C
// Module 12 GPA
// 11/22/2026

package edu.fscj.cop2800c.util;

import java.util.List;

public class DataWrapper<T> {
   private T value;

   public DataWrapper() {
      this.value = null;
   }

   public DataWrapper(T value) {
      this.value = value;
   }

   public T getValue() {
      return value;
   }

   public static <T> void displayList(List<DataWrapper<T>> list) {
      for (DataWrapper<T> element : list) {
         System.out.println(element.getValue());
      }
   }
}