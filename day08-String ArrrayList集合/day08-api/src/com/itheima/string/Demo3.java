package com.itheima.string;

public class Demo3 {
    public static void main(String[] args) {

        String str = "我爱你中国love";

        // 1、public int length(): 获取字符串的长度
        int len = str.length();
        System.out.println(len);    // 9

        // 2、public char charAt(int index): 获取某个索引位置处的字符
        char c = str.charAt(1);
        System.out.println(c);

        System.out.println(str.charAt(3));  // 中

        // 遍历
        for (int i = 0; i < str.length(); i++) {
            System.out.print(str.charAt(i) + "\t");
        }
        System.out.println();

        // 3、public char[] toCharArray()：: 把字符串转换成字符数组
        char[] chs = str.toCharArray();
        // 遍历
        for (int i = 0; i < chs.length; i++) {
            System.out.print(chs[i] + "\t");
        }
        System.out.println();

//        "我爱你中国love"
        // 4、public String substring(int beginIndex, int endIndex) ：截取内容，(包前不包后的)
        System.out.println(str.substring(3, 5));    // 中国

        // 5、public String substring(int beginIndex):从当前索引一直截取到末尾
        System.out.println(str.substring(5));   // love

        // 6、public String replace(CharSequence target, CharSequence replacement)
        String str1 = "金三胖是最棒的80后，我爱金三胖，金三胖棒棒的";
        String str2 = str1.replace("金三胖", "***");
        System.out.println(str1);   // 金三胖是最棒的80后，我爱金三胖，金三胖棒棒的
        System.out.println(str2);   // ***是最棒的80后，我爱***，***棒棒的


        // 7、public boolean contains(CharSequence s)    // 判断字符串中是否包含指定字符串

        System.out.println(str1.contains("金三胖"));   // true
        System.out.println(str2.contains("金三胖"));   // false


        // 8、public boolean startsWith(String prefix)   // 判断字符串是否以指定字符开头
        System.out.println(str1.startsWith("金三胖")); // true
        System.out.println(str1.startsWith("金三胖是最棒的")); // true
        System.out.println(str1.startsWith("金三胖是棒的")); // false


        // 9、public String[] split(String s): 按照某个内容把字符串分割成字符串数组返回。
        String str3 = "Angelababy,杨紫,彩霞仙子,紫霞";
        String[] strs = str3.split(",");
        for (int i = 0; i < strs.length; i++) {
            System.out.print(strs[i] + "\t");
        }
    }
}
