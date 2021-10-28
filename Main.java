public class Main{
    StringConcat str = (s,v) -> System.out.println(s+v);
    str.makeString("a","b");
}

interface StringConcat {
    public void makeString(String s1, String s2);
}ㅁㅇㄴsadas