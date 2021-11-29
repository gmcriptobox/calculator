

public class Calculate{
    private int a;
    private int b;
    private Operation op;
    private int result;
    private boolean rome;
    private boolean isRome(String s) {
        if(s.equals("I") ||s.equals("II") || s.equals("III")
        ||s.equals("IV") || s.equals("V")||s.equals("VI")||s.equals("VII")
        ||s.equals("VIII")||s.equals("IX")||s.equals("X"))
            return true;
        return false;
    }
    public void parser(String s) throws CalculateException {
        String[] line = s.split(" ");
        if(line.length == 0 ||line[0].equals("")&&line.length != 4 || line.length != 3)
            throw new CalculateException("format");
        int index0 = (line.length == 3)? 0 :1;
        rome = isRome(line[index0]);
        a =(rome)?Roman2Arabic.toArabic(line[index0]):Integer.parseInt(line[index0]);
        if(a < 1 || a > 10)
            throw new CalculateException("error first operand");
        if(rome != isRome(line[index0+2]))
            throw new CalculateException("error operand type");
        b =(rome)?Roman2Arabic.toArabic(line[index0+2]):Integer.parseInt(line[index0+2]);
        if(b < 1 || b > 10)
            throw new CalculateException("error second operand");
        if(line[index0 + 1].equals("+"))
            op = Operation.OP_PLUS;
        else  if(line[index0 + 1].equals("-"))
            op = Operation.OP_MIN;
        else  if(line[index0 + 1].equals("/"))
            op = Operation.OP_DIV;
        else  if(line[index0 + 1].equals("*"))
            op = Operation.OP_MULT;
        else
            throw new CalculateException("error operator");

    }
    public void setRes(){
        switch(op){
            case OP_PLUS -> {
                result = a+b;
            }
            case OP_MIN -> {
                result = a-b;
            }
            case OP_MULT -> {
                result = a*b;
            }
            case OP_DIV -> {
                result = a/b;
            }
        }
    }

    public void printResult() throws CalculateException {
        if(rome) {
            if (result < 1)
                throw new CalculateException("error");
            String s = Roman2Arabic.toRoman(result);
            System.out.println(s);
        }
        else
            System.out.println(result);
    }
}
