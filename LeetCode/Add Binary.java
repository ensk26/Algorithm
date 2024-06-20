import java.util.*;

class Solution {
    StringBuilder sb = new StringBuilder();
    public String addBinary(String a, String b) {
        setBinary(a,b,0);
        
        return sb.toString();
    }

    void setBinary(String a, String b, int tem){
        if(a.length()==0 && b.length()==0){
            if(tem==1){
                sb.append('1');
            }
            return;
        }
        if(a.length()==0){
            if(tem==1 && b.charAt(b.length()-1)=='1'){
                setBinary(a, b.substring(0,b.length()-1),1);
                sb.append('0');
            }
            else if(tem==0 && b.charAt(b.length()-1)=='0'){
                setBinary(a, b.substring(0,b.length()-1),0);
                sb.append('0');
            }
            else{
                setBinary(a, b.substring(0,b.length()-1),0);
                sb.append('1');
            }
            return;
        }
        if(b.length()==0){

            if(tem==1 && a.charAt(a.length()-1)=='1'){
                setBinary(a.substring(0,a.length()-1), b,1);
                sb.append('0');
            }
            else if(tem==0 && a.charAt(a.length()-1)=='0'){
                setBinary(a.substring(0,a.length()-1), b,0);
                sb.append('0');
            }
            else{
                setBinary(a.substring(0,a.length()-1), b,0);
                sb.append('1');
            }
            return;
        }

        if(a.charAt(a.length()-1) == '1' && b.charAt(b.length()-1)=='1'){
            setBinary(a.substring(0,a.length()-1), b.substring(0,b.length()-1),1);
            if(tem==1){
                sb.append('1');
            }else{
                sb.append('0');
            }
            return;
        }

        if(a.charAt(a.length()-1) == '1' || b.charAt(b.length()-1)=='1'){

            if(tem==1){
                setBinary(a.substring(0,a.length()-1), b.substring(0,b.length()-1),1);
                sb.append('0');
            }
            else{
                setBinary(a.substring(0,a.length()-1), b.substring(0,b.length()-1),0);
                sb.append('1');
            }
            return;
        }


        setBinary(a.substring(0,a.length()-1), b.substring(0,b.length()-1),0);
        if(tem==1){
            sb.append('1');
        }else{
            sb.append('0');
        }
        return;

    }
}
