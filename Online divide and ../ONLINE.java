public class ONLINE {

    static int divideConc(char[] str)
    {

        int x=getDivideIndex(str)-1;
        if(x==Integer.MAX_VALUE)
            return str.length;
        char[] str2=new char[1000];
        for(int i=x;i<str.length;i++)
        {
            str2[i-x]=str[i];
        }
        return Math.max(x, divideConc(str2));




    }

    static int getDivideIndex(char[] str)
    {
        for(int i=0;i<str.length;i++)
        {
            boolean m=false;
            char x=str[i];
            char []z = new char[10000];
            if(x==Character.toUpperCase(x)) {
                for (int j = i + 1; j < str.length; j++) {
                    char y = str[j];
                    if (y == Character.toLowerCase(x) || new String(z).indexOf(y)==-1) {
                        m=true;
                        break;
                    }
                }
            }
            else
                for (int j = i + 1; j < str.length; j++) {
                    char y = str[j];
                    if (y == Character.toUpperCase(x) || new String(z).indexOf(y)==-1){
                        m=true;
                        break;
                    }
                }
            z[i]=x;

            if(!m)
                {
                    return i;
                }


        }
        return Integer.MAX_VALUE;

    }

    public static void main(String[] args) {
        String X="xyYAAYaxyXZa";
        System.out.println(getDivideIndex(X.toCharArray())-1);

    }
}
