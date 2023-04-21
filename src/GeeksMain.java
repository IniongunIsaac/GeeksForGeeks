public class GeeksMain {
    public static void main(String[] args) {
        String[] s1 = {"jrjiml", "tchetn", "ucrhye", "ynayhy", "cuhffd", "cvgpoiu", "znyadv"};
        String[] s2 = {"jr", "ml", "cvgpoi", "gpoiu", "wnmkmluc", "geheqe", "uglxagyl", "uyxdroj"};
        System.out.println(prefixSuffixString(s1, s2));
    }

    public static int prefixSuffixString(String s1[],String s2[]) {

        int count = 0;
        for (String str2 : s2) {
            for (String str1 : s1) {
                if (str1.startsWith(str2) || str1.endsWith(str2)) {
                    count++;
                    break;
                }
            }
        }

        return count;
    }
}
