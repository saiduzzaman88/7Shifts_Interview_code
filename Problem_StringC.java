import java.lang.*;

public class Problem_StringC {

    public int add(String number)throws Exception{


        /*
        * Handling new lines in to String
        * */
        number = number.replaceAll("\r", "").replaceAll("\n", "");
        System.out.println("Given String after handling with new line: "+number);

        int result=0; //To store result after adding all numbers in string
        int i = 0;

        //All possible Delimiters list
        String delimeter = "/-,; (*&^%$#@!_)";

        //Loop to check each character until the string is over
        while (i<number.length()){

            String negative = ""; //To keep the list of negative numbers
            String temp=""; //To keep each number in a String for further adding operation

            //To separate each number from String according to Delimiters
            if(i<number.length() && Character.isDigit(number.charAt(i))){
                temp+=number.charAt(i);
                i++;

                while (i<number.length() &&Character.isDigit(number.charAt(i))){
                    temp += number.charAt(i);
                    i++;
                }
                int temp2 = Integer.parseInt(temp);
                //Bonus: numbers larger than 1000 is being ignored
                if (temp2 > 1000) {
                    temp2 = 0;
                }
                result += temp2;

            }
            //If there is negative number in the String,
            //Throw exception
            else if(i<number.length() && number.charAt(i) == '-' && Character.isDigit(number.charAt(i+1))){
                i++;
                String temp3 = ""; //to keep the negative numbers
                while (i<number.length() &&Character.isDigit(number.charAt(i))){
                    temp3 += number.charAt(i);
                    i++;
                }
                negative = negative+ '-' + temp3+ ',';
                i++;
                while (i<number.length()){

                    temp3 ="";
                    if( number.charAt(i) == '-' && Character.isDigit(number.charAt(i+1))){
                        while (i<number.length()-1 && Character.isDigit(number.charAt(i+1))){
                            i++;
                            temp3 += number.charAt(i);

                        }
                        negative = negative + '-' + temp3+ ',';
                    }
                    i++;
                }
                throw new Exception("negative numbers( "+negative + " ) are not allowed");
            }

            //If the character is a delimiter
            //by these following condition it will meet the criteria for Bonus:2,3,4 and
            //support custom Delimiter
            else if(i<number.length() && !Character.isDigit(number.charAt(i))){
                int delLen=0;
                while (delLen < delimeter.length()){
                   //checking the character is a delimiter or not
                    if(i<number.length() && number.charAt(i) == delimeter.charAt(delLen)){
                        i++;
                        break;
                    }
                    //if it's not a delimiter checking whether its a letter or not
                    else if(i<number.length() && Character.isLetter(number.charAt(i))){
                        i++;
                    }
                    //even if it is a not letter it can be a '+' sign for a positive number
                    else {
                        i++;
                        break;
                    }

                    delLen++;
                }
           }
           else {
            }

        }

        return result;
    }

    public static void main (String args[]){
        Problem_StringC obj = new Problem_StringC();

        try {
            int res = obj.add(",\n1,-20,-3");
            System.out.println("result should be: Exception for Negative numbers with list of them");
            System.out.println("result after adding: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();
        System.out.println();
        try {
            int res = obj.add("1,2,3,4,5");
            System.out.println("result should be: 15");
            System.out.println("result after adding: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();

        try {
            int res = obj.add("2,3\n,1");
            System.out.println("result should be: 6 (new line)");
            System.out.println("result after adding: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println();
        try {
            int res = obj.add("10,200,1");
            System.out.println("result should be: 211");
            System.out.println("result after adding: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        try {
            int res = obj.add("//;\n1,35,2");
            System.out.println("result should be: 38 (new line)");
            System.out.println("result after adding: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        try {
            int res = obj.add("//$\n2$3$1$2");
            System.out.println("result should be: 8 (new line)");
            System.out.println("result after adding: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        try {
            int res = obj.add("1,2000,35");
            System.out.println("result should be: 36 (2000 will be ignored)");
            System.out.println("result after adding: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        try {
            int res = obj.add("//@@@20@@@30@@@30");
            System.out.println("result should be: 80 (Delimiters of arbitrary length)");
            System.out.println("result after adding: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();

        try {
            int res = obj.add("//***20@@@30$$@10&&");
            System.out.println("result should be: 60 (Different Delimiters of arbitrary length)");
            System.out.println("result after adding: " + res);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println();



    }


}

