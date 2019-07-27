package suanfa;

import java.util.HashSet;
import java.util.Set;

//求字符串中的，最长不重复子串--java代码
public class FindMaxString {
  public static void main(String []args){
      String str1 = "hellowdhelloko";
      StringBuilder stringBuilder = new StringBuilder("hellowdhelloko");
      System.out.println(stringBuilder.delete(0,1));
      FindChileStringNoRepeat(str1);
  }

  public static void FindChileStringNoRepeat(String str){
      int length=str.length();
      int begin =0;
      int maxlength=0;

      for (int i=0;i<length;i++){
          Set charSet = new HashSet<Character>();
          charSet.add(str.charAt(i));
          int j;
          for (j=i+1;j<length;j++){
              char temp = str.charAt(j);
              //判断字符是否在集合中，如果在说明重复
              if(charSet.contains(temp)){
                  break;
              }else {
                  charSet.add(temp);
              }
          }
          //判断长度是否大于目前的长度

          if(j-i>maxlength){
              begin=i;
              maxlength=j-i;
          }


      }

      System.out.println(maxlength + " " + str.substring(begin, begin+maxlength)) ;
  }

}
