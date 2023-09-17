package regex;

public class subString {
    public static void main(String[] args) {
        String str="他说：我很好。我说：那就好 Hello Good World";
        String regex = "[\\s：。]+";
        String[] words = str.split(regex);
        for (int i = 0 ;i<words.length;i++){
            int m =i+1;
            System.out.println("单词"+m+":"+words[i]);
        }
    }
}
