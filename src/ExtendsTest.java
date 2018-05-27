public class ExtendsTest {
    static class Dad {
        String name;
        Dad(String s) {
            System.out.print(s);
            this.name = s;
        }
        public void test(){
            ;
        }
    }

    class Son extends Dad {
        Son(String s) {
            super(s);
        }
    }

    public static void main(String[] args) {
        new ExtendsTest.Dad("d");
       // ExtendsTest.new Dad("d");
    }
}


