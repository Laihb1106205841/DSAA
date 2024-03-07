package ADAS.Week2;

import java.util.*;

public class GaleShapleyExtend {
    public static void main(String[] args) {
        int numStudents = 3;
        int numSchools = 2;

        // 学生偏好
        Integer[][] studentPreferences = {
                {1, 2, 3},
                {2, 3, 1},
                {3, 1, 2}
        };

        // 学校偏好
        Integer[][] schoolPreferences = {
                {1, 2},
                {2, 3},
                {3, 1}
        };

        int[] extendedList = extend(studentPreferences, schoolPreferences);
        System.out.println("Extended List: " + Arrays.toString(extendedList));
    }

    public static int[] extend(Integer[][] studentPreferences, Integer[][] schoolPreferences) {
        int n = studentPreferences.length;
        int[] extendedList = new int[n];
        Map<Integer, Integer> studentPartnerMap = new HashMap<>();
        Map<Integer, Integer> schoolPartnerMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            studentPartnerMap.put(i, -1);
            schoolPartnerMap.put(i, -1);
        }

        boolean[] isMatchedStudent = new boolean[n];
        boolean[] isMatchedSchool = new boolean[n];

        int count = 0;
        while (count < n) {
            for (int i = 0; i < n; i++) {
                int studentIndex = i;
                int schoolIndex = studentPartnerMap.get(studentIndex);

                if (!isMatchedStudent[studentIndex] && !isMatchedSchool[schoolIndex]) {
                    int studentPref = studentPreferences[studentIndex][count];
                    int schoolPref = schoolPreferences[schoolIndex][count];

                    if (studentPref == studentPreferences[studentIndex][studentPreferences[studentIndex].length - 1]) {
                        extendedList[count++] = studentPref;
                        isMatchedStudent[studentIndex] = true;
                        isMatchedSchool[schoolIndex] = true;
                    } else if (schoolPref == schoolPreferences[schoolIndex][schoolPreferences[schoolIndex].length - 1]) {
                        extendedList[count++] = studentPref;
                        isMatchedStudent[studentIndex] = true;
                        isMatchedSchool[schoolIndex] = true;
                    } else {
                        studentPartnerMap.put(studentPref, schoolIndex);
                        schoolPartnerMap.put(schoolPref, studentIndex);
                    }
                }
            }
        }

        return extendedList;
    }
}

