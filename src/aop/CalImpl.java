package aop;

/**
 * @Author yangwen-bo
 * @Date 2019/8/13.
 * @Version 1.0
 */
public class CalImpl implements Cal {
    @Override
    public int add(int num1, int num2) {
        int result = num1+num2;
        return result;
    }

    @Override
    public int sub(int num1, int num2) {
        int result = num1-num2;
        return result;
    }

    @Override
    public int mul(int num1, int num2) {
        int result = num1*num2;
        return result;
    }

    @Override
    public int div(int num1, int num2) {
        int result = num1/num2;
        return result;
    }
}
