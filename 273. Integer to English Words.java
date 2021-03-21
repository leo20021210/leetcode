class Solution {
    public String numberToWords(int num) {
    if (num == 0)
      return "Zero";

    int billion = num / 1000000000;
    int million = (num - billion * 1000000000) / 1000000;
    int thousand = (num - billion * 1000000000 - million * 1000000) / 1000;
    int rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000;

    String result = "";
    if (billion != 0)
      result = name(billion) + " Billion";
    if (million != 0) {
      if (! result.isEmpty())
        result += " ";
      result += name(million) + " Million";
    }
    if (thousand != 0) {
      if (! result.isEmpty())
        result += " ";
      result += name(thousand) + " Thousand";
    }
    if (rest != 0) {
      if (! result.isEmpty())
        result += " ";
      result += name(rest);
    }
    return result;
    }

    public String name(int a){
        int hun=a/100;
        String fir=numname(hun);
        int other=a%100;
        if(other==0){
            return fir+" Hundred";
        }
        String sec=numname(other);
        if(fir.equals("")){
            return sec;
        }
        return fir+" Hundred "+sec;
    }

    public String numname(int a){
        if(a==0){
            return "";
        }
        if(a==1){
            return "One";
        }
        if(a==2){
            return "Two";
        }
        if(a==3){
            return "Three";
        }
        if(a==4){
            return "Four";
        }
        if(a==5){
            return "Five";
        }
        if(a==6){
            return "Six";
        }
        if(a==7){
            return "Seven";
        }
        if(a==8){
            return "Eight";
        }
        if(a==9){
            return "Nine";
        }
        if(a==10){
            return "Ten";
        }
        if(a==11){
            return "Eleven";
        }
        if(a==12){
            return "Twelve";
        }
        if(a==13){
            return "Thirteen";
        }
        if(a==14){
            return "Fourteen";
        }
        if(a==15){
            return "Fifteen";
        }
        if(a==16){
            return "Sixteen";
        }
        if(a==17){
            return "Seventeen";
        }
        if(a==18){
            return "Eighteen";
        }
        if(a==19){
            return "Nineteen";
        }
        if(a==20){
            return "Twenty";
        }
        if(a==30){
            return "Thirty";
        }
        if(a==40){
            return "Forty";
        }
        if(a==50){
            return "Fifty";
        }
        if(a==60){
            return "Sixty";
        }
        if(a==70){
            return "Seventy";
        }
        if(a==80){
            return "Eighty";
        }
        if(a==90){
            return "Ninety";
        }
        int ten=a/10;
        String fir=numname(ten*10);
        int dig=a%10;
        String sec=numname(dig);
        if(fir!=""){
            return fir+" "+sec;
        }else{
            return sec;
        }
    }
}
