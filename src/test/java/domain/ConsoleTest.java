package domain;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ConsoleTest {
    @Test
    public void getInputLottoMoneyTest1() {

        ByteArrayInputStream input = new ByteArrayInputStream(" 3000 ".getBytes());
        System.setIn(input);
        int count = Console.getInputLottoMoney();
        assertEquals(3, count);
        System.setIn(System.in);
    }

    @Test
    public void getInputLottoMoneyTest2() {
        String input = "5400";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        int count = Console.getInputLottoMoney();
        assertEquals(5, count);
    }

    @Test(expected = IllegalArgumentException.class)
    public void getInputLottoMoneyTest3() {
        String input = "50";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        int count = Console.getInputLottoMoney();
    }

    public List<Integer> getNumberOfList (int[] inputnumbers){
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 6; i ++){
            numbers.add(inputnumbers[i]);
        }
        return numbers;
    }

    @Test
    public void getWinningLottoNumberTest1() {
        String input = "1,2,3,4,5,6";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        List<Integer> numbers = getNumberOfList(new int[]{1,2,3,4,5,6});
        assertEquals(numbers,Console.getWinningLottoNumber());
    }
    @Test
    public void getWinningLottoNumberTest2() {
        String input = "1,2,3,4  ,5,  6  ";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        List<Integer> numbers = getNumberOfList(new int[]{1,2,3,4,5,6});
        assertEquals(numbers,Console.getWinningLottoNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void getWinningLottoNumberTest3() {
        String input = "1,2,3,4,5";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        List<Integer> numbers = getNumberOfList(new int[]{1,2,3,4,5,6});
        assertEquals(numbers,Console.getWinningLottoNumber());
    }

    @Test(expected = IllegalArgumentException.class)
    public void duplicateTest() {
        String input = "1,2,3,4,5,1";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        Console.getWinningLottoNumber();
    }
}