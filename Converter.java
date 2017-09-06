import java.util.Scanner;

class Converter{
    public static void main(String args[]){
    
    Scanner sc = new Scanner(System.in);
    
    System.out.println("Введите систему, с которой хотите перевести:");
    int sysIn = sc.nextInt();
    int sysOut = 0;
    int number = 0;
    String num = "";
    
    if(sysIn == 2 || sysIn == 8 || sysIn == 10 || sysIn == 16){
        System.out.println("Введите систему, в которую хотите перевести:");
        sysOut = sc.nextInt();
        if(sysOut == 2 || sysOut == 8 || sysOut == 10 || sysOut == 16){
            System.out.println("Введите число, которое хотите перевести:");
            
            if(sysIn == 2 || sysIn == 8 || sysIn == 10)
                number = sc.nextInt();
            else{
                num = sc.nextLine();
            }
            
            if(sysIn == 2){
                switch (sysOut){
                    case 10:
                        System.out.println("Двоичное число " + number + " в десятичной системе " + binToDeс(number));
                        break;
                    case 8:
                        System.out.println("Двоичное число " + number + " в восьмеричной системе " + decToOct(binToDeс(number)));
                        break;
                    case 16:
                        System.out.println("Двоичное число " + number + " в шестнадцатеричной системе " + decToHex(binToDeс(number)));
                        break;
                    default:
                        break;
                }
            }
            
            if(sysIn == 8){
                switch (sysOut){
                    case 10:
                        System.out.println("Восьмеричное число " + number + " в десятичной системе " + octToDeс(number));
                        break;
                    case 2:
                        System.out.println("Восьмеричное число " + number + " в двоичной системе " + decToBin(octToDeс(number)));
                        break;
                    case 16:
                        System.out.println("Восьмеричное число " + number + " в шестнадцатеричной системе " + decToHex(octToDeс(number)));
                        break;
                    default:
                        break;
                }
            }
            
            if(sysIn == 10){
                switch (sysOut){
                    case 2:
                        System.out.println("Десятичное число " + number + " в двоичной системе " + decToBin(number));
                        break;
                    case 8:
                        System.out.println("Десятичное число " + number + " в восьмеричной системе " + decToOct(number));
                        break;
                    case 16:
                        System.out.println("Десятичное число " + number + " в шестнадцатеричной системе " + decToHex(number));
                        break;
                    default:
                        break;
                }
            }
            
            if(sysIn == 16){
                switch (sysOut){
                    case 10:
                        num = sc.nextLine();
                        System.out.println("Шестнадцатеричное число " + num + " в десятичной системе " + hexToDec(num));
                        break;
                    case 8:
                        num = sc.nextLine();
                        System.out.println("Шестнадцатеричное число " + num + " в восьмеричной системе " + decToOct(hexToDec(num)));
                        break;
                    case 2:
                        num = sc.nextLine();
                        System.out.println("Шестнадцатеричное число " + num + " в двоичной системе " + decToBin(hexToDec(num)));
                        break;
                    default:
                        break;
                }
            }
        }
        else
            System.out.println("Неверная система");
    }
    else
        System.out.println("Неверная система");
}
    
    public static int decToBin(int num){
        int number = num;
        String res = " ";
        String s = Integer.toString(number % 2);
        
        while(number > 0){
            number = number/2;
            s = s + Integer.toString(number % 2);
        }
        res = new StringBuffer(s).reverse().toString();
        
        return Integer.parseInt(res);
    }
    
    public static int decToOct(int num){
        int number = num;
        String res = " ";
        String s = Integer.toString(number % 8);
        
        while(number > 0){
            number = number/8;
            s = s + Integer.toString(number % 8);
        }
        res = new StringBuffer(s).reverse().toString();
        return Integer.parseInt(res);
    
    }
    
    public static String decToHex(int num){
        int number = num;
        char hex[]={'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        int rem;
        String s = "";
        
        while(number > 0){
            
            rem = number % 16; 
            s = hex[rem] + s; 
            number = number/16;
        }
        
       // return Integer.parseInt(s);
       return s;
        
    }
    
    public static int binToDeс (int num){
        double j = 0;
        String str = Integer.toString(num);
        for(int i = 0;i < str.length();i++){
            if(str.charAt(i) == '1'){
            j = j + Math.pow(2,str.length() - 1 - i);
            }
        }
        return (int) j;
    }
    
    public static int octToDeс (int num){
        int orig;
        int decnum = 0;
        int octnum = num;
        int i = 0;
        
        orig = octnum;
        while(octnum > 0)
        {
            decnum = decnum + (octnum%10) * (int) Math.pow(8, i);
            i++;
            octnum = octnum/10;
        }
        return decnum;
    }

    public static int hexToDec(String num){
        String hexRep = "0123456789ABCDEF";
        
        int counter = num.length()-1;
        int sum = 0;

        for (char c:num.toCharArray()) {
            int i = hexRep.indexOf(c);
            sum = (int) (sum + (Math.pow(16,counter))*i);
            counter--;
        }
        return sum;
        
    }
}