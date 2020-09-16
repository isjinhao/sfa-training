package jinhao;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

/**
 * @author 01395265
 * @description TODO
 * @date 2020/9/14
 */
public class TestTable {

    public static void main(String[] args) {

        // 二维的表
        Table<String, Integer, String> aTable = HashBasedTable.create();

        for (char a = 'A'; a <= 'C'; ++a) {
            for (Integer b = 1; b <= 3; ++b) {
                aTable.put(Character.toString(a), b, String.format("%c%d", a, b));
            }
        }

        System.out.println(aTable.column(2));

        System.out.println("----------------------------");

        System.out.println(aTable.row("B"));
        System.out.println(aTable.get("B", 2));

        System.out.println(aTable.contains("D", 1));
        System.out.println(aTable.containsColumn(3));
        System.out.println(aTable.containsRow("C"));
        System.out.println(aTable.columnMap());
        System.out.println(aTable.rowMap());

        System.out.println(aTable.remove("B", 3));

    }
}